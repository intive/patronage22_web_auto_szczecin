package com.intive.template;

import com.intive.template.configuration.ConfigurationManager;
import io.cucumber.java.Scenario;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;


public class BrowserDriverSetup {

    private static final Logger LOGGER = LoggerFactory.getLogger(BrowserDriverSetup.class);
    public static RemoteWebDriver DRIVER;
    public static final String USERNAME = System.getenv("BROWSERSTACK_USER");
    public static final String AUTOMATE_KEY = System.getenv("BROWSERSTACK_KEY");
    public static final String BUILD = System.getenv("BUILD");
    public static final String BROWSERSTACK_URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";

    private static String getBrowserName() {
        return System.getProperty("browser", "chrome");
    }

    public static void startDriver(String scenarioName) throws MalformedURLException {

        //This is rather for fun for BrowserStack , will be removed later
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy.MM.dd");
        String buildName = String.format("Szczecin JS %s:%s",BUILD,simpleDateFormat.format(new Date()));

        switch (getBrowserName().toLowerCase()) {
            case "chrome" -> DRIVER = new ChromeDriver();
            case "firefox" -> DRIVER = new FirefoxDriver();
            case "bs_chrome" -> {
                //Create TODO to implement this on all browser level
                ConfigurationManager configurationManager = new ConfigurationManager();
                Map<String, String> capabilities_browser = configurationManager.getBrowserConfiguration();
                capabilities_browser.put("build",buildName);
                capabilities_browser.put("name",scenarioName);
                DesiredCapabilities caps = new DesiredCapabilities(capabilities_browser);
                DRIVER = new RemoteWebDriver(new URL(BROWSERSTACK_URL), caps);
                DRIVER.manage().window().maximize();
            }
            case "chrome_mobile" -> {
                Map<String, String> mobileEmulation = new HashMap<>();
                mobileEmulation.put("deviceName", "Nexus 7");
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.setExperimentalOption("mobileEmulation", mobileEmulation);
                DRIVER = new ChromeDriver(chromeOptions);
            }
            default -> throw new IllegalStateException("Unsupported browser name!!!!");
        }
        DRIVER.manage().window().maximize();
    }

    public static void destroyDriver() {
        DRIVER.quit();
    }

    private static void embedScreenshot(Scenario scenario) {
        byte[] screenshot = DRIVER.getScreenshotAs(OutputType.BYTES);
        scenario.attach(screenshot, "image/png", "screenshot");
    }

    private static void saveScreenshotFile(Scenario scenario) throws IOException {
        File srcFile = ((TakesScreenshot) DRIVER).getScreenshotAs(OutputType.FILE);
        String currentPath = Paths.get(".").toAbsolutePath().normalize().toString();
        FileUtils.copyFile(srcFile, new File(currentPath + "/screenshots/" + scenario.getName()
                + "-" + new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date()) + ".png"));
    }

    private static void reportToBrowserStack(String result) {
        if (getBrowserName().equalsIgnoreCase("bs_chrome")) {
            JavascriptExecutor jse = DRIVER;
            String bsScript = String.format("browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\": \"%s\"}}",result);
            jse.executeScript(bsScript);
        }
    }

    public static void processExecutedScenario(Scenario scenario) throws IOException {
        String status = (scenario.isFailed() ? "FAILED" : "SUCCESS");
        LOGGER.info("======================== SCENARIO FINISHED WITH " + status + " STATUS ===================\n");
        if (scenario.isFailed() && DRIVER != null) {
            reportToBrowserStack("failed");
            embedScreenshot(scenario);
            saveScreenshotFile(scenario);
        } else if (!scenario.isFailed() && DRIVER != null) {
            reportToBrowserStack("passed");
        }

        destroyDriver();
        LOGGER.info("================= CLEANUP AFTER SCENARIO =================\n");
    }
}

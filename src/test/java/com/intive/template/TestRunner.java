package com.intive.template;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = "com.intive.template",
        plugin = {"pretty", "json:target/cucumber-reports.json",
                "html:target/cucumber-reports.html",
                "junit:target/cucumber-reports.xml"}
)
public class TestRunner {

    @BeforeClass
    public static void setup() {
        switch (System.getProperty("browser", "chrome").toLowerCase()) {
            case "chrome", "bs_chrome", "chrome_mobile" -> WebDriverManager.chromedriver().setup();
            case "firefox" -> WebDriverManager.firefoxdriver().setup();
            default -> throw new IllegalStateException("Unsupported browser name for WebDriverManager !!!!");
        }
    }
}

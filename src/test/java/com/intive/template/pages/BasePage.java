package com.intive.template.pages;

import com.intive.template.BrowserDriverSetup;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public abstract class BasePage {

    public final RemoteWebDriver driver;

    protected BasePage() {
        this.driver = BrowserDriverSetup.DRIVER;
        PageFactory.initElements(this.driver, this);
        setupTimeouts();
    }

    private void setupTimeouts() {
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5L));
    }
}

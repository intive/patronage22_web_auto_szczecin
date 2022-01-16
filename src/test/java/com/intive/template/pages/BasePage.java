package com.intive.template.pages;

import com.intive.template.BrowserDriverSetup;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {

    public final RemoteWebDriver driver;

    protected BasePage() {
        this.driver = BrowserDriverSetup.DRIVER;
        PageFactory.initElements(this.driver, this);
    }
}

package com.intive.template.pages;

import org.openqa.selenium.JavascriptExecutor;

public class PatronagePage extends BasePage {

    private static final String PATRONAGE_URL = "https://patronage22-szczecin-js.vercel.app/";

    public void openPatronagePage() {
        driver.get(PATRONAGE_URL);
    }

    public boolean patronagePageIsOpened() {
        String readyState = ((JavascriptExecutor) driver).executeScript("return document.readyState").toString();
        return readyState.equals("complete");
    }
}
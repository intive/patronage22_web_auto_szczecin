package com.intive.template.pages;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.io.IOException;

public class HomePage extends BasePage {

    private static final String PATRONAGE_URL = "https://patronage22-szczecin-js.vercel.app/";

    @FindBy(how = How.XPATH, using = "/html/body/div/div/header")
    WebElement headerComponent;

    @FindBy(how = How.XPATH, using = "/html/body/div/div/header/div/a")
    WebElement logo;

    @FindBy(how = How.XPATH, using = "/html/body/div/div/header/div/a/p")
    WebElement headerTitle;

    public void openHomePage() {
        driver.get(PATRONAGE_URL);
    }

    public boolean isPageLoaded() {
        String readyState = ((JavascriptExecutor) driver).executeScript("return document.readyState").toString();
        return readyState.equals("complete");
    }

    public Integer getWebResponseStatusCode() throws IOException {
        // Example how we can use okHttp
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        Request request = new Request.Builder()
                .url(PATRONAGE_URL)
                .method("GET", null)
                .build();
        return client.newCall(request).execute().code();
    }

    public boolean isCorrectPage() {
        String currentUrl = driver.getCurrentUrl();
        return currentUrl.equals(PATRONAGE_URL);
    }

    public boolean headerIsDisplayed() {
        return headerComponent.isDisplayed();
    }

    public void clickOnLogo() {
        logo.click();
    }

    public boolean logoIsDisplayed() { return logo.isDisplayed(); }

    public String titleOfHeaderIsDisplayed() {
        return headerTitle.getText();
    }

    public String headerIsSticky() {
        return headerComponent.getCssValue("position");
    }

    public String headerBackgroundIsSet() {
        String colorBackground = headerComponent.getCssValue("background-color");
        return Color.fromString(colorBackground).asHex();
    }
}


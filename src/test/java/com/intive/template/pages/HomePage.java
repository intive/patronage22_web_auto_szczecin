package com.intive.template.pages;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.io.IOException;
import java.util.List;

public class HomePage extends BasePage {

    private static final String PATRONAGE_URL = "https://patronage22-szczecin-js.vercel.app/";

    @FindBy(how = How.XPATH, using = "/html/body/div/div/header")
    WebElement headerComponent;

    @FindBy(how = How.XPATH, using = "/html/body/div/div/header/div/a")
    WebElement logo;

    @FindBy(how = How.XPATH, using = "//p[contains(text(), ' card') and /html/body/div/div/main/div/div]")
    List<WebElement> cardsCounters;

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

    public boolean isCardsCounterDisplayed(int i) {
        return cardsCounters.get(i).isDisplayed();
    }

    public String getCardsCounter(int i) {
        return cardsCounters.get(i).getText();
    }

    public String getCardsCounterFixed(int i) {
        String cardsCounterFixed;
        cardsCounterFixed = cardsCounters.get(i).getText().substring(0, cardsCounters.get(i).getText().indexOf(" "));

        int counterParsedToInt = Integer.parseInt(cardsCounterFixed);

        if (counterParsedToInt == 1)
            return cardsCounterFixed + " card";
        else if (counterParsedToInt == 0 || counterParsedToInt > 1)
            return cardsCounterFixed + " cards";
        else {
            System.err.println("Cards counter invalid value");
            return "Cards counter invalid value";
        }
    }

    public int getCardCountersAmount() {
        return cardsCounters.size();
    }

}

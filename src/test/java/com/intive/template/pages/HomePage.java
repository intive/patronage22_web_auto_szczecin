package com.intive.template.pages;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class HomePage extends BasePage {

    private static final String PATRONAGE_URL = "https://patronage22-szczecin-js.vercel.app/";

    @FindBy(how = How.XPATH, using = "/html/body/div/div/header")
    WebElement headerComponent;

    @FindBy(how = How.XPATH, using = "/html/body/div/div/header/div/a")
    WebElement logo;

    @FindBy(how = How.XPATH, using = "//p[contains(text(), ' card') and /html/body/div/div/main/div/div]")
    List<WebElement> cardsCounters;

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
        return headerComponent.isDisplayed(); }

    public void clickOnLogo() {
        logo.click();
    }

    public boolean isCardsCountersDisplayed() {
        for (WebElement counter : cardsCounters) {
            if (!counter.isDisplayed())
                return false;
        }
        return true;
    }

    public List<String> getCardsCountersList() {
        List<String> cardsCountersList = new ArrayList<>();
        for (WebElement counter : cardsCounters)
            cardsCountersList.add(counter.getText());
        return cardsCountersList;
    }

    public boolean checkCardsCount(String element) {
        String cardsNumber = element.substring(0, element.indexOf(" "));
        String cardsWord = element.substring(element.indexOf(" "));
        int count = Integer.parseInt(cardsNumber);

        return ((count == 0 || count > 1) && cardsWord.equals(" cards"))
                || (count == 1 && cardsWord.equals(" card"));
    }

    public boolean isCardsCountersDisplayedProperly() {
        for (String counter : getCardsCountersList()) {
            if (!checkCardsCount(counter))
                return false;
        }
        return true;
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

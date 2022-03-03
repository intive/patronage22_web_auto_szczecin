package com.intive.template.pages;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
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

    public boolean areCardsCountersDisplayed() {
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

    /*public String getElementsCount(String element, String elementSingular) {
        String elementsCountFixed = element.substring(0, element.indexOf(" "));
        int amount = Integer.parseInt(elementsCountFixed);
        elementsCountFixed = elementsCountFixed + " " + elementSingular;

        if (amount == 1)
            return elementsCountFixed;
        else if (amount == 0 || amount > 1)
            return elementsCountFixed + "s";
        else
            return "wrong count";
    }

    public boolean checkElementsCounters(String singularElementAmount, List<String> listOfElements) {
        String elementsCountFixed;

        for (String counter : listOfElements) {
            elementsCountFixed = getElementsCount(counter,singularElementAmount);
            if ( elementsCountFixed.equals("wrong count") || !counter.equals(elementsCountFixed))
                return false;
        }
        return true;
    }*/

    public String getCardsCount(String element) {
            String elementsCountFixed = element.substring(0, element.indexOf(" "));
            int amount = Integer.parseInt(elementsCountFixed);
            elementsCountFixed = elementsCountFixed + " card";

            if (amount == 1)
                return elementsCountFixed;
            else if (amount == 0 || amount > 1)
                return elementsCountFixed + "s";
            else
                return "wrong count";
        }

        public boolean checkCardsCounters() {
            String elementsCountFixed;

            for (String counter : getCardsCountersList()) {
                elementsCountFixed = getCardsCount(counter);
                if ( elementsCountFixed.equals("wrong count") || !counter.equals(elementsCountFixed))
                    return false;
            }
            return true;
    }

}

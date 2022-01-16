package com.intive.template.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class GooglePage extends BasePage {

    private static final String GOOGLE_URL = "https://www.google.com/";

    @FindBy(how = How.ID, using = "L2AGLb")
    WebElement popupAgreeButton;
    @FindBy(how = How.NAME, using = "q")
    WebElement searchField;
    @FindBy(how = How.ID, using = "rcnt")
    WebElement searchResults;

    public void openGooglePage() {
        driver.get(GOOGLE_URL);
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(searchField));
    }

    public void closePopupMessage() {
        popupAgreeButton.click();
    }

    public void searchInGoogle(String searchPhrase) {
        searchField.sendKeys(searchPhrase);
        searchField.sendKeys(Keys.ENTER);
    }

    public boolean isSearchResultsVisible() {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(searchResults));
        return searchResults.isDisplayed();
    }

}

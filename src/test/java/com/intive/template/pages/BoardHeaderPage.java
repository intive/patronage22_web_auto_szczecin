package com.intive.template.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BoardHeaderPage extends BasePage {

    @FindBy(how = How.XPATH, using = "//a[contains(@href,'/')]")
    WebElement returnToMainBoardLink;

    @FindBy(how = How.XPATH, using = "/html/body/div/section/div/h1")
    WebElement title;

    @FindBy(how = How.XPATH, using = "//button[normalize-space(text()='New Column')]")
    WebElement newColumnButton;

    @FindBy(how = How.XPATH, using = "/html/body/div/div/a[1]/h4")
    WebElement boardsFromDbBoard1Page;
    
    public boolean isReturnToMainBoardLinkVisible() {
        return returnToMainBoardLink.isDisplayed();
    }

    public boolean isTitleVisible() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOf(title));
        return title.isDisplayed();
    }

    public boolean isNewColumnButtonVisible() {
        return newColumnButton.isDisplayed();
    }

    public void clickOnReturnToMainBoardLink() {
        returnToMainBoardLink.click();
    }

    public void clickOnBoardsFromDbBoard1Button() {
        boardsFromDbBoard1Page.click();
    }
}


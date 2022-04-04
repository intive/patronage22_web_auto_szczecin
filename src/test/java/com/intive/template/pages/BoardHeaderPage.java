package com.intive.template.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BoardHeaderPage extends BasePage {

    @FindBy(how = How.XPATH, using = "//section[@data-testid='board-header']/a")
    WebElement returnToMainBoardLink;

    @FindBy(how = How.XPATH, using = "/html/body/div/section/div/h1")
    WebElement title;

    @FindBy(how = How.XPATH, using = "//button[normalize-space(text()='New Column')]")
    WebElement newColumnButton;
    
    public boolean isReturnToMainBoardLinkVisible() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOf(returnToMainBoardLink));
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
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOf(returnToMainBoardLink));
        returnToMainBoardLink.click();
    }
}


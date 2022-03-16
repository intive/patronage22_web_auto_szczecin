package com.intive.template.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class BoardHeaderPage extends BasePage {

    @FindBy(how = How.XPATH, using = "/html/body/div/section/a")
    WebElement returnToMainBoardLink;

    @FindBy(how = How.XPATH, using = "/html/body/div/header/div")
    WebElement title;

    @FindBy(how = How.XPATH, using = "/html/body/div/section/div/button")
    WebElement newColumnButton;

    @FindBy(how = How.XPATH, using = "/html/body/div/div/a[1]/h4")
    WebElement boardsFromDbBoard1Page;
    
    public boolean isReturnToMainBoardLinkVisible() {
        return returnToMainBoardLink.isDisplayed();
    }

    public boolean isTitleVisible() {
        return title.isDisplayed();
    }

    public boolean isNewColumnButtonVisible() {
        return newColumnButton.isDisplayed();
    }

    public void clickOnReturnToMainBoardLink() {
        returnToMainBoardLink.click();
    }

    public void clickOnBoardsFromDbBoard1Button() {boardsFromDbBoard1Page.click();}
}


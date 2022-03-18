package com.intive.template.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.lang.CharSequence;
import java.util.logging.Logger;

public class CreateNewCardPage extends BasePage {
    @FindBy(how = How.XPATH, using = "/html/body/div/div/div[2]/div[1]/button")
    WebElement addCardButton;

    @FindBy(how = How.XPATH, using = "/html/body/div/div/div[2]/div[1]/textarea")
    WebElement newColumnNameTextArea;

    @FindBy(how = How.XPATH, using = "/html/body/div/div/div[2]/div[1]/div/button[2]")
    WebElement saveButton;

    @FindBy(how = How.XPATH, using = "/html/body/div/div/div[2]/div[2]/div[1]")
    WebElement mostRecentCard;


    public void enterTextInNewColumnNameTextArea(CharSequence text) {
        newColumnNameTextArea.sendKeys(text);
    }

    public boolean isRecentCardDisplayed() {
        return mostRecentCard.isDisplayed();
    }

    public void clickAddCardButton() {
        addCardButton.click();
    }

    public void clickSaveButton() {
        saveButton.click();
    }

    public String getTextOnCard() {
        return getTextFromRelativeXpath(mostRecentCard, ".//div[1]");
    }

    public String getAuthorOnCard() {
        return getTextFromRelativeXpath(mostRecentCard, ".//div[2]/span[1]");
    }

    public String getFavoriteIconNameOnCard() {
        return getTextFromRelativeXpath(mostRecentCard, ".//div[2]/span[contains(@class, 'material-icons')]");
    }

    private String getTextFromRelativeXpath(WebElement parent, String xpath) {
        WebElement childElement = parent.findElement(By.xpath(xpath));
        return childElement.getText();
    }
}

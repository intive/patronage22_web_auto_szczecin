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

    WebElement mostRecentCard = null;

    public void enterTextInNewColumnNameTextArea(CharSequence text) {
        newColumnNameTextArea.sendKeys(text);
    }

    public void clickAddCardButton() {
        addCardButton.click();
    }

    public void clickSaveButton() {
        saveButton.click();
    }

    public WebElement getMostRecentCard() {
        if (mostRecentCard == null) {
            mostRecentCard = driver.findElement(By.xpath("/html/body/div/div/div[2]/div[2]/div[1]"));
        }
        return mostRecentCard;
    }

    public String getTextOnCard() {
        return getTextFromRelativeXpath(getMostRecentCard(), ".//div[1]");
    }

    public String getAuthorOnCard() {
        return getTextFromRelativeXpath(getMostRecentCard(), ".//div[2]/span[1]");
    }

    public String getFavoriteIconNameOnCard() {
        return getTextFromRelativeXpath(getMostRecentCard(), ".//div[2]/span[contains(@class, 'material-icons')]");
    }

    private String getTextFromRelativeXpath(WebElement parent, String xpath) {
        if (parent == null) return null;
        WebElement childElement = parent.findElement(By.xpath(xpath));
        if (childElement == null) return null;
        return childElement.getText();
    }
}

package com.intive.template.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.lang.CharSequence;

import static io.cucumber.messages.internal.com.fasterxml.jackson.databind.cfg.CoercionInputShape.String;
import static org.apache.commons.lang.StringEscapeUtils.escapeHtml;

public class CreateNewCardPage<CARD_NAME> extends BasePage {
    @FindBy(how = How.XPATH, using = "/html/body/div/div/main/div[2]/div[1]/button")
    WebElement addCardButton;

    @FindBy(how = How.XPATH, using = "/html/body/div/div/main/div[2]/div[1]/textarea")
    WebElement newColumnNameTextArea;

    @FindBy(how = How.XPATH, using = "/html/body/div/div/main/div[2]/div[1]/div/button[2]")
    WebElement saveButton;

    @FindBy(how = How.XPATH, using = "/html/body/div/div/main/div[2]/div[1]/div/button[2]")
    WebElement newCard;

    public void enterTextInNewColumnNameTextArea(CharSequence text) {
        newColumnNameTextArea.sendKeys(text);
    }

    public void clickAddCardButton() {
        addCardButton.click();
    }

    public void  clickSaveButton() {
        saveButton.click();
    }

    public WebElement getMostRecentCard() {
        return driver.findElement(By.xpath("/html/body/div/div/main/div[2]/div[2]/div[1]"));
    }

    public String getTextOnCard(WebElement card) {
        return getTextFromRelativeXpath(card, ".//div[1]");
    }

    public String getAuthor(WebElement card) {
        return getTextFromRelativeXpath(card, ".//div[2]/span[1]");
    }

    public String getFavoriteIconName(WebElement card) {
        return getTextFromRelativeXpath(card, ".//div[2]/span[contains(@class, 'material-icons')]");
    }

    private String getTextFromRelativeXpath(WebElement parent, String xpath) {
        WebElement childElement = parent.findElement(By.xpath(xpath));
        if (childElement == null) return null;
        return childElement.getText();
    }
}


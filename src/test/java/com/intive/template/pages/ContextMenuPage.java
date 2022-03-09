package com.intive.template.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.time.Duration;

public class ContextMenuPage extends BasePage {

    @FindBy(how = How.XPATH, using = "/html/body/div/div/main/div[1]/div[2]/div/div/button")
    WebElement triggerButton;
    @FindBy(how = How.XPATH, using = "/html/body/div/div/main/div[1]/div[2]/div/div/nav")
    WebElement openContextMenu;
    @FindBy(how = How.XPATH, using = "/html/body/div/div/main/div[1]/div[2]/div/div/nav/ul")
    WebElement listOfItems;
    @FindBy(how = How.ID, using = "__next")
    WebElement item;
    @FindBy(how = How.CLASS_NAME, using = "container")
    WebElement placeOutsideContextMenu;

    public void clickOnTriggerButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOf(triggerButton));
        triggerButton.click();
    }

    public boolean isContextMenuOpen() {
        return openContextMenu.isDisplayed();
    }

    //returns true if the context menu contains 2 items or false if it contains less or more than 2 items
    public boolean isListContainsTwoItems() {
        List<WebElement> optionsList = listOfItems.findElements(By.cssSelector("li"));
        int items = optionsList.size();
        for (WebElement li : optionsList) {
            if (!li.isDisplayed() || items != 2) {
                return false;
            }
        }
        return true;
    }

    public void clickOnItem() {
        item.click();
    }

    public void clickOutsideTheContextMenu() {
        placeOutsideContextMenu.click();
    }

    public boolean isContextMenuClosed() {
        return !openContextMenu.isDisplayed();
    }
}

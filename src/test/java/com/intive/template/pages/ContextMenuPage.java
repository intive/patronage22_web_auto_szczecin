package com.intive.template.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.time.Duration;

public class ContextMenuPage extends BasePage {

    @FindBy(how = How.XPATH, using = "//a[@data-testid='board-tile'][1]//div[@data-testid='context-menu']/button")
    WebElement triggerButton;
    @FindBy(how = How.XPATH, using = "//a[@data-testid='board-tile'][1]//div[@data-testid='context-menu']/nav")
    WebElement openContextMenu;
    @FindBy(how = How.XPATH, using = "//a[@data-testid='board-tile'][1]//div[@data-testid='context-menu']/nav/ul")
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
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOf(openContextMenu));
        return openContextMenu.isDisplayed();
    }

    // returns true if the context menu contains exactly the number of items provided or false if it contains fewer
    // or more items than the number specified
    public boolean isListContainsItems(int itemsNumber) {
        List<WebElement> optionsList = listOfItems.findElements(By.cssSelector("li"));
        int items = optionsList.size();
        for (WebElement li : optionsList) {
            if (!li.isDisplayed() || items != itemsNumber) {
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

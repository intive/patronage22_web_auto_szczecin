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
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

    @FindBy(how = How.CSS, using = "#__next > div > main > div.sc-3c8adf34-0.isvBOn > div:nth-child(2) > div > div > button > span")
    WebElement triggerButton;
    @FindBy(how = How.XPATH, using = "/html/body/div/div/main/div[1]/div[2]/div/div/nav")
    WebElement openContextMenu;
    @FindBy(how = How.XPATH, using = "/html/body/div/div/main/div[1]/div[2]/div/div/nav/ul")
    WebElement listOfItems;
    @FindBy(how = How.CSS, using = "#__next > div > main > div.sc-3c8adf34-0.isvBOn > div:nth-child(2) > div > div > nav > ul > li:nth-child(1)")
    WebElement item;
    @FindBy(how = How.CLASS_NAME, using = "container")
    WebElement placeOutsideContextMenu;

    public void clickOnTriggerButton() {
        wait.until(ExpectedConditions.visibilityOf(triggerButton));
        triggerButton.click();
    }

    public boolean contextMenuIsOpen() {
        return openContextMenu.isDisplayed();
    }

    public boolean listContainsTwoItems() {
        List<WebElement> optionsList = listOfItems.findElements(By.cssSelector("li"));
        int i = optionsList.size();
        System.out.println(i);
        for (WebElement li : optionsList) {
            if (!li.isDisplayed() || i != 2) {
                return false;
            }
        }
        return true;
    }

    public void clickOnItem() {
        wait.until(ExpectedConditions.visibilityOf(listOfItems));
        item.click();
    }

    public void clickOutsideTheContextMenu() {
        placeOutsideContextMenu.click();
    }

    //returns true if the context menu is closed and false if it is displayed
    public boolean contextMenuShouldBeClose() {
        return !openContextMenu.isDisplayed();
    }
}

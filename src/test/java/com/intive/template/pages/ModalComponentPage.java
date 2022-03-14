package com.intive.template.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ModalComponentPage extends BasePage{

    @FindBy(how = How.XPATH, using = "/html/body/div/div/button[1]")
    WebElement openModalButton;

    @FindBy(how = How.XPATH, using = "/html/body/div[2]/div[2]/div[3]/button[1]")
    WebElement modalCancelButton;

    @FindBy(how = How.XPATH, using = "/html/body/div[2]/div[2]/div[3]/button[2]")
    WebElement modalContinueButton;

    @FindBy(how = How.XPATH, using = "//html")
    WebElement outsideArea;

    public boolean isOpenModalButtonVisible() {
        return openModalButton.isDisplayed();
    }

    public void clickOpenModalButton() { openModalButton.click(); }

    public boolean isModalCancelButtonVisible() { return modalCancelButton.isDisplayed(); }

    public void clickOnCancelButton() { modalCancelButton.click();}

    public boolean isModalContinueButtonVisible() { return modalContinueButton.isDisplayed(); }

    public void clickOnContinueButton() { modalContinueButton.click(); }

    public void clickOnOutsideAreaToCloseModal() { outsideArea.click(); }
}

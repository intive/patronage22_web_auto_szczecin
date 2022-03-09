package com.intive.template.steps;

import com.intive.template.pages.ContextMenuPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class ContextMenuStepdefs {
    ContextMenuPage contextMenuPage = new ContextMenuPage();

    @When("Click on trigger button")
    public void clickOnTriggerButton() {
        contextMenuPage.clickOnTriggerButton();
    }

    @And("Context menu is open")
    public void contextMenuIsOpen() {
        assertThat("Context menu is open", contextMenuPage.isContextMenuOpen(), is(true));
    }

    @And("The list of items contains two items")
    public void theListOfItemsContainsTwoItems() {
        assertThat("The list of items contains two items", contextMenuPage.isListContainsTwoItems(), is(true));
    }

    @And("Click on item")
    public void clickOnItem() {
        contextMenuPage.clickOnItem();
    }

    @And("Click outside the context menu")
    public void clickOutsideTheContextMenu() {
        contextMenuPage.clickOutsideTheContextMenu();
    }

    @Then("Context menu is close")
    public void contextMenuIsClose() {
        assertThat("Context menu is not close", contextMenuPage.isContextMenuClosed(), is(true));
    }
}

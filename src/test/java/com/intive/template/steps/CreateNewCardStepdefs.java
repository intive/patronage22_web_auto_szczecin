package com.intive.template.steps;

import com.intive.template.pages.CreateNewCardPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.hamcrest.core.IsNull;

import java.io.IOException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.equalTo;

public class CreateNewCardStepdefs {
    CreateNewCardPage createNewCardPage = new CreateNewCardPage();

    @When("Click \"Add card\" button")
    public void clickAddCardButton() {
        createNewCardPage.clickAddCardButton();
    }

    @When("Type {string} in the textarea")
    public void addTextToTheItem(String text) {
        createNewCardPage.enterTextInNewColumnNameTextArea(text);
    }

    @When("Click \"Save\" button")
    public void clickSaveButton() {
        createNewCardPage.clickSaveButton();
    }

    @Then("New card with {string} as card content, {string} as author and favorite icon is displayed")
    public void newCardIsCreated(String cardContent, String author) {
        assertThat("New card is not displayed", createNewCardPage.isRecentCardDisplayed(), is(true));
        assertThat(String.format("Most recent card does not contain \"%s\" in card content", cardContent), createNewCardPage.getTextOnCard(), is(equalTo(cardContent)));
        assertThat("Wrong Author is on most recent card", createNewCardPage.getAuthorOnCard(), is(equalTo(author)));
        assertThat("No Favorite icon on most recent card", createNewCardPage.getFavoriteIconNameOnCard(), is("favorite_border"));
    }
}
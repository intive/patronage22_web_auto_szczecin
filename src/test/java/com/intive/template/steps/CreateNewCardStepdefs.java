package com.intive.template.steps;

import com.intive.template.pages.CreateNewCardPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.hamcrest.core.IsNull;
import org.openqa.selenium.WebElement;

import static org.apache.commons.lang.StringEscapeUtils.escapeHtml;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;


import java.io.IOException;


public class CreateNewCardStepdefs {
//JButton button = new JButton("Add card");
//button.addActionListener(new ActionListener() {
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

    @Then("New card with {string} text, author and favorite icon is displayed")
    public void newCardIsCreated(String text) throws IOException {
        WebElement mostRecentCard = createNewCardPage.getMostRecentCard();
        assertThat("New card is not displayed", mostRecentCard, is(IsNull.notNullValue()));
        assertThat("Most recent card does not contain \"" + text + "\" text", createNewCardPage.getTextOnCard(mostRecentCard), is(equalTo(text)));
        // @TODO: Replace hardcoded user name with actual dynamic value when implemented
        assertThat("Wrong Author is on most recent card", createNewCardPage.getAuthor(mostRecentCard), is(equalTo("Isaak Newton")));
        assertThat("No Favorite icon on most recent card", createNewCardPage.getFavoriteIconName(mostRecentCard), is("favorite_border"));
    }
}
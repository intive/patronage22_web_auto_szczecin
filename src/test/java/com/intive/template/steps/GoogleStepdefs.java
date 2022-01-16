package com.intive.template.steps;

import com.intive.template.pages.GooglePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class GoogleStepdefs {

    GooglePage googlePage = new GooglePage();

    @Given("Google page is opened")
    public void googlePageIsOpened() {
        googlePage.openGooglePage();
    }

    @When("I close popup message")
    public void iClosePopupMessage() {
        googlePage.closePopupMessage();
    }

    @And("I search for phrase {string}")
    public void iSearchForPhrase(String searchPhrase) {
        googlePage.searchInGoogle(searchPhrase);
    }

    @Then("I can see search result page")
    public void iCanSeeSearchResultPage() {
        assertThat("Search result was not visible", googlePage.isSearchResultsVisible(), is(true));

    }


}

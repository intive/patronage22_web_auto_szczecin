package com.intive.template.steps;

import com.intive.template.pages.HomePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class HomePageStepdefs {

    HomePage homePage = new HomePage();

    @Given("Open home page")
    public void openHomePage() {
        homePage.openHomePage();
    }

    @Then("Home page is loaded and opened")
    public void homePageIsLoadedAndOpened() {
        assertThat("Home page is loaded", homePage.isPageLoaded(), is(true));
        assertThat("Home page is opened", homePage.isCorrectPage(), is(true));
    }
}

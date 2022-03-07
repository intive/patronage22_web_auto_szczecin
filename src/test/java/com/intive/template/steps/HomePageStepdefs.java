package com.intive.template.steps;

import com.intive.template.pages.HomePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.io.IOException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class HomePageStepdefs {

    HomePage homePage = new HomePage();

    @Given("Open home page")
    public void openHomePage() {
        homePage.openHomePage();
    }

    @Then("Home page is loaded and opened")
    public void homePageIsLoadedAndOpened() throws IOException {
        assertThat("Home page is not loaded", homePage.isPageLoaded(), is(true));
        assertThat("Home page is not opened", homePage.isCorrectPage(), is(true));
        assertThat("The status code was not 200", homePage.getWebResponseStatusCode(), is(equalTo(200)));
    }

    @Then("Header component is visible")
    public void headerIsVisible() {
        assertThat("Header component is not visible", homePage.headerIsDisplayed(), is(true));
    }

    @When("Click on logo")
    public void clickOnLogo(){
        homePage.clickOnLogo();
    }

    @When("Logo is visible")
    public void logoIsVisible() {
        assertThat("Header logo is not visible", homePage.logoIsDisplayed(), is(true));
    }

    @Then("{string} title of header is visible and readable")
    public void titleOfHeaderIsVisibleAndReadable(String titleOfHeader) {
        Assert.assertEquals("Title of header is not visible", homePage.titleOfHeaderIsDisplayed(), titleOfHeader);
    }

    @Then("Header is {string}")
    public void headerIsSticky(String position) {
        Assert.assertEquals("Header is not sticky", homePage.headerIsSticky(), position);
    }

    @Then("{string} color of background should be visible")
    public void bodyBackgroundShouldBeVisible(String value) {
        Assert.assertEquals("Background color is different", homePage.headerBackgroundIsSet(), value);
    }
}
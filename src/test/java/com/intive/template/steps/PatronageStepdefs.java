package com.intive.template.steps;

import com.intive.template.pages.PatronagePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class PatronageStepdefs {

    PatronagePage patronagePage = new PatronagePage();

    @Given("Open Patronage page")
    public void openPatronagePage() {
        patronagePage.openPatronagePage();
    }

    @Then("Patronage page is opened")
    public void patronagePageIsOpened() {
        assertThat("Patronage page is opened", patronagePage.patronagePageIsOpened(), is(true));
    }
}

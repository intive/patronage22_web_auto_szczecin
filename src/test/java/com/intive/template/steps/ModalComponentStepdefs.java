package com.intive.template.steps;

import com.intive.template.pages.ModalComponentPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class ModalComponentStepdefs {

    ModalComponentPage modalComponentPage = new ModalComponentPage();

    @When("User click on 'Click to Open Modal' button")
    public void clickOnOpenModalButton() {
        modalComponentPage.clickOpenModalButton();
    }

    @Then("Cancel and Continue buttons are visible")
    public void modalComponentContainsExpectedButtons() {
        assertThat("Modal component should contain Cancel button", modalComponentPage.isModalCancelButtonVisible(), is(true));
        assertThat("Modal component should contain Continue button", modalComponentPage.isModalContinueButtonVisible(), is(true));
    }

    @Then("Click on Cancel button")
    public void clickOnCancelButton() { modalComponentPage.clickOnCancelButton();
    }
    @Then("Click on Continue button")
    public void clickOnContinueButton() {modalComponentPage.clickOnContinueButton();
    }

    @Then("Click outside modal component to close it")
    public void clickOnOutsideArea() { modalComponentPage.clickOnOutsideAreaToCloseModal();
    }

}

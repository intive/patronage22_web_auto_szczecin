package com.intive.template.steps;

import com.intive.template.pages.BoardHeaderPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class BoardHeaderStepdefs {

    BoardHeaderPage boardHeaderPage = new BoardHeaderPage();

    @Then("Board header component contains Return to main board text, title and new column button")
    public void boardHeaderContainsExpectedElements() {
        assertThat("Board header component should contains Return to main board link", boardHeaderPage.isReturnToMainBoardLinkVisible(), is(true));
        assertThat("Board header component should contains Title", boardHeaderPage.isTitleVisible(), is(true));
        assertThat("Board header component should contains New column button", boardHeaderPage.isNewColumnButtonVisible(), is(true));
    }

    @When("Click on Return to main board text")
    public void clickOnReturnToMainBoardText() {
        boardHeaderPage.clickOnReturnToMainBoardLink();
    }

}


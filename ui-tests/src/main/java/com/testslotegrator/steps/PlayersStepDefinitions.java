package com.testslotegrator.steps;

import com.testslotegrator.WebDriverHelper;
import com.testslotegrator.pageobjects.PlayersPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class PlayersStepDefinitions {

    private PlayersPage playersPage;

    @Then("table of the scrolls is loaded")
    public void tableScrollsIsLoaded() {
        playersPage = new PlayersPage(WebDriverHelper.getDriver());
        playersPage.checkMainPage();
        playersPage.tableScrollsIsLoaded();
    }

    @When("sort by {string}")
    public void sortBy(String columnName) {
        playersPage = new PlayersPage(WebDriverHelper.getDriver());
        playersPage.tableColumnClick(columnName);
    }

    @Then("table is sorted by the selected {string}")
    public void tableIsSortedByTheSelected(String columnName) {
        playersPage = new PlayersPage(WebDriverHelper.getDriver());
        playersPage.checkTableSortedBy(columnName);
    }
}

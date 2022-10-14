package com.testslotegrator.steps;

import com.testslotegrator.WebDriverHelper;
import com.testslotegrator.pageobjects.MainPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MainPageStepDefinitions {

    private MainPage mainPage;

    @Then("I am successfully logged in {string}")
    public void iAmSuccessfullyLoggedIn(String userName) {
        mainPage = new MainPage(WebDriverHelper.getDriver());
        mainPage.checkLoggedIn(userName);
    }

    @And("admin panel is loaded")
    public void adminPanelIsLoaded() {
        mainPage = new MainPage(WebDriverHelper.getDriver());
        mainPage.checkMainPage();
    }

    @When("open a list of players")
    public void openListPlayers() {
        mainPage = new MainPage(WebDriverHelper.getDriver());
        mainPage.listPlayersClick();
    }
}

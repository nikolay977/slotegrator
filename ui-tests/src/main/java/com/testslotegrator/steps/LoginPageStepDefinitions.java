package com.testslotegrator.steps;

import com.testslotegrator.WebDriverHelper;
import com.testslotegrator.pageobjects.LoginPage;

import io.cucumber.java.en.When;

public class LoginPageStepDefinitions {

    private LoginPage loginPage;
    @When("I am log in to the admin panel as user {string} with password {string}")
    public void iAmLogInToTheAdminPanelAsUserWithPassword(String login, String password) {
        loginPage = new LoginPage(WebDriverHelper.getDriver());
        loginPage.navigateToLoginPage();
        loginPage.login(login, password);
    }
}

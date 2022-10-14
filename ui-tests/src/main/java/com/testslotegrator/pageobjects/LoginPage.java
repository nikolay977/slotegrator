package com.testslotegrator.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {

    private final By loginInput = By.id("UserLogin_username");
    private final By passwordInput = By.id("UserLogin_password");
    private final By submitButton = By.xpath("//input[@value='Sign in'][@type='submit']");
    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public LoginPage loginSet(String text) {
        driver.findElement(loginInput).sendKeys(text);
        return new LoginPage(driver);
    }

    public LoginPage passwordSet(String text) {
        driver.findElement(passwordInput).sendKeys(text);
        return new LoginPage(driver);
    }

    public LoginPage submitClick() {
        driver.findElement(submitButton).click();
        return new LoginPage(driver);
    }

    public LoginPage login(String userName, String password) {
        loginSet(userName).passwordSet(password).submitClick();
        return new LoginPage(driver);
    }

    public LoginPage navigateToLoginPage() {
        driver.navigate().to("http://test-app.d6.dev.devcaz.com/admin/login");
        Wait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(submitButton));
        return new LoginPage(driver);
    }
}

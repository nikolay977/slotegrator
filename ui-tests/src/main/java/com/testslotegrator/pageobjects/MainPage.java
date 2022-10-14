package com.testslotegrator.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainPage {

    private final By userNameText = By.xpath("//*[contains(@class, 'profile')]//span");
    private final By playersButton = By.xpath("//*[contains(text(),'Players online / total')]");

    private WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }


    public MainPage checkLoggedIn(String userName) {
        assertEquals(userName, driver.findElement(userNameText).getText());
        return new MainPage(driver);
    }

    public MainPage checkMainPage() {
        assertEquals("Dashboard - Casino", driver.getTitle());
        return new MainPage(driver);
    }

    public MainPage listPlayersClick() {
        driver.findElement(playersButton).click();
        return new MainPage(driver);
    }
}

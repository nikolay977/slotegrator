package com.testslotegrator.pageobjects;

import org.openqa.selenium.WebDriver;

public class BasePage {

    protected WebDriver driver;

    public BasePage(WebDriver driver)
    {
        this.driver = driver;
    }
}

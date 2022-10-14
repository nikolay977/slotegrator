package com.testslotegrator;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WebDriverHelper {
    private static WebDriverHelper webDriverHelper;

    private static WebDriver driver;
    private static WebDriverWait wait;
    public final static int TIMEOUT = 10;

    private WebDriverHelper() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TIMEOUT));
        driver.manage().window().maximize();
    }

    public static void openPage(String url) {
        driver.get(url);
    }

    public static WebDriver getDriver() {
        return driver;
    }

    public static void setUpDriver() {
        if (webDriverHelper == null) {
            webDriverHelper = new WebDriverHelper();
        }
    }

    public static void tearDown() {
        if (driver != null) {
            driver.quit();
        }
        webDriverHelper = null;
    }
}

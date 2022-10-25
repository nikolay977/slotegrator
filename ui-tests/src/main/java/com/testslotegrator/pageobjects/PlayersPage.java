package com.testslotegrator.pageobjects;

import com.google.common.collect.Ordering;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

import static org.awaitility.Awaitility.given;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PlayersPage extends BasePage {

    private final By table = By.xpath("//table");
    private WebDriver driver;

    private int position;

    public PlayersPage(WebDriver driver) {
        super(driver);
    }

    public MainPage checkMainPage() {
        assertEquals("Dashboard - Player management", driver.getTitle());
        return new MainPage(driver);
    }

    public MainPage tableScrollsIsLoaded() {
        driver.findElement(table).isDisplayed();
        return new MainPage(driver);
    }

    public void tableColumnClick(String columnName) {
        By columnNameButton = By.xpath("//table/thead//*[contains(text(), '" + columnName + "')]");
        driver.findElement(columnNameButton).click();
    }

    public void checkTableSortedBy(String columnName) {
        given().ignoreException(StaleElementReferenceException.class)
                .await().atMost(Duration.ofSeconds(5))
                .until(() -> isSorted(getElementsText(columnName)));
    }

    public List<String> getElementsText(String columnName) {
        By columnNameXpath = By.xpath("//th[.//*[text() = '" + columnName + "']]");
        By columnNamesXpath = By.xpath("//th");

        WebElement columnNameElement = driver.findElement(columnNameXpath);
        List<WebElement> columnNameElementList = driver.findElements(columnNamesXpath);

        position = columnNameElementList.indexOf(columnNameElement) + 1;
        By elementsXpath = By.xpath("//div[@id='payment-system-transaction-grid']//tr[@class='odd' or @class='even']//td[" + position + "]");
        List<WebElement> elementList = driver.findElements(elementsXpath);

        return elementList.stream().map(WebElement::getText).collect(Collectors.toList());
    }

    private boolean isSorted(List<String> sortedList) {
        return Ordering.natural().isOrdered(sortedList);
    }
}

package edu.ufm.qa.pages;

import static org.openqa.selenium.support.ui.ExpectedConditions.*;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckoutPage {
    private final By firstName = By.id("first-name");
    private final By lastName = By.id("last-name");
    private final By postalCode = By.id("postal-code");
    private final By continueButton = By.id("continue");
    private final By finishButton = By.id("finish");
    private final By completeHeader = By.cssSelector("[data-test='complete-header']");

    private final WebDriver driver;
    private final WebDriverWait wait;

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public String completeOrder(String first, String last, String zip) {
        wait.until(visibilityOfElementLocated(firstName)).sendKeys(first);
        driver.findElement(lastName).sendKeys(last);
        driver.findElement(postalCode).sendKeys(zip);
        driver.findElement(continueButton).click();
        wait.until(elementToBeClickable(finishButton)).click();
        return wait.until(visibilityOfElementLocated(completeHeader)).getText();
    }
}

package edu.ufm.qa.pages;

import static org.openqa.selenium.support.ui.ExpectedConditions.*;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartPage {
    private final By itemNames = By.cssSelector("[data-test='inventory-item-name']");
    private final By checkoutButton = By.id("checkout");

    private final WebDriver driver;

    public CartPage(WebDriver driver) {
        this.driver = driver;
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(visibilityOfElementLocated(checkoutButton));
    }

    public List<String> itemNames() {
        return driver.findElements(itemNames).stream().map(WebElement::getText).toList();
    }

    public CheckoutPage checkout() {
        driver.findElement(checkoutButton).click();
        return new CheckoutPage(driver);
    }
}

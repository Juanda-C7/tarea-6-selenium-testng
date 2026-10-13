package edu.ufm.qa.pages;

import static org.openqa.selenium.support.ui.ExpectedConditions.*;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class InventoryPage {
    private final By title = By.cssSelector("[data-test='title']");
    private final By cartBadge = By.cssSelector("[data-test='shopping-cart-badge']");
    private final By cartLink = By.cssSelector("[data-test='shopping-cart-link']");

    private final WebDriver driver;
    private final WebDriverWait wait;

    public InventoryPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(visibilityOfElementLocated(title));
    }

    public String title() {
        return driver.findElement(title).getText();
    }

    public InventoryPage addToCart(String productSlug) {
        driver.findElement(By.id("add-to-cart-" + productSlug)).click();
        wait.until(visibilityOfElementLocated(By.id("remove-" + productSlug)));
        return this;
    }

    public InventoryPage removeFromCart(String productSlug) {
        driver.findElement(By.id("remove-" + productSlug)).click();
        wait.until(visibilityOfElementLocated(By.id("add-to-cart-" + productSlug)));
        return this;
    }

    /** 0 when the badge is not shown. */
    public int cartCount() {
        List<WebElement> badge = driver.findElements(cartBadge);
        return badge.isEmpty() ? 0 : Integer.parseInt(badge.get(0).getText());
    }

    public CartPage openCart() {
        driver.findElement(cartLink).click();
        return new CartPage(driver);
    }
}

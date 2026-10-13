package edu.ufm.qa.pages;

import static org.openqa.selenium.support.ui.ExpectedConditions.*;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
    private final By username = By.id("user-name");
    private final By password = By.id("password");
    private final By loginButton = By.id("login-button");
    private final By error = By.cssSelector("[data-test='error']");

    private final WebDriver driver;
    private final WebDriverWait wait;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public InventoryPage loginAs(String user, String pass) {
        submit(user, pass);
        return new InventoryPage(driver);
    }

    public String loginExpectingError(String user, String pass) {
        submit(user, pass);
        return wait.until(visibilityOfElementLocated(error)).getText();
    }

    private void submit(String user, String pass) {
        wait.until(visibilityOfElementLocated(username)).sendKeys(user);
        driver.findElement(password).sendKeys(pass);
        driver.findElement(loginButton).click();
    }
}

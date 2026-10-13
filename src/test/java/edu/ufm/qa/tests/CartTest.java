package edu.ufm.qa.tests;

import static org.testng.Assert.assertEquals;

import java.util.List;

import org.testng.annotations.Test;

import edu.ufm.qa.pages.InventoryPage;
import edu.ufm.qa.pages.LoginPage;

public class CartTest extends BaseTest {
    private static final String BACKPACK = "sauce-labs-backpack";

    private InventoryPage loggedIn() {
        return new LoginPage(driver).loginAs("standard_user", "secret_sauce");
    }

    @Test(groups = {"smoke", "regression"})
    public void addToCartUpdatesBadge() {
        InventoryPage inventory = loggedIn().addToCart(BACKPACK);
        assertEquals(inventory.cartCount(), 1);
    }

    @Test(groups = "regression")
    public void removeFromCartClearsBadge() {
        InventoryPage inventory = loggedIn().addToCart(BACKPACK).removeFromCart(BACKPACK);
        assertEquals(inventory.cartCount(), 0);
    }

    @Test(groups = "regression")
    public void checkoutCompletesOrder() {
        var cart = loggedIn().addToCart(BACKPACK).openCart();
        assertEquals(cart.itemNames(), List.of("Sauce Labs Backpack"));
        String header = cart.checkout().completeOrder("Ada", "Lovelace", "01010");
        assertEquals(header, "Thank you for your order!");
    }
}

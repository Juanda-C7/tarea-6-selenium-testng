package edu.ufm.qa.tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import edu.ufm.qa.pages.InventoryPage;
import edu.ufm.qa.pages.LoginPage;

public class LoginTest extends BaseTest {

    @Test(groups = {"smoke", "regression"})
    public void validUserSeesProducts() {
        InventoryPage inventory =
                new LoginPage(driver).loginAs("standard_user", "secret_sauce");
        assertEquals(inventory.title(), "Products");
    }

    @Test(groups = "regression")
    public void lockedOutUserSeesError() {
        String error = new LoginPage(driver)
                .loginExpectingError("locked_out_user", "secret_sauce");
        assertTrue(error.contains("this user has been locked out"), error);
    }

    @Test(groups = "regression")
    public void wrongPasswordSeesError() {
        String error = new LoginPage(driver)
                .loginExpectingError("standard_user", "wrong");
        assertTrue(error.contains("do not match any user"), error);
    }
}

package com.automation.tests;

import com.automation.base.BaseTest;
import com.utilities.ConfigManager;
import com.automation.utilities.DriverFactory;
import com.pages.LoginPage;
import com.pages.ProductsPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ProductsTests extends BaseTest {

    @Test(description = "Ürün Sepete eklenir")
    public void addToCartItem(){

        LoginPage loginPage= new LoginPage(DriverFactory.getDriver());
        ProductsPage productsPage= new ProductsPage(DriverFactory.getDriver());

        DriverFactory.getDriver().get(ConfigManager.getProperty("url"));

        loginPage.loginToWebsite(ConfigManager.getProperty("username"),ConfigManager.getProperty("password"));


        String expectedMessage = "Products";
        String actualMessage= loginPage.getMainPageTitle();

        Assert.assertEquals(actualMessage,expectedMessage);

        productsPage.clickAddToCartButton();

        int cartItemCountAsInt= Integer.parseInt(productsPage.getCartCount());

        Assert.assertTrue(cartItemCountAsInt>0);

    }
}

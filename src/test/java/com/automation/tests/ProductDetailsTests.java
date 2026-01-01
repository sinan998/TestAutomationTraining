package com.automation.tests;

import com.automation.base.BaseTest;
import com.utilities.ConfigManager;
import com.automation.utilities.DriverFactory;
import com.pages.LoginPage;
import com.pages.ProductDetailsPage;
import com.pages.ProductsPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ProductDetailsTests extends BaseTest {


    @Test(description = "Ürün detayı sayfasından ürünü sepete ekleme")
    public void addToCartItem(){
        LoginPage loginPage = new LoginPage(DriverFactory.getDriver());
        ProductsPage productsPage=new ProductsPage(DriverFactory.getDriver());
        ProductDetailsPage productDetailsPage= new ProductDetailsPage(DriverFactory.getDriver());

        DriverFactory.getDriver().get(ConfigManager.getProperty("url"));

        loginPage.loginToWebsite(ConfigManager.getProperty("username"),ConfigManager.getProperty("password"));

        productsPage.selectProductByIndex(2);

        productDetailsPage.addItemstoCart();

        String expectedCount = "1";
        String actualCount = productDetailsPage.getItemCountOnCart();

        Assert.assertEquals(actualCount, expectedCount, "Sepete ürün eklenemedi veya sayı hatalı!");
    }



    }




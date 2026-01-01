package com.automation.tests;

import com.automation.base.BaseTest;
import com.utilities.ConfigManager;
import com.automation.utilities.DriverFactory;
import com.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest {

    @Test(description = "Geçersiz kullanıcı ile giriş denemesi")
    public void invalidLoginTest(){
        LoginPage loginPage= new LoginPage(DriverFactory.getDriver());
        DriverFactory.getDriver().get(ConfigManager.getProperty("url"));
        loginPage.loginToWebsite(ConfigManager.getProperty("username"),ConfigManager.getProperty("wrongPassword"));

        String expectedMessage="Epic sadface: Username and password do not match any user in this service";
        String actualMessage=loginPage.getErrorMessage();

        Assert.assertEquals(expectedMessage,actualMessage);

    }


    @Test(description = "Başarılı giriş işlemi")
    public void validLoginTest(){
        LoginPage loginPage= new LoginPage(DriverFactory.getDriver());
        DriverFactory.getDriver().get(ConfigManager.getProperty("url"));
        loginPage.loginToWebsite(ConfigManager.getProperty("username"),ConfigManager.getProperty("password"));


        String expectedMessage = "Products";
        String actualMessage= loginPage.getMainPageTitle();

        Assert.assertEquals(actualMessage,expectedMessage);
    }

}

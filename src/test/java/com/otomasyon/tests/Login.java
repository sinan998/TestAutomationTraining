package com.otomasyon.tests;

import com.otomasyon.base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Login  extends BaseTest {



    @Test
    public void successfullLogin(){
        driver.get("https://www.saucedemo.com/");

        WebElement usernameBox= driver.findElement(By.id("user-name"));
        WebElement passwordBox= driver.findElement(By.id("password"));
        WebElement loginButton= driver.findElement(By.id("login-button"));


        usernameBox.sendKeys("standard_user");
        passwordBox.sendKeys("secret_sauce");
        loginButton.click();

        Assert.assertTrue(driver.findElement(By.id("shopping_cart_container")).isDisplayed(),"Giriş Yapılmadı");

    }
}

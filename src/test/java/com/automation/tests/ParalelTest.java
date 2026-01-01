package com.automation.tests;

import com.automation.base.BaseTest;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ParalelTest extends BaseTest {

    @Test
    public void test1() {

        DriverFactory.getDriver().get("https://www.saucedemo.com/");

        DriverFactory.getDriver().findElement(By.id("user-name"))
                .sendKeys("standard_user");

        DriverFactory.getDriver().findElement(By.id("password"))
                .sendKeys("secret_sauce");

        DriverFactory.getDriver().findElement(By.id("login-button")).click();

        Assert.assertTrue(DriverFactory.getDriver().findElement(By.id("shopping_cart_container")).isDisplayed(),"Giriş Yapılmadı");
        System.out.println("Test 1 (Başarılı Login) Tamamlandı. Thread ID: " + Thread.currentThread().getId());

    }

    @Test
    public void test2(){
        DriverFactory.getDriver().get("https://www.saucedemo.com/");

        DriverFactory.getDriver().findElement(By.id("user-name"))
                .sendKeys("standard_user");

        DriverFactory.getDriver().findElement(By.id("password"))
                .sendKeys("wrong_password.");

        DriverFactory.getDriver().findElement(By.id("login-button")).click();

        Assert.assertTrue(DriverFactory.getDriver().findElement(By.cssSelector("[data-test='error']")).isDisplayed(),"Giriş Yapıldı");
        System.out.println("Test 2 (Başarısız Login) Tamamlandı. Thread ID: " + Thread.currentThread().getId());

    }

}

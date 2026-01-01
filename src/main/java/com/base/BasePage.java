package com.base;

import com.utilities.ConfigManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {

    protected WebDriver driver;
    protected WebDriverWait wait;

    public  BasePage(WebDriver driver){
     this.driver=driver;
     this.wait=new WebDriverWait(driver, Duration.ofSeconds(Integer.parseInt(ConfigManager.getProperty("timeout"))));
    }

public void click(By locator){
        wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
}

public void writeText(By locator, String text){
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).sendKeys(text);
}

public String readText(By locator){

    return wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).getText();
}


}

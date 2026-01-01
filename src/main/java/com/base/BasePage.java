package com.base;

import com.utilities.ConfigManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {

    protected WebDriver driver;
    protected WebDriverWait wait;
    protected static final Logger logger = LogManager.getLogger(BasePage.class);

    public  BasePage(WebDriver driver){
     this.driver=driver;
     this.wait=new WebDriverWait(driver, Duration.ofSeconds(Integer.parseInt(ConfigManager.getProperty("timeout"))));
    }

public void click(By locator){
    logger.info("Elemente tiklaniyor: " + locator);
        wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
    logger.info("Tiklama basarili!");
}

public void writeText(By locator, String text){
    logger.info(locator + " elementine "+text + " yazdırılıyor");
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).sendKeys(text);
    logger.info(text+" başarılı bir şekilde yazdırıldı");
}

public String readText(By locator){
    logger.info(locator+" okunacak");
    String textData= wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).getText();
    logger.info(locator+" okudu. okunan veri: "+textData);
    return textData;

}


}

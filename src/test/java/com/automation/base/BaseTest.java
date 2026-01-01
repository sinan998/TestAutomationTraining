package com.automation.base;

import com.utilities.ConfigManager;
import com.automation.utilities.DriverFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class BaseTest {

    @BeforeMethod
    public void setup(){
        //driver factory'e bana bu thread için bir yer ayarla diyoruz.
        DriverFactory.setDriver();
        DriverFactory.getDriver().manage().window().fullscreen();
        DriverFactory.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(Integer.parseInt(ConfigManager.getProperty("timeout"))));
    }

    @AfterMethod
    public void tearDown(){
        DriverFactory.closeDriver();
    }
}

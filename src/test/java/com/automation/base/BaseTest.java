package com.automation.base;

import com.utilities.ConfigManager;
import com.automation.utilities.DriverFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class BaseTest {

    protected static final Logger logger = LogManager.getLogger(BaseTest.class);


    @BeforeMethod
    public void setup(){
        logger.info(">>>>>>>>>> TEST BAŞLIYOR <<<<<<<<<<");
        logger.info("Tarayıcı yapılandırılıyor...");

        //driver factory'e bana bu thread için bir yer ayarla diyoruz.
        DriverFactory.setDriver();
        logger.info("Browser açıldı: " + ConfigManager.getProperty("browser"));
        DriverFactory.getDriver().manage().window().fullscreen();
        DriverFactory.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(Integer.parseInt(ConfigManager.getProperty("timeout"))));
        logger.info("Gidilen URL: " + ConfigManager.getProperty("url"));
    }

    @AfterMethod
    public void tearDown(){
        logger.info("Test tamamlandı. Tarayıcı kapatılıyor.");
        DriverFactory.closeDriver();
        logger.info(">>>>>>>>>> TEST BİTTİ <<<<<<<<<<\n");
    }
}

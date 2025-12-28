package com.otomasyon.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import java.time.Duration;

public class BaseTest {

    // driver nesnesini burada kullnıyorum.
    // Bu sınıfı Miras alan sınıflar Webdriver'ı kullanabilsin
    protected WebDriver driver;

    // @parameters. testng.xlm dosyasından browser bilgisini alıyor
    @Parameters("browser")
    @BeforeMethod //her test methodundan önce otomatik çalışır
    public void setup(String browser){
        if (browser.equalsIgnoreCase("chrome")){
            driver = new ChromeDriver();
        }else {
            driver = new SafariDriver();
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterMethod // her methoddan sonra tarayıcı kapanacak
    public void tearDown(){
        if(driver !=null){
            driver.quit(); // taryıcıyı kapattık
        }
    }



}

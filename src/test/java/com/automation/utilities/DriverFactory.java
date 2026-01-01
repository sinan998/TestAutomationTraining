package com.automation.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverFactory {


    // ThreadLocal: her testin (thread'in) kendi driver kutusu olmasını sağlar
    // A test, B testinin tarayıcısını göremez veya kapatamaz.

    private static ThreadLocal<WebDriver> driverPool= new ThreadLocal<>();

    // driver başlatılır ve ThreadLocal kutusuna konulur.
    public static void setDriver(){
        driverPool.set(new ChromeDriver());
    }

    // o anki testin kullandığı driver'ı kutudan çıkartır ve verir.
    public static WebDriver getDriver(){
        return driverPool.get();
    }

    // Driver'ı kapatır ve kutuyu boşaltır.
    public static  void closeDriver(){
        if (driverPool.get() != null){
            driverPool.get().quit();
            driverPool.remove(); // hafıza temizliği için kullanılır
        }
    }
}

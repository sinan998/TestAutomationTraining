package com.automation.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.HashMap;
import java.util.Map;

public class DriverFactory {


    // ThreadLocal: her testin (thread'in) kendi driver kutusu olmasını sağlar
    // A test, B testinin tarayıcısını göremez veya kapatamaz.

    private static ThreadLocal<WebDriver> driverPool= new ThreadLocal<>();


    public static void setDriver(){
        ChromeOptions options = new ChromeOptions();

        // 1. Temel Argumentler
        options.addArguments("--disable-notifications"); // Bildirimleri kapat
        options.addArguments("--disable-popup-blocking"); // Pop-up engellemeyi kapat
        options.addArguments("--start-maximized"); // Ekranı tam boy başlat
        options.addArguments("--remote-allow-origins=*"); // Köken hatasını önle

        // 2. Gelişmiş Tercihler (Prefs) - İşte Sır Burası!
        Map<String, Object> prefs = new HashMap<>();

        // Şifre kaydetmeyi kapat
        prefs.put("credentials_enable_service", false);
        prefs.put("profile.password_manager_enabled", false);

        // "Şifreniz bir veri ihlalinde görüldü" uyarısını kapat (Leak Detection)
        prefs.put("profile.password_manager_leak_detection", false);

        // Güvenli tarama uyarılarını kapat (Bazen bu tetikler)
        prefs.put("safebrowsing.enabled", false);

        options.setExperimentalOption("prefs", prefs);

        // Opsiyonel: Eğer yukarıdakiler işe yaramazsa "Incognito" (Gizli Sekme) modu kesin çözümdür.
        // options.addArguments("--incognito");

        driverPool.set(new ChromeDriver(options));
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

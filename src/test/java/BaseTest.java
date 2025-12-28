import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class BaseTest {

    @Test
    public void  openBrowser(){

        // 1- Driver yolunu belirttik


        // 2- Tarayıcıyı başlatıyoruz.
        WebDriver driver = new ChromeDriver();

        // 3- Taraytıcı Ayarı yaptık.
        driver.manage().window().maximize();

        // 4- Test İşlemi: siteye git
        driver.get("https://www.migros.com.tr");

        // 5- Temizlik: tarayıcıyı kapattık
        driver.quit();


    }
}

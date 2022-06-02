package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.time.Duration;

public class Driver {
    /*
    POM´de (page object model) Driver icin TestBawse classina extends etmek yerine
    Driver classindan static methodlar kullanarak
    driver olusturup ilgili ayarlarin yapilmasi
    ve en son driverin kapatilmasi tercih edilmistir.

    POM´da driver classindaki getdriver methodunun obje olusturularak
    kullanilmasini engellemek icin singleton pattern kullanimi benimsenmistir

    Singleton Pattern : tekli kullanim, bir classin farkli classlardan
    obje olusturarak kullanimi engellemek icin kullanilir

    Bunu saglamak icin yapilmasi gereken sey obje olusturmak icin
    kullanilan constructor´i private yapmak. Böylece baska classlarda
    Driver classindan obje olsuturulmasi mümkün olmaz

     */

    static WebDriver driver;

    private Driver() {

    }

    public static WebDriver getDriver() {

        if (driver == null) {
            switch (ConfigReader.getProperty("browser")) {

                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    break;
                case "safari":
                    WebDriverManager.safaridriver().setup();
                    driver = new SafariDriver();
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    break;
                default:
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
            }

            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        }
        return driver;
    }

    public static void closeDriver() {
        if (driver != null) {  //driver´a deger atanmissa
            driver.close();
            driver = null;
        }
    }


}

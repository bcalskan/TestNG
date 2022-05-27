package tests.day16_notations;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utilities.TestBase;
import utilities.TestBaseClass;

import java.time.Duration;

public class C04_DependsOnMethods extends TestBaseClass {

    /*
    DependsOnMethods test methodlarinin calisma sirasina karismaz
    sadece bagli olan test, baglandigi testin sonuucuna bakar
    baglandigi test PASSED olmazsa, baglanan test hic calismaz (ignore)
     */


    @Test
    public void test01() {
        driver.get("https://www.ramazon1.com");
       // driver.get("https://www.amazon.com");
    }

    @Test(dependsOnMethods = "test01")
    public void test02() {
        //nutella arat
        WebElement aramaKutusu = driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("Nutella" + Keys.ENTER);
    }

    @Test(dependsOnMethods = "test02")
    public void test03() {
        //sonuc yazisinin nutella icerdigini test et
        WebElement sonucYaziElementi = driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        Assert.assertTrue(sonucYaziElementi.getText().contains("Nutella"));
    }

    @Test
    public void test04() {
        System.out.println("Bak bu calisti");
    }
}

package day16_notations;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

public class C05_Assertions extends TestBase {

    @Test
    public void test01() {
        //1-amazona git
        driver.get("https://www.amazon.com");
        //2-title´in amazon icerdigini test et
        String expectedTitle = "amazon";
        String actualTitle = driver.getCurrentUrl();
        Assert.assertTrue(actualTitle.contains(expectedTitle));

        //3-arama kutunun erisilebilir oldugunu test et
        WebElement aramaKutusu = driver.findElement(By.id("twotabsearchtextbox"));
        Assert.assertTrue(aramaKutusu.isEnabled());

        //4-arama kutusuna nutella yazip arat
        aramaKutusu.sendKeys("nutella" + Keys.ENTER);

        //5-arama yapildigini test et
        WebElement sonucYaziElementi = driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        Assert.assertTrue(sonucYaziElementi.isDisplayed());

        //6-arama sonucunun nutella icerdigini test et
        Assert.assertTrue(sonucYaziElementi.getText().contains("kutella"));


    }
}

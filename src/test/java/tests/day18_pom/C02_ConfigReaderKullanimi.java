package tests.day18_pom;

import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.FacebookPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C02_ConfigReaderKullanimi {
    @Test
    public void test01() {
        FacebookPage facebookPage = new FacebookPage();
        //facebook anasayfaya git
        Driver.getDriver().get(ConfigReader.getProperty("facebookUrl"));

        //cookies handle et
        facebookPage.cookieButonu.click();

        //kullanici mail kutusuna yanlis bir isim yazdir
        facebookPage.mailKutusu.sendKeys(ConfigReader.getProperty("fbWrongUsername"));

        //kullanici sifre kuturusuna yanlis password yaz
        facebookPage.sifreKutusu.sendKeys(ConfigReader.getProperty("fbWrongPassword"));

        //login butonuna bas
        facebookPage.loginTusu.click();

        //giris yapilamadigini test et
        Assert.assertTrue(facebookPage.girilemediYaziElementi.isDisplayed());
        //sayfayi kapatin
        Driver.closeDriver() ;
    }
}

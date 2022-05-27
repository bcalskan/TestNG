package tests.day17_pageObjectModel;

import com.github.javafaker.Faker;
import org.testng.annotations.Test;
import pages.FacebookPage;
import utilities.Driver;

import java.util.logging.Filter;

public class C03_PageClassKullanimi {
    @Test
    public void test01(){

        FacebookPage facebookPage = new FacebookPage();

        //facebook anasayfaya git
        Driver.getDriver().get("https://www.facebook.com");

        //cookies handle et
        facebookPage.cookieButonu.click();

        //kullanici mail kutusuna rastgele bir isim yazdir
        Faker faker = new Faker();
        facebookPage.mailKutusu.sendKeys(faker.internet().emailAddress());

        //kullanici sifre kuturusuna password yaz
        facebookPage.sifreKutusu.sendKeys(faker.internet().password());

        //login butonuna bas
        facebookPage.loginTusu.click();

        //giris yapilamadigini test et
        facebookPage.girilemediYaziElementi.isDisplayed();

    }
}

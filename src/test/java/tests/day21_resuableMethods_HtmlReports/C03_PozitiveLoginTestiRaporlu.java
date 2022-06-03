package tests.day21_resuableMethods_HtmlReports;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BrcPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

public class C03_PozitiveLoginTestiRaporlu extends TestBaseRapor {


    @Test
    public void yanlisSifre() throws InterruptedException {
        extentTest = extentReports.createTest("Pozitif Login", "Gecerli username ve sifre ile giris yapabilmeli");
        BrcPage brcPage = new BrcPage();
        // Bir test method olustur positiveLoginTest()
        //       https://www.bluerentalcars.com/ adresine git
        Driver.getDriver().get(ConfigReader.getProperty("brcUrl"));
        extentTest.info("Brc ana sayfaya gidildi");
        //      login butonuna bas
        Thread.sleep(3000);
        brcPage.ilkLoginButonu.click();
        extentTest.info("Login butonuna tiklandi");
        // test data user email: customer@bluerentalcars.com ,
        brcPage.emailTextBox.sendKeys(ConfigReader.getProperty("brcValidEmail"));
        extentTest.info("Gecerli email yazildi");
        // test data password : 54321
        brcPage.passwordTexBox.sendKeys(ConfigReader.getProperty("brcWrongPassword"));
        extentTest.info("Gecerli password yazildi");

        // login butonuna tiklayin
        brcPage.ikinciLoginButonu.click();
        extentTest.info("Login butonuna basildi");

        // Degerleri girildiginde sayfaya basarili sekilde girilemedigini test et
        Assert.assertTrue(brcPage.ikinciLoginButonu.isDisplayed());
        extentTest.info("Kullanici basarili sekilde giris yapti");



        Driver.closeDriver();
    }
}

package tests.day22_crossBrowser;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.AmazonPage;
import utilities.ConfigReader;
import utilities.CrossDriver;
import utilities.Driver;

public class C03_DatProvider {


    //amazon git
    //nutella arat
    //sonuclarin nutella icerdigini test et
    @Test
    public void test01() {
        //amazon git
        Driver.getDriver().get(ConfigReader.getProperty("amazonUrl"));
        //nutella arat
        AmazonPage amazonPage = new AmazonPage();
        amazonPage.aramaKutusu.sendKeys("Nutella" + Keys.ENTER);
        //sonuclarin nutella icerdigini test et
        String expectedKelime = "Nutella";
        String actSonucYazisi = amazonPage.aramaSonucElementi.getText();
        Assert.assertTrue(actSonucYazisi.contains(expectedKelime));
        Driver.closeDriver();
    }

    @DataProvider
    public static Object[][] AranacakKelimeler() {
        Object[][] arananKelimeArrayi = {{"Nutella"}, {"Java"}, {"cigdem"}, {"Netherlands"}};
        return arananKelimeArrayi;
    }

    @Test(dataProvider = "AranacakKelimeler")
    // arayacagimiz kelimeleri bir liste gibi tutup
    // bana yollayacak bir veri saglayicisi olusturacagiz
    public void test02(String arananKelime) {
        AmazonPage amazonPage = new AmazonPage();
        Driver.getDriver().get(ConfigReader.getProperty("amazonUrl"));

        //Nutella, Java, cigdem ve Netherlands icin arama yap
        amazonPage.aramaKutusu.sendKeys(arananKelime + Keys.ENTER);

        //sonuclarin aradigimiz kelime icerdigini test et
        String expectedKelime = arananKelime;
        String actSonucYazisi = amazonPage.aramaSonucElementi.getText();
        Assert.assertTrue(actSonucYazisi.contains(expectedKelime));


        //sayfayi kapat
        Driver.closeDriver();

    }
}

package tests.Tasks;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.AmazonPage;
import utilities.ConfigReader;
import utilities.Driver;

public class Q7_DataProvider {
    @DataProvider
    public static Object[][] AranacakKelimeler() {
        Object[][] arananKelimelerArray = {{"Nutella"}, {"Java"}, {"cigdem"}, {"Netherlands"}};
        return arananKelimelerArray;
    }

    //amazon git
    //Nutella, Java, cigdem ve Netherlands icin arama yap
    //sonuclari test et

    @Test(dataProvider = "AranacakKelimeler")
    public void test01(String arananKelime) {
        Driver.getDriver().get(ConfigReader.getProperty("amazonUrl"));
        AmazonPage amazonPage = new AmazonPage();
        amazonPage.aramaKutusu.sendKeys(arananKelime + Keys.ENTER);
        String actualKelime = amazonPage.aramaSonucElementi.getText();
        String expectedKelime = arananKelime;
        Assert.assertTrue(actualKelime.contains(expectedKelime));

    }
}

package tests.Tasks;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HotelMyCampPage;
import utilities.ConfigReader;
import utilities.Driver;

public class Q4_NegativeTest {
    //1 ) Bir Class olustur : NegativeTest
    //2) Bir test method olustur NegativeLoginTest()
    //https://www.hotelmycamp.com/ adresine git
    //login butonuna bas
    //test data username: manager1 ,
    //test data password : manager1!
    //Degerleri girildiginde sayfaya girilemedigini test et


    @Test
    public void test01() {

        //1 ) Bir Class olustur : NegativeTest
        //2) Bir test method olustur NegativeLoginTest()
        //https://www.hotelmycamp.com/ adresine git
        HotelMyCampPage hotelMyCampPage = new HotelMyCampPage();
        Driver.getDriver().get(ConfigReader.getProperty("hotelMyCampUrl"));

        //login butonuna bas
        hotelMyCampPage.logInButton.click();

        //test data username: manager1 ,
        hotelMyCampPage.usernameBox.sendKeys("manager1");

        //test data password : manager1!
        hotelMyCampPage.passwordBox.sendKeys("manager1!");
        hotelMyCampPage.logInButton2.click();

        //Degerleri girildiginde sayfaya girilemedigini test et
        Assert.assertTrue(hotelMyCampPage.logInFailedText.isDisplayed());

    }
}

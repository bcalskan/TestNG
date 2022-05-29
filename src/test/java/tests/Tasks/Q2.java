package tests.Tasks;


import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HotelMyCampPage;
import utilities.ConfigReader;
import utilities.Driver;


public class Q2 {

    @Test
    public void positiveLogInTest() throws InterruptedException {
        HotelMyCampPage hotelMyCampPage = new HotelMyCampPage();
        //1 ) Bir Class olustur : PositiveTest
        //2) Bir test method olustur positiveLoginTest()
        //https://www.hotelmycamp.com/ adresine git
        Driver.getDriver().get(ConfigReader.getProperty("hotelMyCampUrl"));

        //login butonuna bas
        hotelMyCampPage.logInButton.click();

        //        JavascriptExecutor jse= (JavascriptExecutor) Driver.getDriver();
        //        WebElement logInButton1 =Driver.getDriver().findElement(By.xpath("//*[text()='Log in']"));
        //        jse.executeScript("arguments[0].click();",logInButton1);

        //test data username: manager
        String username = "manager";
        hotelMyCampPage.usernameBox.sendKeys(username);

        //test data password : Manager1!
        String password = "Manager1!";
        hotelMyCampPage.passwordBox.sendKeys(password);
        hotelMyCampPage.logInButton2.click();

        //Degerleri girildiginde sayfaya basarili sekilde girilebildigini test et
        String expectedUrl = "https://www.hotelmycamp.com/Admin/UserAdmin";
        String actualUrl = Driver.getDriver().getCurrentUrl();
        Assert.assertEquals(expectedUrl, actualUrl);

    }

}

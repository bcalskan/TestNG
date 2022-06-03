package tests.day21_resuableMethods_HtmlReports;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.Set;

public class C01_WindowHandleReusableMethods {

    @Test
    public void test01() {
        // https://the-internet.herokuapp.com/windows adresine gidin
        Driver.getDriver().get("https://the-internet.herokuapp.com/windows");
        String ilkSayfaWH = Driver.getDriver().getWindowHandle();

        //click here bas
        Driver.getDriver().findElement(By.linkText("Click Here")).click();
        Set<String> WHSeti = Driver.getDriver().getWindowHandles();
        String ikinciSayfaWH = "";

        for (String each : WHSeti) {
            if (!each.equals(ilkSayfaWH)) {
                ikinciSayfaWH = each;
            }
        }

        Driver.getDriver().switchTo().window(ikinciSayfaWH);
        System.out.println(Driver.getDriver().getTitle());

        //acilan yeni tabin titleinin New Window oldugunu test et
        String expectedTitle = "New Window";
        String actualTitle = Driver.getDriver().getTitle();

        Assert.assertEquals(expectedTitle, actualTitle);
    }

    @Test
    public void test02() {
        // https://the-internet.herokuapp.com/windows adresine gidin
        Driver.getDriver().get("https://the-internet.herokuapp.com/windows");
        String ilkSayfaWH = Driver.getDriver().getWindowHandle();

        //click here bas
        Driver.getDriver().findElement(By.linkText("Click Here")).click();

        //acilan yeni tabin titleinin New Window oldugunu test et
        ReusableMethods.switchToWindow("New Window");
    }
}

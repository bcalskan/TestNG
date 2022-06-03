package tests.day21_resuableMethods_HtmlReports;

import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.io.IOException;

public class C02_SSReusableMethod {

    @Test
    public void test01() throws IOException {
        //amazon git ss al
        Driver.getDriver().get(ConfigReader.getProperty("amazonUrl"));
        ReusableMethods.getScreenshot("amazon");
        Driver.closeDriver();
    }
}

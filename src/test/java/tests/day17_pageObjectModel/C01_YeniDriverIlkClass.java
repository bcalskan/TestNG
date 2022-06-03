package tests.day17_pageObjectModel;

import org.testng.annotations.Test;
import utilities.Driver;

public class C01_YeniDriverIlkClass {

    @Test(groups = "grup1")
    public void test01() {
        Driver.getDriver().get("https://www.amazon.com");

        /*
        Bugüne kadar TestBase classina extends ederek kullanidigimiz
        driver yerine bundan sonra Driver classindan kullanacagimiz
        getDriver static methodunu kullanacagiz.

        Driver.getDriver().get("link")
         */

        Driver.getDriver().get("https://www.bestbuy.com");
        Driver.getDriver().get("https://www.facebook.com");

        Driver.closeDriver();

    }
}

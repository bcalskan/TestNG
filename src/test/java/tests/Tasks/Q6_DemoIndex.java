package tests.Tasks;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DemoIndexPage;
import utilities.ConfigReader;
import utilities.Driver;

import java.util.ArrayList;
import java.util.List;

public class Q6_DemoIndex {
    @Test
    public void test01() {
        DemoIndexPage demoIndexPage = new DemoIndexPage();
        //  ~ Navigate to http://tutorialsninja.com/demo/index.php?route=common/home
        Driver.getDriver().get(ConfigReader.getProperty("demoIndexUrl"));

        //    ~ click on Phones & PDAs
        demoIndexPage.phonesPDAs.click();

        //    ~ get the brandName of phones
        for (WebElement each : demoIndexPage.phoneList) {
            System.out.println(each.getText());
        }

        //    ~ click on add to button for all elements
        for (WebElement each : demoIndexPage.addToCartList) {
            each.click();
        }

        //    ~ click on black total added cart button
        demoIndexPage.itemsButton.click();

        //    ~ get the names of list from the cart
        for (WebElement each : demoIndexPage.nameOfItemsList) {
            System.out.println(each.getText());
        }

        //    ~ compare the names from displaying list and cart list
        List<String> phoneListName = new ArrayList<>();
        for (WebElement each : demoIndexPage.phoneList) {
            phoneListName.add(each.getText());
        }

        List<String> itemsListName = new ArrayList<>();
        for (WebElement each : demoIndexPage.nameOfItemsList) {
            itemsListName.add(each.getText());
        }

        Assert.assertTrue(phoneListName.containsAll(itemsListName));
        Driver.closeDriver();


    }
}

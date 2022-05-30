package tests.Tasks;

import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DemoGuru99Page;
import utilities.ConfigReader;
import utilities.Driver;

public class Q5_DragAndDrop {
    /*
    http://demo.guru99.com/test/drag_drop.html url e git
    DEBIT SIDE da Account bolumune BANK butonunu surukle ve birak
    CREDIT SIDE da Account bolumune SALES butonunu surukle ve birak
    DEBIT SIDE da Amount bolumune 5000 butonunu surukle ve birak
    CREDIT SIDE da Amount bolumune ise ikinci 5000  butonunu surukle ve birak
    Perfect butonun goruntulendigini dogrulayin
     */
    @Test
    public void test01() {
        DemoGuru99Page demoGuru99Page = new DemoGuru99Page();

        //http://demo.guru99.com/test/drag_drop.html url e git
        Driver.getDriver().get(ConfigReader.getProperty("demoGuru99Url"));
        demoGuru99Page.cookiesAccept.click();

        //    DEBIT SIDE da Account bolumune BANK butonunu surukle ve birak
        Actions actions = new Actions(Driver.getDriver());
        actions.dragAndDrop(demoGuru99Page.bank,demoGuru99Page.debitSideAccountArea).perform();

        //    CREDIT SIDE da Account bolumune SALES butonunu surukle ve birak
        actions.dragAndDrop(demoGuru99Page.sale,demoGuru99Page.creditSideAccountArea).perform();

        //    DEBIT SIDE da Amount bolumune 5000 butonunu surukle ve birak
        actions.dragAndDrop(demoGuru99Page.fiveThousand1,demoGuru99Page.debitSideAmountArea).perform();

        //    CREDIT SIDE da Amount bolumune ise ikinci 5000  butonunu surukle ve birak
        actions.dragAndDrop(demoGuru99Page.fiveThousand2,demoGuru99Page.creditSideAmountArea).perform();

        //    Perfect butonun goruntulendigini dogrulayin
        Assert.assertTrue(demoGuru99Page.perfect.isDisplayed());
        Driver.closeDriver();


    }
}

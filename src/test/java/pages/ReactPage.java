package pages;

import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class ReactPage {

    public ReactPage() {
        PageFactory.initElements(Driver.getDriver(), this);

    }

}

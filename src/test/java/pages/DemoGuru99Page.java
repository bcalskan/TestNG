package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class DemoGuru99Page {
    public DemoGuru99Page() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "(//p[@class='fc-button-label'])[1]")
    public WebElement cookiesAccept;

    @FindBy(xpath = "//*[text()=' BANK ']")
    public WebElement bank;

    @FindBy(xpath = "//ol[@class='field14 ui-droppable ui-sortable']")
    public WebElement debitSideAccountArea;

    @FindBy(xpath = "//ol[@class='field15 ui-droppable ui-sortable']")
    public WebElement creditSideAccountArea;

    @FindBy(xpath = "//*[text()=' SALES ']")
    public WebElement sale;

    @FindBy(xpath = "(//ol[@class='field13 ui-droppable ui-sortable'])[1]")
    public WebElement debitSideAmountArea;

    @FindBy(xpath = "(//ol[@class='field13 ui-droppable ui-sortable'])[2]")
    public WebElement creditSideAmountArea;

    @FindBy(xpath = "//*[text()=' 5000']")
    public WebElement fiveThousand1;

    @FindBy(xpath = "(//a[@class='button button-orange'])[2]")
    public WebElement fiveThousand2;

    @FindBy(xpath = "(//a[@class='button button-green'])[1]")
    public WebElement perfect;


}

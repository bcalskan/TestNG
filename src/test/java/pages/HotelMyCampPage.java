package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class HotelMyCampPage {
    public HotelMyCampPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//*[text()='Log in']")
    public WebElement logInButton;

    @FindBy(xpath = "//input[@name='UserName']")
    public WebElement usernameBox;

    @FindBy(xpath = "//input[@name='Password']")
    public WebElement passwordBox;

    @FindBy(xpath = "//input[@id='btnSubmit']")
    public WebElement logInButton2;

}

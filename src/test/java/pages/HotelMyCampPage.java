package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utilities.Driver;

public class HotelMyCampPage {
    public HotelMyCampPage() {

    }
    //             (//a[@class='nav-link'])[7]
    @FindBy(xpath = "//*[text()='Log in']")
    public WebElement logInButton;

    @FindBy (xpath = "//input[@name='UserName']")
    public WebElement usernameBox;

    @FindBy(xpath = "//input[@name='Password']")
    public  WebElement passwordBox;

    @FindBy (xpath = "//input[@id='btnSubmit']")
    public WebElement logInButton2;

}

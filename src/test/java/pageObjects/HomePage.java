package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    private WebDriver driver;

    //1.Locator
    @FindBy(xpath = "//a[@href='/register?returnUrl=%2F']")
    public WebElement linkRegister;

    //2. Constructor
    public HomePage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //3. Actions
    public RegisterPage clickRegisterLink()
    {
        linkRegister.click();
        return new RegisterPage(driver);
    }


    
}

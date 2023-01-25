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

    @FindBy(xpath = "//a[@class='ico-login']")
    private WebElement linkLogin;

    @FindBy(xpath = "//input[@id='small-searchterms']") private WebElement searchBox;
    @FindBy(xpath = "//button[@type='submit']") private WebElement btnsubmitSearch;

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

    public LoginPage clickLoginLink()
    {
        linkLogin.click();
        return new LoginPage(driver);
    }

//    public void setSearchBox(String productName)
//    {
//        searchBox.sendKeys(productName);
//    }
//
//    public SearchPage clickSearchSubmitBtn()
//    {
//        btnsubmitSearch.click();
//        return new SearchPage(driver);
//    }
    
}

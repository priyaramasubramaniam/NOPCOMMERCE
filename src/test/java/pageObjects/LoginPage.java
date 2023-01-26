package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    private WebDriver driver;

    @FindBy(xpath = "//*[@id='Email']")
    public WebElement inputEmail;

    @FindBy(xpath = "//*[@id='Password']")
    public WebElement inputPassword;

    @FindBy(xpath = "//button[@class='button-1 login-button']")
    public WebElement buttonLogin;

    @FindBy(xpath = "//button[@class='button-1 register-button']")
    public WebElement buttonRegister;
    public LoginPage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void setInputEmail(String email){inputEmail.sendKeys(email);}
    public void setInputPassword(String password){inputPassword.sendKeys(password);}
    public DashboardPage setButtonLogin()
    {
        buttonLogin.click();
        return new DashboardPage(driver);
    }

    public RegisterPage setButtonRegister()
    {
        buttonRegister.click();
        return new RegisterPage(driver);
    }

}

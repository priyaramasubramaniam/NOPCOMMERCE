package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

   private WebDriver driver;
   //1. Constructor
   public LoginPage(WebDriver driver)
   {
      this.driver = driver;
      PageFactory.initElements(driver, this);
   }

   //2.Locators
   @FindBy(xpath = "//input[@id='Email']") private WebElement txtInputEmail;
   @FindBy(xpath = "//input[@id='Password']") private WebElement txtPassword;
   @FindBy(xpath = "//button[normalize-space()='Log in']") private WebElement btnLogin;
   @FindBy(xpath = "//a[normalize-space()='Forgot password?']") private WebElement linkForgotPswd;

   //3.Action Methods
   public void setTxtInputEmail(String email)
   {
      txtInputEmail.sendKeys(email);
   }
   public void setTxtPassword(String password)
   {
      txtPassword.sendKeys(password);
   }
   public HomePage setBtnLogin()
   {
      btnLogin.click();
      return new HomePage(driver);
   }
   public ForgotPasswordPage clickForgotPasswordLink()
   {
      linkForgotPswd.click();
      return new ForgotPasswordPage(driver);
   }
   public boolean setLinkForgotPswd()
   {
      return linkForgotPswd.isDisplayed();
   }
}

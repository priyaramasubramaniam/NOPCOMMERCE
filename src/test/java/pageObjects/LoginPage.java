package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
   private WebDriver driver;

   public LoginPage(WebDriver driver)
   {
      this.driver = driver;
      PageFactory.initElements(driver, this);
   }
}

package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.devtools.v85.page.Page;
import org.openqa.selenium.support.PageFactory;

public class ForgotPasswordPage {

   private WebDriver driver;
   public ForgotPasswordPage(WebDriver driver)
   {
      this.driver = driver;
      PageFactory.initElements(driver, this);
   }
}

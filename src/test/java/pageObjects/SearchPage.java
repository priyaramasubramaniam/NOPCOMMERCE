package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage {

   private WebDriver driver;

   //1. Constructor
   public SearchPage(WebDriver driver)
   {
      this.driver = driver;
      PageFactory.initElements(driver, this);
   }

   //2. Locators
   @FindBy(xpath = "//h2[@class='product-title']//a[contains(text(),'Apple MacBook Pro 13-inch')]")
   private WebElement resultProdName;

   //3. Action class
   public String setResultProdName()
   {
      resultProdName.isDisplayed();
      return resultProdName.getText();
   }

}

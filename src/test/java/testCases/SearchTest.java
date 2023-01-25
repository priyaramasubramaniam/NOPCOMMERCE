//package testCases;
//
//import org.openqa.selenium.Alert;
//import org.testng.Assert;
//import org.testng.annotations.Test;
//import pageObjects.HomePage;
//import pageObjects.SearchPage;
//import utility.ReadConfig;
//
//import java.io.IOException;
//
//public class SearchTest extends BaseClass{
//
//   HomePage hp;
//   SearchPage sp;
//   ReadConfig rc = new ReadConfig();
//   LoginPage lp;
//   LoginTest lt;
//
//
//   public SearchTest() throws IOException {
//   }
//
//   @Test
//   public void TC_Correct_ProductVisible_001()
//   {
//      hp = new HomePage(driver);
//      hp.setSearchBox(rc.setProductname());
//      sp = hp.clickSearchSubmitBtn();
//      String exp_prod_name = sp.setResultProdName();
//      String act_prod_name = rc.setProductname();
//      if(exp_prod_name.equals(act_prod_name))
//      {
//         Assert.assertTrue(true);
//      }
//      else
//      {
//         Assert.assertTrue(false);
//      }
//   }
//
//   @Test
//   public void TC_InCorrect_ProductVisible_002() {
//      hp = new HomePage(driver);
//      hp.setSearchBox(rc.setIncorrectProdName());
//      sp = hp.clickSearchSubmitBtn();
//      if (driver.getPageSource().contains("No products were found that matched your criteria.")) {
//         Assert.assertTrue(true);
//      } else {
//         Assert.assertTrue(false);
//      }
//   }
//   @Test
//   public void TC_EmptySearchBox_003() {
//      hp = new HomePage(driver);
//      hp.setSearchBox("");
//      sp = hp.clickSearchSubmitBtn();
//      Alert alert = driver.switchTo().alert();
//      String alertMsg = alert.getText();
//      if (alertMsg.equals("Please enter some search keyword")) {
//         alert.accept();
//         Assert.assertTrue(true);
//      }
//      else {
//         Assert.assertTrue(false);
//      }
//   }
//
//   @Test(dependsOnMethods = {"testCases.LoginTest.TC_LoginValid_001"})
//   public void TC_correctProd_afterLogin() throws IOException {
//
//   }
//}

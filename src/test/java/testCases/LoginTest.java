package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.RegisterPage;
import utility.ReadConfig;

import java.io.IOException;

public class LoginTest extends BaseClass {

   HomePage hp;
   LoginPage lp;
   ReadConfig rc = new ReadConfig();

   public LoginTest() throws IOException {
   }

   //@Test
   public void TC_LoginValid_001()
   {
      hp = new HomePage(driver);
      lp = hp.clickLoginLink();
      lp.setTxtInputEmail(rc.setEmail());
      lp.setTxtPassword(rc.setPassword());
      lp.setBtnLogin();
      if(driver.getTitle().equals("nopCommerce demo store"))
      {
         Assert.assertTrue(true);
      }
      else
      {
         Assert.assertTrue(false);
      }
   }

   //@Test
   public void TC_Without_Credentials()
   {
      hp = new HomePage(driver);
      lp = hp.clickLoginLink();
      lp.setBtnLogin();
      Assert.assertEquals(driver.getPageSource().contains("Please enter your email"), true);
//      Assert.assertEquals(driver.getPageSource().contains("Login was unsuccessful."), true);
   }

   @Test
   public void TC_ForgotPswdLinK_003()
   {
      hp = new HomePage(driver);
      lp = hp.clickLoginLink();
      Assert.assertEquals(lp.setLinkForgotPswd() == true, true);
      lp.clickForgotPasswordLink();
      Assert.assertEquals(driver.getTitle().equals("nopCommerce demo store. Password Recovery"), true);
   }
}

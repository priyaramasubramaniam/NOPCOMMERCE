package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

public class RegisterTest extends BaseClass{

    HomePage hp;
    RegisterPage rp;
    @Test(priority = 1)
    public void TC_RegisterMand_001()
    {
       hp = new HomePage(driver);
       rp = hp.clickRegisterLink();
       logger.info("Register link Clicked");
       rp.setInputFirstNameRequired("priya");
       logger.info("First name Entered");
       rp.setInputLastNameRequired("SP");
       logger.info("LastName entered");
       rp.setInputEmail(randomString());
       logger.info("Email entered");
       rp.setInputPasswordRequired("123456");
       logger.info("Password enterd");
       rp.setInputPassword("123456");
       logger.info("Confirm password enterd");
       rp.clickRegisterBtn();
       logger.info("Register button is clicked");
       if(driver.getPageSource().contains("Your registration completed"))
       {
           Assert.assertTrue(true);
           System.out.println(driver.getTitle());
           logger.info("Register user is successfully created");
       }
       else
       {
           Assert.assertTrue(false);
           logger.warn("User Registration is Unsuccessful");
       }
    }

    @Test(priority = 2)
    public void TC_RegisterAll_001()
    {
        hp = new HomePage(driver);
        rp = hp.clickRegisterLink();
        rp.clickGenderFemale();
        rp.setInputFirstNameRequired("priya");
        rp.setInputLastNameRequired("SP");
        rp.setSelectDateBirthDay();
        rp.setSelectDateBirthMonth();
        rp.setSelectDateBirthYear();
        rp.setInputEmail(randomString());
        rp.setInputCompany("Priya Constructon");
        rp.setInputPasswordRequired("123456");
        rp.setInputPassword("123456");
        rp.clickRegisterBtn();
        if(driver.getPageSource().contains("Your registration completed"))
        {
            Assert.assertTrue(true);
            System.out.println(driver.getTitle());
        }
        else
        {
            Assert.assertTrue(false);
        }
    }

    @Test(priority = 3)
    public void TC_RegisterWithoutMan_003()
    {
        hp = new HomePage(driver);
        rp = hp.clickRegisterLink();
        rp.clickRegisterBtn();
        Assert.assertEquals(driver.getPageSource().contains("First name is required."), true);
        Assert.assertEquals(driver.getPageSource().contains("Last name is required."), true);
        Assert.assertEquals(driver.getPageSource().contains("Email is required."), true);
        Assert.assertEquals(driver.getPageSource().contains("Password is required."), true);
    }
}

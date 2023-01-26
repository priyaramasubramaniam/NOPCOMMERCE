package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;

public class RegisterTest extends BaseClass{

    @Test
    public void TC_RegisterMan_001()
    {
        hp = new HomePage(driver);
        rp = hp.setLinkRegister();
        rp.setInputFirstNameRequired(readConfig.setFname());
        rp.setInputLastNameRequired(readConfig.setlname());
        String em = rp.setInputWrongEmail(randomString());
        System.out.println(em);
        rp.setInputPasswordRequired(readConfig.setRPassword());
        rp.setInputPassword(readConfig.setCRPassword());
        rp.setButtonRegister();
        if(driver.getPageSource().contains("Your registration completed"))
        {
            Assert.assertTrue(true);
        }
        else {
            Assert.assertTrue(false);
        }
    }
    @Test
    public void TC_RegisterAll_002()
    {
        hp = new HomePage(driver);
        rp = hp.setLinkRegister();
        rp.setInputGenderFemale();
        rp.setInputFirstNameRequired(readConfig.setFname());
        rp.setInputLastNameRequired(readConfig.setlname());
        rp.setSelectDateBirthDay( "5");
        rp.setSelectDateBirthMonth("June");
        rp.setSelectDateBirthYear("1926 ");
        rp.setInputWrongEmail(randomString());
        rp.setInputCompany("Priya contr");
        rp.setInputPasswordRequired(readConfig.setRPassword());
        rp.setInputPassword(readConfig.setCRPassword());
        rp.setButtonRegister();
        if(driver.getPageSource().contains("Your registration completed"))
        {
            Assert.assertTrue(true);
        }
        else {
            Assert.assertTrue(false);
        }
    }
    @Test
    public void TC_RegisterNull_003() throws InterruptedException {
        hp = new HomePage(driver);
        rp = hp.setLinkRegister();
        rp.setButtonRegister();
        Assert.assertEquals(driver.getPageSource().contains("First name is required."), true);
        Assert.assertEquals(driver.getPageSource().contains("Last name is required."), true);
        Assert.assertEquals(driver.getPageSource().contains("Email is required."),true);
        Assert.assertEquals(driver.getPageSource().contains("Password is required."), true);
        Thread.sleep(3000);

    }

    @Test
    public void TC_RegisterNewsLetterEnabled_004() throws InterruptedException {
        hp = new HomePage(driver);
        rp = hp.setLinkRegister();
        rp.setInputGenderFemale();
        rp.setInputFirstNameRequired(readConfig.setFname());
        rp.setInputLastNameRequired(readConfig.setlname());
        rp.setSelectDateBirthDay( "5");
        rp.setSelectDateBirthMonth("June");
        rp.setSelectDateBirthYear("1926 ");
        rp.setInputWrongEmail(randomString());
        rp.setInputCompany("Priya contr");
        rp.setInputPasswordRequired(readConfig.setRPassword());
        rp.setInputPassword(readConfig.setCRPassword());
        if(rp.inputNewsletter.isEnabled())
        {
            rp.setButtonRegister();
            Assert.assertTrue(true);
        }
        Thread.sleep(3000);
    }

    @Test
    public void TC_RegisterNewsLetterDisabled_005()
    {
        hp = new HomePage(driver);
        rp = hp.setLinkRegister();
        rp.setInputGenderFemale();
        rp.setInputFirstNameRequired(readConfig.setFname());
        rp.setInputLastNameRequired(readConfig.setlname());
        rp.setSelectDateBirthDay( "5");
        rp.setSelectDateBirthMonth("June");
        rp.setSelectDateBirthYear("1926 ");
        rp.setInputWrongEmail(randomString());
        rp.setInputCompany("Priya contr");
        rp.setInputPasswordRequired(readConfig.setRPassword());
        rp.setInputPassword(readConfig.setCRPassword());
        if(rp.inputNewsletter.isDisplayed())
        {
            rp.setInputNewsletter();
            rp.setButtonRegister();
            Assert.assertTrue(true);
        }
    }

    @Test
    public void TC_RegisterViaLoginLink_006() throws InterruptedException {
        hp = new HomePage(driver);
        lp = hp.setLinkLogin();
        Thread.sleep(3000);
        rp = lp.setButtonRegister();
        rp.setInputGenderFemale();
        rp.setInputFirstNameRequired(readConfig.setFname());
        rp.setInputLastNameRequired(readConfig.setlname());
        rp.setSelectDateBirthDay( "5");
        rp.setSelectDateBirthMonth("June");
        rp.setSelectDateBirthYear("1926 ");
        rp.setInputWrongEmail(randomString());
        rp.setInputCompany("Priya contr");
        rp.setInputPasswordRequired(readConfig.setRPassword());
        rp.setInputPassword(readConfig.setCRPassword());
        rp.setButtonRegister();
        if(driver.getPageSource().contains("Your registration completed"))
        {
            Assert.assertTrue(true);
        }
        else {
            Assert.assertTrue(false);
        }
    }

    @Test
    public void TC_RegisterWithInvalidPswd_007() throws InterruptedException {
        hp = new HomePage(driver);
        rp = hp.setLinkRegister();
        rp.setInputFirstNameRequired(readConfig.setFname());
        rp.setInputLastNameRequired(readConfig.setlname());
        String em = rp.setInputWrongEmail(randomString());
        System.out.println(em);
        rp.setInputPasswordRequired(readConfig.setRPassword());
        rp.setInputPassword(readConfig.setCRPassword());
        if(driver.getPageSource().contains("The password and confirmation password do not match."))
        {
            Assert.assertTrue(true);
        }
        else {
            Assert.assertTrue(false);
        }
    }

    @Test
    public void TC_RegisterWithExistMail_008() throws InterruptedException {
        hp = new HomePage(driver);
        rp = hp.setLinkRegister();
        rp.setInputFirstNameRequired(readConfig.setFname());
        rp.setInputLastNameRequired(readConfig.setlname());
        String em = rp.setInputWrongEmail(readConfig.setREmail());
        System.out.println(em);
        rp.setInputPasswordRequired(readConfig.setRPassword());
        rp.setInputPassword(readConfig.setCRPassword());
        rp.setButtonRegister();
        if(driver.getPageSource().contains("The specified email already exists"))
        {
            Assert.assertTrue(true);
        }
        else {
            Assert.assertTrue(false);
        }
    }
    @Test
    public void TC_RegisterWithInvalidMail_008() throws InterruptedException {
        hp = new HomePage(driver);
        rp = hp.setLinkRegister();
        rp.setInputFirstNameRequired(readConfig.setFname());
        rp.setInputLastNameRequired(readConfig.setlname());

        for(String invaildEMail:readConfig.emails())
        {
            rp.setInputWrongEmail(invaildEMail);
            if(driver.getPageSource().contains("Wrong email"))
            {
                Assert.assertTrue(true);
            }
            else
            {
                Assert.assertTrue(false);
            }
        }


        rp.setInputPasswordRequired(readConfig.setRPassword());
        rp.setInputPassword(readConfig.setCRPassword());
        rp.setButtonRegister();
        if(driver.getPageSource().contains("The specified email already exists"))
        {
            Assert.assertTrue(true);
        }
        else {
            Assert.assertTrue(false);
        }
    }


}

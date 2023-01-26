package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;

public class LoginTest extends BaseClass{

    @Test
    public void TC_LoginValid_001()
    {
        hp = new HomePage(driver);
        lp = hp.setLinkLogin();
        lp.setInputEmail(readConfig.setEmail());
        lp.setInputPassword(readConfig.setPassword());
        lp.setButtonLogin();
        Assert.assertEquals(driver.getPageSource().contains("Log out"), true);
    }
}

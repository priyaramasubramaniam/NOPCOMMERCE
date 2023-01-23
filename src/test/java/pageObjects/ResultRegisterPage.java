package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class ResultRegisterPage {

    private WebDriver driver;

    //1. Constructor
    public  ResultRegisterPage(WebDriver driver)
    {
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }


}

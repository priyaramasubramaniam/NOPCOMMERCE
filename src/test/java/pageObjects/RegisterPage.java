package pageObjects;

import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class RegisterPage {

    private WebDriver driver;
    Select dropdown;

    //2. Locators
    @FindBy(xpath = "//*[@id='FirstName']")
    private WebElement inputFirstNameRequired;

    @FindBy(xpath = "//*[@id='LastName']")
    private WebElement inputLastNameRequired;

    @FindBy(xpath = "//*[@id='Email']")
    private WebElement inputEmail;

    @FindBy(xpath = "//*[@id='Password']")
    private WebElement inputPasswordRequired;

    @FindBy(xpath = "//*[@id='ConfirmPassword']")
    private WebElement inputPassword;

    @FindBy(xpath = "//*[@id='register-button']")
    private WebElement buttonRegister;

    @FindBy(xpath = "//*[@id='gender-female']")
    public WebElement inputGenderFemale;

    @FindBy(xpath = "//select[@name='DateOfBirthDay']")
    public WebElement selectDateBirthDay;

    @FindBy(xpath = "//select[@name='DateOfBirthMonth']")
    public WebElement selectDateBirthMonth;

    @FindBy(xpath = "//select[@name='DateOfBirthYear']")
    public WebElement selectDateBirthYear;

    @FindBy(xpath = "//*[@id='Company']")
    public WebElement inputCompany;

    //1. Constructor
    public RegisterPage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void setInputFirstNameRequired(String fname)
    {
        inputFirstNameRequired.sendKeys(fname);
    }
    public void setInputLastNameRequired(String lname)
    {
        inputLastNameRequired.sendKeys(lname);
    }
    public void setInputEmail(String email)
    {
        inputEmail.sendKeys(email);
    }
    public void setInputPasswordRequired(String password)
    {
        inputPasswordRequired.sendKeys(password);
    }
    public void setInputPassword(String CPassword)
    {
        inputPassword.sendKeys(CPassword);
    }
    public void clickGenderFemale(){inputGenderFemale.click();}
    public void setSelectDateBirthDay()
    {
        dropdown = new Select(selectDateBirthDay);
        dropdown.selectByVisibleText("5");
    }
    public void setSelectDateBirthMonth(){
        dropdown = new Select(selectDateBirthMonth);
        dropdown.selectByVisibleText("March");
    }
    public void setSelectDateBirthYear()
    {
        dropdown = new Select(selectDateBirthYear);
        dropdown.selectByVisibleText("1994");
    }
    public void setInputCompany(String company)
    {
        inputCompany.sendKeys(company);
    }



    public ResultRegisterPage clickRegisterBtn()
    {
        buttonRegister.click();
        return new ResultRegisterPage(driver);
    }

    


}

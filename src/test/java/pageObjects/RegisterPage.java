package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import testCases.BaseClass;

public class RegisterPage {
    private WebDriver driver;
    BaseClass bc;


    @FindBy(xpath = "//*[@id='gender-female']")
    public WebElement inputGenderFemale;

    @FindBy(xpath = "//*[@id='FirstName']")
    public WebElement inputFirstNameRequired;

    @FindBy(xpath = "//*[@id='LastName']")
    public WebElement inputLastNameRequired;

    @FindBy(xpath = "//select[@name='DateOfBirthDay']")
    public WebElement selectDateBirthDay;

    @FindBy(xpath = "//select[@name='DateOfBirthMonth']")
    public WebElement selectDateBirthMonth;

    @FindBy(name = "DateOfBirthYear")
    public WebElement selectDateBirthYear;

    @FindBy(xpath = "//*[@id='Email']")
    public WebElement inputWrongEmail;

    @FindBy(xpath = "//*[@id='Company']")
    public WebElement inputCompany;

    @FindBy(xpath = "//*[@id='Password']")
    public WebElement inputPasswordRequired;

    @FindBy(xpath = "//*[@id='ConfirmPassword']")
    public WebElement inputPassword;

    @FindBy(xpath = "//*[@id='register-button']")
    public WebElement buttonRegister;

    @FindBy(xpath = "//*[@id='Newsletter']")
    public WebElement inputNewsletter;

    public RegisterPage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void setInputGenderFemale()
    {
        inputGenderFemale.click();
    }

    public void setInputFirstNameRequired(String fname)
    {
        inputFirstNameRequired.sendKeys(fname);
    }

    public void setInputLastNameRequired(String lname)
    {
        inputLastNameRequired.sendKeys(lname);
    }
    public void setSelectDateBirthDay(String option) {
        BaseClass.selectDropdownOption(selectDateBirthDay, option);
    }

    public void setSelectDateBirthMonth(String option) {
        BaseClass.selectDropdownOption(selectDateBirthMonth, option);
    }
    public void setSelectDateBirthYear(String option){BaseClass.selectDropdownOption(selectDateBirthYear, option);}
    public String setInputWrongEmail(String email)
    {
        inputWrongEmail.sendKeys(email);
        return email;
    }
    public void setInputCompany(String company)
    {
        inputCompany.sendKeys(company);
    }
    public void setInputPasswordRequired(String password)
    {
        inputPasswordRequired.sendKeys(password);
    }
    public void setInputPassword(String cpassword)
    {
        inputPassword.sendKeys(cpassword);
    }
    public void setInputNewsletter(){inputNewsletter.click();}
    public RegisterPage setButtonRegister()
    {
        buttonRegister.click();
        return new RegisterPage(driver);
    }
}

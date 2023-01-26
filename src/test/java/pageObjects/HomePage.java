package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    private WebDriver driver;

    @FindBy(xpath = "//a[@class='ico-register']")
    public WebElement linkRegister;

    @FindBy(xpath = "//a[@class='ico-login']")
    public WebElement linkLogin;

    @FindBy(xpath = "//span[@class='wishlist-label']")
    public WebElement spanWishlist;

    @FindBy(xpath = "//span[@class='cart-label']")
    public WebElement spanShoppingCart;

    @FindBy(xpath = "//*[@id='small-searchterms']")
    public WebElement inputSmallSearchterms;

    @FindBy(xpath = "//button[@class='button-1 search-box-button']")
    public WebElement buttonSearch;


    public HomePage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public LoginPage setLinkLogin()
    {
        linkLogin.click();
        return new LoginPage(driver);
    }

    public RegisterPage setLinkRegister()
    {
        linkRegister.click();
        return new RegisterPage(driver);
    }

//    public WishlistPage setSpanWishlist()
//    {
//        spanWishlist.click();
//        return new WishlistPage();
//    }
//
//    public ShoppingcartPage setSpanShoppingCart()
//    {
//        spanShoppingCart.click();
//        return new ShoppingcartPage();
//    }
//
    public void setInputSmallSearchterms(String searchItem)
    {
        inputSmallSearchterms.sendKeys(searchItem);
    }
    public SearchPage setButtonSearch()
    {
        buttonSearch.click();
        return new SearchPage(driver);
    }
    
    
}

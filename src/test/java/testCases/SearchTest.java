package testCases;

import org.testng.annotations.Test;
import pageObjects.HomePage;

public class SearchTest extends LoginTest{

    @Test()
    public void TC_SearchValid_001()
    {
        hp = new HomePage(driver);
        hp.setInputSmallSearchterms("priya");
        hp.setButtonSearch();
    }
}

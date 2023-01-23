package testCases;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import utility.ReadConfig;

import java.io.IOException;
import java.sql.DataTruncation;
import java.util.Random;

public class BaseClass {

    public WebDriver driver;
    ReadConfig readConfig;
    @Parameters("browser")
    @BeforeMethod
    public void setup(String browser)
    {
        if (browser.equals("chrome"))
        {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        }
        else if (browser.equals("firefox"))
        {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }
        else if (browser.equals("edge"))
        {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        }
        else if (browser.equals("ie"))
        {
            WebDriverManager.iedriver().setup();
            driver = new InternetExplorerDriver();
        }
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        try {
            readConfig = new ReadConfig();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        driver.get(readConfig.setUrl());
    }

    @AfterMethod
    public void teardown()
    {
        driver.quit();
    }

    public static String randomString()
    {
        return RandomStringUtils.randomAlphabetic(5) + "@gmail.com";
    }
}

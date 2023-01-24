package testCases;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.PropertyConfigurator;
import org.apache.log4j.Logger;
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

public class BaseClass {

    public WebDriver driver;
    ReadConfig readConfig;



    public static Logger logger;
    @Parameters("browser")
    @BeforeMethod
    public void setup(String browser)
    {
        logger = Logger.getLogger("NOPCommerce");
        PropertyConfigurator.configure("Configurations/Log4j.properties");

        if (browser.equals("chrome"))
        {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            logger.info("Chrome Browser is opened Successfully");
        }
        else if (browser.equals("firefox"))
        {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
            logger.info("Firefox Browser is opened Successfully");
        }
        else if (browser.equals("edge"))
        {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
            logger.info("Edge Browser is opened Successfully");
        }
        else if (browser.equals("ie"))
        {
            WebDriverManager.iedriver().setup();
            driver = new InternetExplorerDriver();
            logger.info("Internet Browser is opened Successfully");
        }
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        try {
            readConfig = new ReadConfig();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        driver.get(readConfig.setUrl());
        logger.info("URL is entered Successfully");

    }

    @AfterMethod
    public void teardown()
    {
        driver.quit();
        logger.info("Browser window closed Successfully");
    }

    public static String randomString()
    {
        return RandomStringUtils.randomAlphabetic(5) + "@gmail.com";
    }

}

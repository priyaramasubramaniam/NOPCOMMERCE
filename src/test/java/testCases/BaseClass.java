package testCases;

import org.openqa.selenium.TakesScreenshot;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.PropertyConfigurator;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;
import utility.ReadConfig;

import java.io.File;
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
    public void teardown(ITestResult testResult)
    {
        if (ITestResult.FAILURE == testResult.getStatus()) {
            takeScreenshot(driver, testResult.getName());
        }
        driver.quit();
        logger.info("Browser window closed Successfully");
    }

    public static String randomString()
    {
        return RandomStringUtils.randomAlphabetic(5) + "@gmail.com";
    }

    //To Take Screenshot
    public void takeScreenshot(WebDriver driver, String fileName) {
        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(src, new File(System.getProperty("user.dir") + "/Screenshots/"+ fileName + ".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

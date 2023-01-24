package utility;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class TestUtils {
   static WebDriver driver;

   //Taking Screenshot
   public static void takeScreenshotAtEndOfTest() throws  IOException {
      File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
      String currentDir = System.getProperty("user.dir");
      FileUtils.copyFile(scrFile, new File(currentDir + "/screenshots/" + System.currentTimeMillis() + ".png"));
   }
}

package utility;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Reporting extends TestListenerAdapter {

   public ExtentSparkReporter extentSparkReporter;
   public ExtentReports extentReports;
   public ExtentTest extentTest;


   public void onStart(ITestContext testContext)
   {
      String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
      String repName = "test-Report"+timeStamp+".html";
      extentSparkReporter = new ExtentSparkReporter(System.getProperty("user.dir")+"/Test-Report/"+repName);
      extentSparkReporter.loadXMLConfig("/home/waioz/eclipse-workspace/NOPCOMMERCE/extent-config.xml");

      extentSparkReporter.config().setReportName("Functional Test Automation Report");
      extentSparkReporter.config().setDocumentTitle("Automation Test Title");
      extentSparkReporter.config().setTheme(Theme.DARK);

      extentReports = new ExtentReports();
      extentReports.attachReporter(extentSparkReporter);
      extentReports.setSystemInfo("Tester", "priya");
      extentReports.setSystemInfo("browser", "chrome");
      extentReports.setSystemInfo("Host", "localhost");
   }

   public void onTestSuccess(ITestResult testResult)
   {
      extentTest =  extentReports.createTest(testResult.getName());
      extentTest.log(Status.PASS, MarkupHelper.createLabel(testResult.getName(), ExtentColor.GREEN));
   }

   public void onTestFailure(ITestResult testResult)
   {
      extentTest = extentReports.createTest(testResult.getName());
      extentTest.log(Status.FAIL, MarkupHelper.createLabel(testResult.getName(),ExtentColor.RED));
      String screenshotPath = System.getProperty("user.dir")+"/Screenshots/"+testResult.getName()+".png";
      File f = new File(screenshotPath);
      if(f.exists())
      {
         try {
            extentTest.fail("Screenshot is below"+ extentTest.addScreenCaptureFromPath(screenshotPath));
         } catch (IOException e) {
            throw new RuntimeException(e);
         }
      }
   }

   public void onTestSkipped(ITestResult tr)
   {
      extentTest=extentReports.createTest(tr.getName()); // create new entry in th report
      extentTest.log(Status.SKIP,MarkupHelper.createLabel(tr.getName(),ExtentColor.ORANGE));
   }

   public void onFinish(ITestContext testContext)
   {
      extentReports.flush();
   }
}

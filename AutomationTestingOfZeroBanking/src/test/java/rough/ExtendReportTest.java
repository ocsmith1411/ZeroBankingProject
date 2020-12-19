package rough;

import java.io.IOException;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.*;

public class ExtendReportTest {
	
	@Test 
	public void loginTest() throws IOException
	{
      ExtentHtmlReporter reporter = new ExtentHtmlReporter ("C:\\Users\\Owner\\eclipse-workspace\\AutomationTestingOfZeroBanking\\src\\test\\resources\\ExtentsReport\\testRp.html");
      ExtentReports extent = new ExtentReports();
      
	  extent.attachReporter(reporter);
      
	  ExtentTest logger = extent.createTest("LoginTest");
	  
	  System.out.println("Logging into test website");
	  
	  logger.log(Status.INFO, "Login Test");
	  logger.log(Status.PASS, "Title Verified");
	  extent.flush();
	  
	  ExtentTest logger2 = extent.createTest("Logout");
	  logger2.log(Status.FAIL, "Title Verified");
	  
	  logger2.fail("Test failed because of an issue", MediaEntityBuilder.createScreenCaptureFromPath("/Users/Owner/Desktop/ice_screenshot_20200223-040434.png").build());
	  extent.flush(); 
   }
}
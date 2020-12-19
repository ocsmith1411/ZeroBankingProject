package rough;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.*;

//import base.BaseClass;
import utilities.ScreenCapUtility;

public class ExtendReportTest2 //extends BaseClass {
{
	
	ExtentReports extent;
	ExtentTest logger;
	WebDriver driver;
	
	
	@BeforeMethod
	public void setup()
	{
		ExtentHtmlReporter reporter = new ExtentHtmlReporter ("C:\\Users\\Owner\\eclipse-workspace\\AutomationTestingOfZeroBanking\\src\\test\\resources\\ExtentsReport\\testRpRp3.html");
	    
		//ExtentReports 
		
		extent = new ExtentReports();
	     
	    
		extent.attachReporter(reporter);
	      
		//ExtentTest logger = extent.createTest("LoginTest");
		logger = extent.createTest("Web Page Title Test");
		//extent.flush();
	}
	
		
	@Test 
	public void loginTest2() throws IOException
	{
      
	//System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") +"\\src\\test\\resources\\Drivers\\chromedriver.exe");
	
	System.setProperty("webdriver.chrome.driver", "C:\\Users\\Owner\\eclipse-workspace\\AutomationTestingOfZeroBanking\\src\\test\\resources\\Drivers\\chromedriver.exe");	
	driver = new ChromeDriver();
	
	//driver.get(config.getProperty("testWebSiteURL"));
	
	driver.get("http://zero.webappsecurity.com/");
	//driver.get("http://google.com");
	driver.manage().window().maximize();

	// Global implicit Wait
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	System.out.println("Page Title is " + driver.getTitle());	
	Assert.assertTrue(driver.getTitle().contains("Zero1")); 
	
	//System.out.println("Title Verified and test passed");
	//logger.log(Status.PASS, "Title Verified and test pass");
	}
	
	
	@AfterMethod
	public void tearDown(ITestResult result) throws IOException
	{
		
		System.out.println(result.getStatus());
		System.out.println(ITestResult.FAILURE);
		//extent.flush();
		
		if(result.getStatus()==ITestResult.FAILURE)
		{
			System.out.println("\nTest Fail\n");
			String temp=ScreenCapUtility.getScreenshot(driver);
			System.out.println(temp);
			logger.fail(result.getThrowable().getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(temp).build());
		
			System.out.println(result.getThrowable().getMessage());
		
		}
		
		extent.flush();
		driver.quit();
	}
}
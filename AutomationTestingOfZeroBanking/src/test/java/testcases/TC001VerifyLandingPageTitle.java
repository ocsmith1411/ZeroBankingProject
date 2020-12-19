package testcases;

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

import base.BaseClass;
import utilities.ExtentReportManager;
import utilities.ScreenCapUtility;

public class TC001VerifyLandingPageTitle extends BaseClass {

	ExtentReports report;
	ExtentTest logger;
		
	@BeforeMethod
	public void setup()
	{
		ExtentHtmlReporter reporter = new ExtentHtmlReporter ("C:\\Users\\Owner\\eclipse-workspace\\AutomationTestingOfZeroBanking\\src\\test\\resources\\ExtentsReport\\ZeroBankingTestRpt.html");
	    
		//ExtentReports 
		
		report = new ExtentReports();
	     
	    report.attachReporter(reporter);
	      
		logger = report.createTest("TC001 - Verify Landing Page Title");
	}
	
		
	@Test 
	public void verifyLandingPageTitle() throws IOException
	{
      
	driver.get(config.getProperty("testWebSiteURL"));
	
	System.out.println("Landing Page Title is " + driver.getTitle());	
	
	Assert.assertTrue(driver.getTitle().contains("Zero")); 
	
	System.out.println("Title Verified and test passed");
	logger.log(Status.PASS, "Landing Page Title verified and test pass");
	}
	
	
	@AfterMethod
	public void tearDown(ITestResult result) throws IOException
	{
		
		System.out.println(result.getStatus());
		System.out.println(ITestResult.FAILURE);
				
		if(result.getStatus()==ITestResult.FAILURE)
		{
			System.out.println("\nTest Fail\n");
			String temp=ScreenCapUtility.getScreenshot(driver);
			System.out.println(temp);
			logger.fail(result.getThrowable().getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(temp).build());
		
			System.out.println(result.getThrowable().getMessage());
		
		}
		
		report.flush();
		driver.quit();
	}
}
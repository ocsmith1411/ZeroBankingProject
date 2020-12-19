package testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.BaseClass;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.relevantcodes.extentreports.LogStatus;

import testpages.HomePage;
import testpages.LoginPage;
import utilities.ScreenCapUtility;

public class TC002VerifyLogin extends BaseClass {
	
	HomePage hp;
	LoginPage lp;
	
	public static ExtentReports report;
	public static ExtentTest logger;
	public static ExtentHtmlReporter reporter;
	
		
	@BeforeMethod
	public void setup()
	{
		ExtentHtmlReporter reporter = new ExtentHtmlReporter ("C:\\Users\\Owner\\eclipse-workspace\\AutomationTestingOfZeroBanking\\src\\test\\resources\\ExtentsReport\\ZeroBankingTestRpt.html");
	    
		
		report = new ExtentReports();
		
		//report = new ExtentReports("C:\\Users\\Owner\\eclipse-workspace\\AutomationTestingOfZeroBanking\\src\\test\\resources\\ExtentsReport\\ZeroBankingTestRpt.html", false);
	     
	    report.attachReporter(reporter);
	      
		logger = report.createTest("TC002 - Verify Login");
	}
	
	@Test
	public void verifyLogin() {
	//Below is for log4j logs
   	app_logs.info("Verify login test has started");
		
   	    hp = new HomePage(driver);
	
		hp.doClick();
		lp=new LoginPage(driver);
		
		lp.doLogin("username", "password");
		String actual = driver.getTitle();
		String expected="Zero - Account Summary";
		
		Assert.assertEquals(actual, expected);
		
		logger.log(Status.PASS, "Login Test Verified and passed");
	}

	@AfterMethod
	public void tearDown(ITestResult result) throws IOException
	{
		
		System.out.println(result.getStatus());
		System.out.println(ITestResult.FAILURE);
				
		if(result.getStatus()==ITestResult.FAILURE)
		{
			System.out.println("\nTest Fail\n");
			String temp2=ScreenCapUtility.getScreenshot(driver);
			System.out.println(temp2);
			logger.fail(result.getThrowable().getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(temp2).build());
		
			System.out.println(result.getThrowable().getMessage());
		
		}
		
		report.flush();
		driver.quit();
	}	
	
}

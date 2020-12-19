package testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.relevantcodes.extentreports.LogStatus;

import base.BaseClass;
import testpages.HomePage;
import testpages.LoginPage;
import testpages.SearchPage;
import utilities.ScreenCapUtility;
import utilities.ZBLogging;

public class TC003VerifySearch2 extends BaseClass {
	
	SearchPage sp;
		
	
	public static ExtentReports search;
	public static ExtentTest logger;
	public static ExtentHtmlReporter reporter;
	
		
	@BeforeMethod
	public void setup()
	{
		ExtentHtmlReporter reporter = new ExtentHtmlReporter ("C:\\Users\\Owner\\eclipse-workspace\\AutomationTestingOfZeroBanking\\src\\test\\resources\\ExtentsReport\\ZeroBankingTestRpt.html");
	    
		
		search = new ExtentReports();
		
		search.attachReporter(reporter);
	      
		logger = search.createTest("TC003 - Verify Search");
	}
	
	
	
	@Test (dataProvider ="getSearchData")
	public void VerifySearch(String searchData) {
		
	//Below is for log4j logs
    app_logs.info("verify search test has started");
   	 
   		
		sp = new SearchPage(driver);
		
		String SearchFound = sp.doSearch(searchData);
		
			
		if (SearchFound.contains("The following pages were found for the query"))
		{
			System.out.println("Search successful");
			app_logs.info("Search test was successful");
			Assert.assertTrue(SearchFound.contains("The following pages were found for the query"));
			//logger.log(Status.PASS, "Login Test Verified and passed");
		}
		
		
		if (SearchFound.contains("No results were found for the query"))
		{
			System.out.println("Search NOT successful");
			app_logs.info("Search test was NOT successful");
			Assert.assertTrue(SearchFound.contains("No results were found for the query"));
		
		}
						
	}
	
	
	
	@AfterMethod
	public void tearDown(ITestResult result3) throws IOException
	{
		
		System.out.println(result3.getStatus());
		System.out.println(ITestResult.FAILURE);
				
		if(result3.getStatus()==ITestResult.FAILURE)
		{
			System.out.println("\nTest Fail\n");
			String temp3=ScreenCapUtility.getScreenshot(driver);
			System.out.println(temp3);
			//logger.fail(result3.getThrowable().getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(temp3).build());
			//logger.pass(result.getThrowable().getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(temp3).build());
			
			System.out.println(result3.getThrowable().getMessage());
		
		}
		
		search.flush();
		driver.quit();
	}
	

	
	@DataProvider (name ="getSearchData")
	public Object [] getSearchData()
	{
	   Object [] data = new Object[2];   
	   //1st row of data
	   data[0] = "help";
	   data[1] = "Winter_time is here";
	   
	   return data;
	} 

}

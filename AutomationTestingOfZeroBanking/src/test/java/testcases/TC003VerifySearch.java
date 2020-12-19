package testcases;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import base.BaseClass;
import testpages.HomePage;
import testpages.LoginPage;
import testpages.SearchPage;
import utilities.ZBLogging;

public class TC003VerifySearch extends BaseClass {
	
	SearchPage sp;
		
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
		}
		
		
		if (SearchFound.contains("No results were found for the query"))
		{
			System.out.println("Search NOT successful");
			app_logs.info("Search test was NOT successful");
			Assert.assertTrue(SearchFound.contains("No results were found for the query"));
		
		}
						
	}

	@DataProvider (name ="getSearchData")
	public Object [] getSearchData()
	{
	   Object [] data = new Object[2];   
	   //1st row of data
	   data[0] = "help";
	   data[1] = "Winter_time";
	   
	   return data;
	} 

}

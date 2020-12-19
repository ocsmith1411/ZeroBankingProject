package utilities;

import java.io.File;

import com.relevantcodes.extentreports.DisplayOrder;
import com.relevantcodes.extentreports.ExtentReports;


public class ExtentReportManager {
	
	private static ExtentReports extent;
	
	
	public static ExtentReports getInstance()
	{
		String Path = "C://Users//Owner//eclipse-workspace//AutomationTestingOfZeroBanking//src//test//resources//ExtentsReport//testRpRp3.html";
		
		extent = new ExtentReports (Path, false);
		
		return extent;
		
	}

}

/*
 if(extent==null){
			
			extent = new ExtentReports(System.getProperty("user.dir")+"\\target\\surefire-reports\\html\\extent.html",true,DisplayOrder.OLDEST_FIRST);
			extent.loadConfig(new File(System.getProperty("user.dir")+"\\src\\test\\resources\\extentconfig\\ReportsConfig.xml")); 
 */

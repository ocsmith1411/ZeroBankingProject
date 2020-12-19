package testcases;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import utilities.ZBLogging;

public class TC004AddNewPayee extends ZBLogging {

	WebDriver driver;
	
	@BeforeMethod
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Owner\\eclipse-workspace\\AutomationTestingOfZeroBanking\\src\\test\\resources\\Drivers\\chromedriver.exe");
		
		logger.debug("Configuring driver and loading test site URL");
		
		driver = new ChromeDriver();
		driver.get("http://zero.webappsecurity.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	
		driver.findElement(By.id("signin_button")).click();
		driver.findElement(By.id("user_login")).sendKeys("username");
		driver.findElement(By.id("user_password")).sendKeys("password");
		driver.findElement(By.name("submit")).click();
	} 

	
		@Test(dataProvider="credential")
		public void verifyAddPayee(String pname, String pAddress, String paccount, String pdetails) {
	
		//Logging with log4j
			
		logger.debug("Executing VerifyAddPayee test case");	
		
		driver.findElement(By.xpath("//a[@href='/bank/redirect.html?url=pay-bills.html']")).click();
		driver.findElement(By.xpath("//a[@href='#ui-tabs-2']")).click();
		driver.findElement(By.id("np_new_payee_name")).sendKeys(pname);
		driver.findElement(By.id("np_new_payee_address")).sendKeys(pAddress);
		driver.findElement(By.id("np_new_payee_account")).sendKeys(paccount);
		driver.findElement(By.id("np_new_payee_details")).sendKeys(pdetails);
		driver.findElement(By.id("add_new_payee")).click();
		String text = driver.findElement(By.id("alert_content")).getText();

		Assert.assertTrue(text.contains("was successfully created."));
		
		logger.info("VerifyAddPayee test case now completed");
			
	}
		
		@AfterMethod
		public void tearDown() {
			logger.debug(".....now exiting web browser...");
			driver.quit();
		}
		

		@DataProvider(name="credential")
		public Object[][] passdata() throws IOException{
			
		File src=new File("C:\\Users\\Owner\\eclipse-workspace\\AutomationTestingOfZeroBanking\\src\\test\\resources\\DataDrivenResources\\newwpayeetestdata.xlsx");
		//load the excel file
		logger.debug(".....loading excel file to read data...");
		
		FileInputStream fis=new FileInputStream(src);
		//load the workbook from the above excel file 
		XSSFWorkbook wb=new XSSFWorkbook(fis);
		
		//load the sheet from above excel workbook
		logger.debug(".....loading excel workbook to read data...");
		XSSFSheet sheet=wb.getSheetAt(0);
				
		// how many total rows in my excel sheet
		logger.debug(".....checking number of rows and cell in excel file...");
		
		int rowCount=sheet.getLastRowNum();
		System.out.println("Number of rows " + rowCount);
		
		int rows = rowCount + 1;
		System.out.println(rows);
	
		int cellCount=sheet.getRow(0).getLastCellNum();
		System.out.println("\nNumber of cells " + cellCount);

		String data[][] = new String [rowCount][cellCount];
        
		logger.debug(".....reading data from excel file...");
		
		for(int i=1; i<rowCount+1; i++) {
			Row r=sheet.getRow(i);

			for(int j=0; j<cellCount; j++) {
				
				System.out.println(data[i-1][j]=r.getCell(j).getStringCellValue());
				
				if (j==0 & data[i-1][j] == null ) {
					data[i-1][j] = ""; 
					//System.out.println("This is a test " + data[i-1][j]);
				}
			 
			}
				
   }
		return data;
		
  }
		
}



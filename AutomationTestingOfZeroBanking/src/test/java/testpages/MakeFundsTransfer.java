package testpages;

//import java.awt.List;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.BasePage;

public class MakeFundsTransfer extends BasePage {

		
	public MakeFundsTransfer (WebDriver driver) {
		super(driver);
	}
	
	/*
	@FindBy(linkText="Transfer Funds")
	public WebElement tabTransScreen;
	
	@FindBy(id="tf_fromAccountId")
	public WebElement AccFrVal;
	
	@FindBy(id="tf_toAccountId")
	public WebElement AccToVal;
	
	@FindBy(id="tf_amount")
	public WebElement amount;
	
	*/
	WebDriver driver;
	
	
	
	@BeforeMethod
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Owner\\eclipse-workspace\\AutomationTestingOfZeroBanking\\src\\test\\resources\\Drivers\\chromedriver.exe");
		
		driver = new ChromeDriver();
		driver.get("http://zero.webappsecurity.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	
		driver.findElement(By.id("signin_button")).click();
		driver.findElement(By.id("user_login")).sendKeys("username");
		driver.findElement(By.id("user_password")).sendKeys("password");
		driver.findElement(By.name("submit")).click();
	} 

	   public void PaymentTransfer(String transferfrom, String transferto, String tamount, String tdescription) {
	    
		  /* transferfrom = "3";
		   transferto = "4";
		   tamount = "900";
		   tdescription = "Just doing a test";
		   */
		  // driver = new ChromeDriver();
		 
		//driver.findElement(By.xpath("//a[contains(text(),'Transfer Funds')]")).click();
	//	   tabTransScreen.click();
		
	//	   Select accountFrom = new Select(AccFrVal);
	//	accountFrom.selectByValue(transferfrom);
		
	//	 Select accountTo = new Select(AccToVal);
		//	accountFrom.selectByValue(transferto);
			
	//		amount.sendKeys(tamount);
		
		Select accountFrom = new Select(driver.findElement(By.id("tf_toAccountId")));
		accountFrom.selectByValue(transferfrom);
		   
		Select accountTo = new Select(driver.findElement(By.id("tf_toAccountId")));
		accountTo.selectByValue(transferto);
		
		driver.findElement(By.id("tf_amount")).sendKeys(tamount);
		driver.findElement(By.id("tf_description")).sendKeys(tdescription);
		driver.findElement(By.xpath("//button[@id='btn_submit']")).click();
		driver.findElement(By.id("btn_submit")).click();
		
		//String text = driver.findElement(By.xpath("//div[contains(text(),'You successfully submitted your transaction.')]")).getText();
		
		//Assert.assertTrue(text.contains("You successfully submitted your transaction."));
			
	}
		
	//	@AfterMethod
		//public void tearDown() {
			//driver.quit();
	//	}
		
	/*	
		@DataProvider (name = "transferData")
		public Object [] getTransferData()
		{
			
			Object [][] data = new Object[2][4];   
			   //1st row of data
			   data[0][0] = "3";
			   data[0][1] = "4";
			   data[0][2] = "300";
			   data[0][3] = "Automation testing payment transfer 1";
		   
			 //2nd row of data
			   data[1][0] = "4";
			   data[1][1] = "3";
			   data[1][2] = "250";
			   data[1][3] = "Automation testing payment transfer 2";
			   
			   return data;
		} 
		*/
				
}

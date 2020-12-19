package testpages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import base.BasePage;

public class SearchPage extends BasePage {
	
	public SearchPage(WebDriver driver) {
		super(driver);
		}
	
	@FindBy(xpath="//input[@id='searchTerm']")
	public WebElement txtSearchValue;
	
	//@FindBy(id="user_password")
	//public WebElement txtPassword;
	
	//@FindBy(name="submit")
	//public WebElement btnSubmit;
	@FindBy (xpath="//body/div[1]/div[2]/div[1]")
	public WebElement messageval;
	
	public String doSearch(String mysearchvalue) {
		
		txtSearchValue.sendKeys(mysearchvalue);
						
		//WebElement textbox = driver.findElement(By.id("idOfElement"));
		txtSearchValue.sendKeys(Keys.ENTER);
		
		String value = messageval.getText();
		//System.out.println (value);
		return value;	
		
		//txtPassword.sendKeys(mypassword);
		//btnSubmit.click();
		
   }

}

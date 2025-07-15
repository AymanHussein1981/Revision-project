package page;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;

public class DashboardPageScrollUpDown {
	
	WebDriver driver;
	
	public DashboardPageScrollUpDown(WebDriver driver) {
		this.driver=driver;
	}
	
	
	@FindBy(how = How.XPATH, using="/html/body/div[1]/section/div/div[2]/div/div/header/div/strong") WebElement DashboardHeaderElement;
	@FindBy(how = How.XPATH, using="/html/body/div[1]/aside[1]/div/nav/ul[2]/li[2]/a/span") WebElement CustomerButtonElement;
	@FindBy(how = How.XPATH, using="//*[@id=\"customers\"]/li[2]/a/span") WebElement AddCustomerButtonElement;
	
	
	
	public void validatedashboardheader(String expecteddashboardheader) {
		
		String acutaldashboardheader=DashboardHeaderElement.getText();
		Assert.assertEquals(acutaldashboardheader, expecteddashboardheader, "Page not found");
		
	}
	
	
	public void scrolldown() {
		
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("scroll(0,1000)");
	}
	
	
	public void presscustomerbutton() {
		CustomerButtonElement.click();
		
	}
	
	
	public void pressaddcustomerbutton() {
		AddCustomerButtonElement.click();
	}
	
	
}

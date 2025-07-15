package page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;

public class DashboardPage {
	
	
	@FindBy(how = How.XPATH, using="/html/body/div[1]/section/div/div[2]/div/div/header/div/strong") WebElement DashboardHeaderElement;
	@FindBy(how = How.XPATH, using="/html/body/div[1]/aside[1]/div/nav/ul[2]/li[2]/a/span") WebElement CustomerButtonElement;
	@FindBy(how = How.XPATH, using="//*[@id=\"customers\"]/li[2]/a/span") WebElement AddCustomerButtonElement;
	
	
	
	public void validatedashboardheader(String expecteddashboardheader) {
		
		String acutaldashboardheader=DashboardHeaderElement.getText();
		Assert.assertEquals(acutaldashboardheader, expecteddashboardheader, "Page not found");
		
	}
	
	
	public void presscustomerbutton() {
		CustomerButtonElement.click();
		
	}
	
	
	public void pressaddcustomerbutton() {
		AddCustomerButtonElement.click();
	}
	
	
}

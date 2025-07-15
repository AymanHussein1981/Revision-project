package page;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;

public class AddCustomerPage extends BasePage {
	
	
	@FindBy(how = How.XPATH, using="/html/body/div[1]/section/div/div[2]/div/div[1]/div[1]/div/div/header/div/strong") WebElement addCustomerHeaderElement;
	@FindBy(how = How.XPATH, using="//*[@id=\"general_compnay\"]/div[1]/div/input") WebElement FullNameElement;
	@FindBy(how = How.XPATH, using="//*[@id=\"general_compnay\"]/div[2]/div/select") WebElement CompanyDropDownElement;
	@FindBy(how = How.XPATH, using="//*[@id=\"general_compnay\"]/div[3]/div/input") WebElement EmailElement;
	@FindBy(how = How.XPATH, using="//*[@id=\"phone\"]") WebElement PhoneElement;
	@FindBy(how = How.XPATH, using="//*[@id=\"general_compnay\"]/div[5]/div/input") WebElement AddressElement;
	@FindBy(how = How.XPATH, using="//*[@id=\"general_compnay\"]/div[6]/div/input") WebElement CityElement;
	@FindBy(how = How.XPATH, using="//*[@id=\"port\"]") WebElement ZipElement;
	@FindBy(how = How.XPATH, using="//*[@id=\"general_compnay\"]/div[8]/div[1]/select") WebElement CountryElement;
	@FindBy(how = How.XPATH, using="//*[@id=\"save_btn\"]") WebElement SaveButtonElement;
	@FindBy(how = How.XPATH, using="//*[@id=\"yesBtn\"]") WebElement deleteButtonElement;
	
	
	
	
	public void validateaddcustomerpage(String expectedaddcustomerpagemsg) {
		
		String actualaddcustomerpagemsg=addCustomerHeaderElement.getText();
		Assert.assertEquals(actualaddcustomerpagemsg, expectedaddcustomerpagemsg, "Page not found");
		
	}
	
	
	public void insertfullname(String fullname) {
		FullNameElement.sendKeys(fullname);
		
	}
	
	
	
	public void selectcompanyfromdropdown(String companyname) {
		SelectfromDropDown(CompanyDropDownElement, companyname);
		
	}
	
	
	
	public void insertcustomerEmail(String customerEmail) {
		EmailElement.sendKeys(generateNum(999)+customerEmail);
		
	}
	
	
	public void insertcustomerPhone(String customerPhone) {
		PhoneElement.sendKeys(customerPhone+generateNum(999));
		
	}
	
	
	public void selectcountryfromdropdown(String countryname) {
		SelectfromDropDown(CountryElement, countryname);
		
	}
	
	
	public void presssavebutton() {
		SaveButtonElement.click();
	}

}

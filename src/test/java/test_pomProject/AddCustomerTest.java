package test_pomProject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import page.AddCustomerPage;
import page.DashboardPage;
import page.LoginPage;
import util.BrowserFactory;
import util.ExcelReader;

public class AddCustomerTest {
	
	
WebDriver driver;

	
	ExcelReader excelreader=new ExcelReader("src\\main\\java\\testData\\TF_TestData.xlsx");
	
	 String userName=excelreader.getCellData("LoginInfo", "UserName", 2);
	 String Password=excelreader.getCellData("LoginInfo", "Password", 2);
	 String expectedDashboardHeader=excelreader.getCellData("DashboardInfo", "DashboardHeader", 2);
	 String customerFullName=excelreader.getCellData("AddContactInfo", "FullName", 2);
	 String companyName=excelreader.getCellData("AddContactInfo", "CompanyName", 2);
	 String customerEmail=excelreader.getCellData("AddContactInfo", "Email", 2);
	 String customerPhone=excelreader.getCellData("AddContactInfo", "Phone", 2);
	 String countryName=excelreader.getCellData("AddContactInfo", "Country", 2);
	 String expectedNewCustomerHeader=excelreader.getCellData("AddContactInfo", "AddContactValidationText", 2);
	
	
	@Test
	public void addnewcustomer() {
		
		driver=BrowserFactory.init();
		
		LoginPage loginpage=PageFactory.initElements(driver, LoginPage.class);
		loginpage.insertusername(userName);
		loginpage.insertpassword(Password);
		loginpage.presssigninbutton();
		
		
		DashboardPage dashboardpage=PageFactory.initElements(driver, DashboardPage.class);
		dashboardpage.validatedashboardheader(expectedDashboardHeader);
		dashboardpage.presscustomerbutton();
		dashboardpage.pressaddcustomerbutton();
		
		
		AddCustomerPage addcustomerpage=PageFactory.initElements(driver, AddCustomerPage.class);
		addcustomerpage.validateaddcustomerpage(expectedNewCustomerHeader);
		addcustomerpage.insertfullname(customerFullName);
		addcustomerpage.selectcompanyfromdropdown(companyName);
		addcustomerpage.insertcustomerEmail(customerEmail);
		addcustomerpage.insertcustomerPhone(customerPhone);
		addcustomerpage.selectcountryfromdropdown(countryName);
		addcustomerpage.presssavebutton();
		
		
		
		BrowserFactory.TearDown();
	}
	

}

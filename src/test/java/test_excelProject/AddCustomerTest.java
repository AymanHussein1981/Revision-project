package test_excelProject;

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
	
	ExcelReader exclreader=new ExcelReader("src\\main\\java\\testData\\TF_TestData.xlsx");
	
	String userName=exclreader.getCellData("LoginInfo", "UserName", 2);
	String Password=exclreader.getCellData("LoginInfo", "Password", 2);
	String dashboard=exclreader.getCellData("DashboardInfo", "DashboardHeader", 2);
	String addcrstomer=exclreader.getCellData("AddContactInfo", "AddContactValidationText", 2);
	String customername=exclreader.getCellData("AddContactInfo", "FullName", 2);
	String customercompany=exclreader.getCellData("AddContactInfo", "CompanyName", 2);
	String customeremail=exclreader.getCellData("AddContactInfo", "Email", 2);
	String customerphone=exclreader.getCellData("AddContactInfo", "Phone", 2);
	String customercountry=exclreader.getCellData("AddContactInfo", "Country", 2);
	
	
	
	@Test
	public void addNewCustomer() {
		
		driver=BrowserFactory.init();
		
		LoginPage loginpage= PageFactory.initElements(driver, LoginPage.class);
		loginpage.insertusername(userName);
		loginpage.insertpassword(Password);
		loginpage.presssigninbutton();
		
		
		DashboardPage dashboardPage=PageFactory.initElements(driver, DashboardPage.class);
		
		dashboardPage.validatedashboardheader(dashboard);
		dashboardPage.presscustomerbutton();
		dashboardPage.pressaddcustomerbutton();
		
		
		AddCustomerPage addcustomerpage=PageFactory.initElements(driver, AddCustomerPage.class);
		
		addcustomerpage.validateaddcustomerpage(addcrstomer);
		addcustomerpage.insertfullname(customername);
		addcustomerpage.selectcompanyfromdropdown(customercompany);
		addcustomerpage.insertcustomerEmail(customeremail);
		addcustomerpage.insertcustomerPhone(customerphone);
		addcustomerpage.selectcountryfromdropdown(customercountry);
		addcustomerpage.presssavebutton();
		
		
		BrowserFactory.TearDown();
	}

}

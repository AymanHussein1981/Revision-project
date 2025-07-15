package test_excelProject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import page.DashboardPage;
import page.LoginPage;
import util.BrowserFactory;
import util.ExcelReader;

public class LoginTest {
	
	WebDriver driver;
	
	
	ExcelReader exlReader = new ExcelReader("src\\main\\java\\testData\\TF_TestData.xlsx");
	
	String userName=exlReader.getCellData("LoginInfo", "UserName", 2);
	String Password=exlReader.getCellData("LoginInfo", "Password", 2);
	String dashboard=exlReader.getCellData("DashboardInfo", "DashboardHeader", 2);
	
	@Test
	public void validUserANDPasswordtoLogin() {
		
		driver=BrowserFactory.init();
		
		LoginPage loginpage= PageFactory.initElements(driver, LoginPage.class);
		loginpage.insertusername(userName);
		loginpage.insertpassword(Password);
		loginpage.presssigninbutton();
		
		
		DashboardPage dashboardPage=PageFactory.initElements(driver, DashboardPage.class);
		
		dashboardPage.validatedashboardheader(dashboard);
		
		BrowserFactory.TearDown();
	}

}

package test_pomProject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import page.DashboardPage;
import page.LoginPage;
import util.BrowserFactory;

public class LoginTest extends BrowserFactory{
	
	
	WebDriver driver;
	
	String userName="demo@codefios.com";
	String Password="abc123";
	String expectedDashboardHeader="Dashboard";
	String expectedusernameerrormsg="Please enter your user name";
	String expectedpassworderrormsg="Please enter your password";
	
	
	@Test(priority=1)
	public void validateusernamemsg() {
		driver=BrowserFactory.init();
		
		
		LoginPage loginpage=PageFactory.initElements(driver, LoginPage.class);
		loginpage.presssigninbutton();
		loginpage.enterusername(expectedusernameerrormsg);
		
		BrowserFactory.TearDown();
		
	}
	
	
	
	@Test(priority=2)
	public void validatepasswordmsg() {
		driver=BrowserFactory.init();
		
		
		LoginPage loginpage=PageFactory.initElements(driver, LoginPage.class);
		loginpage.insertusername(userName);
		loginpage.presssigninbutton();
		loginpage.enterpassword(expectedpassworderrormsg);
		
		BrowserFactory.TearDown();
		
	}
	
	
	
	@Test(priority=3)
	public void logintoTF() {
		
	driver=BrowserFactory.init();
	
	
	LoginPage loginpage=PageFactory.initElements(driver, LoginPage.class);
	loginpage.insertusername(userName);
	loginpage.insertpassword(Password);
	loginpage.presssigninbutton();
	
	
	DashboardPage dashboardpage=PageFactory.initElements(driver, DashboardPage.class);
	dashboardpage.validatedashboardheader(expectedDashboardHeader);
	
	
	BrowserFactory.TearDown();
		
	}

}

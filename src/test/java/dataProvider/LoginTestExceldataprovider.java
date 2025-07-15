package dataProvider;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import page.DashboardPage;
import page.LoginPage;
import page.LoginPagedataprovider;
import util.BrowserFactory;
import util.ExcelReader;

public class LoginTestExceldataprovider extends BrowserFactory{
	
	
	WebDriver driver;
	
	
	ExcelReader excelreader=new ExcelReader("src\\main\\java\\testData\\TF_TestData.xlsx");
	
	
	 String userName=excelreader.getCellData("LoginInfo", "UserName", 2);
	 String Password=excelreader.getCellData("LoginInfo", "Password", 2);
	 String expectedDashboardHeader=excelreader.getCellData("DashboardInfo", "DashboardHeader", 2);
	 String expectedusernameerrormsg=excelreader.getCellData("LoginInfo", "alertUserValidationText", 2);
	 String expectedpassworderrormsg=excelreader.getCellData("LoginInfo", "alertPasswordValidationText", 2);
	
	
	 
	 @DataProvider(name="login")
		public String[][] learndataprovider1(){
			
			String[][] data=new String[][] {
				
				{"demo@codefios.com","abc123"},
				{"demo@codefios.com","abc123"}
				
			};
			return data;
		}
	 
	 @Test(dataProvider="login")
	public void validateusernamemsg(String username, String password) {
		driver=BrowserFactory.init();
		
		
		LoginPagedataprovider loginpage=PageFactory.initElements(driver, LoginPagedataprovider.class);
		loginpage.insertusername(username);
		loginpage.insertpassword(password);
		loginpage.presssigninbutton();
		
		BrowserFactory.TearDown();
		
	}
	


}

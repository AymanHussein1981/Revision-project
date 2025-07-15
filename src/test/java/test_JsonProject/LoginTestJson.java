package test_JsonProject;

import java.io.FileNotFoundException;
import java.io.FileReader;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import page.LoginPage;
import util.BrowserFactory;

public class LoginTestJson extends BrowserFactory{
	
	
	WebDriver driver;
	JsonElement jelement;
	
	
	@SuppressWarnings("deprecation")
	@BeforeMethod
	public void jsonreader()  {
		
		try {
			FileReader reader = new FileReader("src\\main\\java\\testData\\TF_TestData.json");
			JsonParser jparser=new JsonParser();
			jelement=jparser.parse(reader);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	
	@Test
	public void login() {
		
		driver=BrowserFactory.init();
		
		LoginPage loginpage=PageFactory.initElements(driver, LoginPage.class);
		loginpage.insertusername(jelement.getAsJsonObject().get("LoginInfo").getAsJsonObject().get("UserName").getAsString());
		loginpage.insertpassword(jelement.getAsJsonObject().get("LoginInfo").getAsJsonObject().get("Password").getAsString());
		loginpage.presssigninbutton();
		
		
		BrowserFactory.TearDown();
	}
	
	
	
	
	
	
}

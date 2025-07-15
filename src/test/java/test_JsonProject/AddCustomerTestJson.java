package test_JsonProject;

import java.io.FileNotFoundException;
import java.io.FileReader;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import page.AddCustomerPage;
import page.DashboardPage;
import page.LoginPage;
import util.BrowserFactory;

public class AddCustomerTestJson {
	
	
	WebDriver driver;
	JsonElement jelement;
	
	@SuppressWarnings("deprecation")
	@BeforeMethod
	public void ReadJson() {
		
		try {
			FileReader reader=new FileReader("src\\main\\java\\testData\\TF_TestData.json");
			JsonParser jparser=new JsonParser();
			jelement=jparser.parse(reader);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	
	
	
	@Test
	public void addcustomer() {
		
		driver=BrowserFactory.init();
				
		LoginPage loginpage=PageFactory.initElements(driver, LoginPage.class);
		loginpage.insertusername(jelement.getAsJsonObject().get("LoginInfo").getAsJsonObject().get("UserName").getAsString());
		loginpage.insertpassword(jelement.getAsJsonObject().get("LoginInfo").getAsJsonObject().get("Password").getAsString());
		loginpage.presssigninbutton();
		
		
		
		DashboardPage dashboardpage=PageFactory.initElements(driver, DashboardPage.class);
		dashboardpage.validatedashboardheader(jelement.getAsJsonObject().get("LoginInfo").getAsJsonObject().get("ValidationTextLogin").getAsString());
		dashboardpage.presscustomerbutton();
		dashboardpage.pressaddcustomerbutton();
		
		
		AddCustomerPage addcustomerpage=PageFactory.initElements(driver, AddCustomerPage.class);
		addcustomerpage.insertfullname(jelement.getAsJsonObject().get("AddContact").getAsJsonObject().get("FullName").getAsString());
		addcustomerpage.selectcompanyfromdropdown(jelement.getAsJsonObject().get("AddContact").getAsJsonObject().get("Company").getAsString());
		addcustomerpage.insertcustomerEmail(jelement.getAsJsonObject().get("AddContact").getAsJsonObject().get("Email").getAsString());
		addcustomerpage.insertcustomerPhone(jelement.getAsJsonObject().get("AddContact").getAsJsonObject().get("Phone").getAsString());
		addcustomerpage.selectcountryfromdropdown(jelement.getAsJsonObject().get("AddContact").getAsJsonObject().get("Address").getAsJsonArray().get(0).getAsJsonObject().get("Country").getAsString());
		addcustomerpage.presssavebutton();
		
		BrowserFactory.TearDown();
	}

}

package iFrame_And_Keyboard;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class iFrame {
	
	WebDriver driver;
	
	String Browser="browser";
	String URL="url";
	String userName="username";
	String Password="password";
	String expectedDashboardHeader="dashboardheader";
	
	By USERNAME_FILED=By.xpath("//*[@id=\"user_name\"]");
	By PASSWORD_FILED=By.xpath("//*[@id=\"password\"]");
	By SIGNIN_FILED=By.xpath("//*[@id=\"login_submit\"]");
	By DASHBOARD_FILED=By.xpath("/html/body/div[1]/section/div/div[2]/div/div/header/div/strong");
	By REALESTATE_FIELD=By.xpath("//*[@id=\"ad_three\"]");
	By STUDENTLOGIN_FIELD=By.xpath("//*[@id=\"portal_three\"]");
	By GROUPNAME_FIELD=By.xpath("//*[@id=\"customer_groupName\"]");
	
	
	@BeforeClass
	public void configuration() throws IOException {
		
		InputStream input=new FileInputStream("src\\main\\java\\config\\config.Properties");
		Properties prop=new Properties();
		prop.load(input);
		Browser=prop.getProperty("browser");
		URL=prop.getProperty("url");
		userName=prop.getProperty("username");
		Password=prop.getProperty("password");
		expectedDashboardHeader=prop.getProperty("dashboardheader");
	}
	
	
	
	@BeforeMethod
	public void init() {
		
		if(Browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "driver\\chromedriver.exe");
			driver=new ChromeDriver();
		}
		else if(Browser.equalsIgnoreCase("edge")) {
			System.setProperty("webdriver.edge.driver", "driver\\msedgedriver.exe");
			driver=new EdgeDriver();
		}
		else {
			System.out.println("invalid browser");
		}
		
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get(URL);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	}
	
	
	
	@Test
	public void LoginTest() throws InterruptedException {
		
		driver.findElement(USERNAME_FILED).sendKeys(userName);
		driver.findElement(PASSWORD_FILED).sendKeys(Password);
		driver.findElement(SIGNIN_FILED).click();
		
		Assert.assertEquals(expectedDashboardHeader, driver.findElement(DASHBOARD_FILED).getText() , "page not found");
		
		

		driver.switchTo().frame("advertisement");
		driver.switchTo().frame("portals");
		driver.findElement(STUDENTLOGIN_FIELD).click();
		Thread.sleep(2000);
		driver.switchTo().parentFrame();
		driver.findElement(REALESTATE_FIELD).click();
		Thread.sleep(2000);
		driver.switchTo().defaultContent();
		driver.switchTo().frame("customer_groupaddframe");
		driver.findElement(GROUPNAME_FIELD).sendKeys("Ayman Hussein");
		Thread.sleep(2000);
	}
	
	
	
	@Test
	public void LoginTest1() throws InterruptedException {
		
		driver.findElement(USERNAME_FILED).sendKeys(userName);
		driver.findElement(PASSWORD_FILED).sendKeys(Password);
		driver.findElement(SIGNIN_FILED).click();
		
		Assert.assertEquals(expectedDashboardHeader, driver.findElement(DASHBOARD_FILED).getText() , "page not found");

		
		driver.switchTo().frame("customer_groupaddframe");
		driver.findElement(GROUPNAME_FIELD).sendKeys("Ayman Hussein");
		Thread.sleep(2000);
	}
	
	@AfterMethod
	public void TearDown() {
		
		driver.close();
		driver.quit();
	}

}

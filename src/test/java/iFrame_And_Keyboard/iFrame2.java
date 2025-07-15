package iFrame_And_Keyboard;

import java.io.FileInputStream;
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

public class iFrame2 {
	
	WebDriver driver;
	
	String Browser="browser";
	String URL="url";
	String userName="username";
	String Password="password";
	String expectedDashboardHeader="dashboardheader";
	
//	By USERNAME_FILED=By.xpath("//*[@id=\"user_name\"]");
//	By PASSWORD_FILED=By.xpath("//*[@id=\"password\"]");
//	By SIGNIN_FILED=By.xpath("//*[@id=\"login_submit\"]");
//	By DASHBOARD_FILED=By.xpath("/html/body/div[1]/section/div/div[2]/div/div/header/div/strong");
//	By REALESTATE_FIELD=By.xpath("//*[@id=\"ad_three\"]");
//	By STUDENTLOGIN_FIELD=By.xpath("//*[@id=\"portal_three\"]");
//	By GROUPNAME_FIELD=By.xpath("//*[@id=\"customer_groupName\"]");
	
	
	@BeforeClass
	public void configuration() throws IOException {
		
		InputStream input=new FileInputStream("src\\main\\java\\config\\config.Properties");
		Properties prop=new Properties();
		prop.load(input);
		Browser=prop.getProperty("browser");
		
	
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
		driver.get("https://docs.oracle.com/javase/8/docs/api/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	}
	
	
	
	@Test
	public void LoginTest() throws InterruptedException {

		driver.switchTo().frame("packageListFrame");
		driver.findElement(By.xpath("/html/body/div[2]/ul/li[2]/a")).click();
		Thread.sleep(2000);
		driver.switchTo().defaultContent();
		driver.switchTo().frame("packageFrame");
		driver.findElement(By.xpath("/html/body/div/ul[1]/li[7]/a")).click();
		Thread.sleep(2000);
		driver.switchTo().defaultContent();
		driver.switchTo().frame("packageListFrame");
		driver.findElement(By.xpath("/html/body/div[2]/ul/li[1]/a")).click();
		Thread.sleep(2000);
		driver.switchTo().defaultContent();
		driver.switchTo().frame("packageFrame");
		driver.findElement(By.xpath("/html/body/div/ul[1]/li[1]/a")).click();
		Thread.sleep(2000);
		driver.switchTo().defaultContent();
		driver.switchTo().frame("classFrame");
		driver.findElement(By.xpath("//*[@id=\"i0\"]/td[1]/code/a")).click();
		Thread.sleep(2000);
	}	
		
		@Test
		public void LoginTest1() throws InterruptedException {

			
		
			driver.switchTo().frame("packageFrame");
			driver.findElement(By.xpath("/html/body/div/ul/li[6]/a")).click();
			Thread.sleep(2000);
		
		

	
						  
	}
	
	
	@AfterMethod
	public void TearDown() {
		
		driver.close();
		driver.quit();
	}

}

package test_By_And_WebElementType;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class WebElementType {
	
	
WebDriver driver;
	
	String Browser="browser";
	String URL="url";
	String userName="username";
	String Password="password";
	String expectedDashboardHeader="dashboardheader";
	
	
	
	
	
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
	public void LoginTest() {
		
		WebElement USERNAME_FILED=driver.findElement(By.xpath("//*[@id=\"user_name\"]"));
		WebElement PASSWORD_FILED=driver.findElement(By.xpath("//*[@id=\"password\"]"));
		WebElement SIGNIN_FILED=driver.findElement(By.xpath("//*[@id=\"login_submit\"]"));
		//WebElement DASHBOAR_DHEADER_FILED=driver.findElement(By.xpath("/html/body/div[1]/section/div/div[2]/div/div/header/div/strong"));
		
		USERNAME_FILED.sendKeys(userName);
		PASSWORD_FILED.sendKeys(Password);
		SIGNIN_FILED.click();
		//Assert.assertEquals(expectedDashboardHeader, DASHBOAR_DHEADER_FILED.getText() , "page not found");
		
	}
	
	
	@AfterMethod
	public void TearDown() {
		
		driver.close();
		driver.quit();
	}

}

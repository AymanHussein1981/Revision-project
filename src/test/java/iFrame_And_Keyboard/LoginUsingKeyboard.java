package iFrame_And_Keyboard;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginUsingKeyboard {
	
	
WebDriver driver;
	
	
	
	By USERNAME_FILED=By.xpath("//*[@id=\"user_name\"]");
	By PASSWORD_FILED=By.xpath("//*[@id=\"password\"]");
	
	
	
	
	
	
	
	@BeforeMethod
	public void init() {
		
		
			System.setProperty("webdriver.edge.driver", "driver\\msedgedriver.exe");
			driver=new EdgeDriver();
	
		
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get("https://codefios.com/ebilling/login");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	}
	
	
	
	@Test
	public void LoginTest() throws InterruptedException {
		
		driver.findElement(USERNAME_FILED).sendKeys("demo@codefios.com");
		driver.findElement(PASSWORD_FILED).sendKeys("abc123");
		
		Actions action=new Actions(driver);
		action.sendKeys(Keys.ENTER).build().perform();
		
		JavascriptExecutor js= (JavascriptExecutor) driver;
		js.executeScript("scroll(0,1000)");
		
		Thread.sleep(3000);
		
		
	}
	
	
	@AfterMethod
	public void TearDown() {
		
		driver.close();
		driver.quit();
	}


}

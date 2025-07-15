package util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class BrowserFactory {
	
	static WebDriver driver;
	
	static String Browser="browser";
	static String URL="url";
	
	
	
	
	public static void configuration() {
		
		InputStream input;
		try {
			input = new FileInputStream("src\\main\\java\\config\\config.Properties");
			Properties prop=new Properties();
			
			prop.load(input);
			Browser=prop.getProperty("browser");
			URL=prop.getProperty("url");
			
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
	}
	
	
	
	public static WebDriver init() {
		
		configuration();
		
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
		return driver;
	}
	
	
	
	
	public static void TearDown() {
		driver.close();
		driver.quit();
	}

}

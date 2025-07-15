package page;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPageKeyboard {
	
	WebDriver driver;
	
	public LoginPageKeyboard(WebDriver driver) {
		this.driver=driver;
	}
	
	@FindBy(how=How.XPATH,using="//*[@id=\"user_name\"]")WebElement userNameElement;
	@FindBy(how=How.XPATH,using="//*[@id=\"password\"]")WebElement PasswordElement;
	
	
	
	
	
	public void insertusername(String username) {
		userNameElement.sendKeys(username);
		
	}
	
	
	public void insertpassword(String password) {
		PasswordElement.sendKeys(password);
		
	}
	
	
	public void presssigninbutton() {
		
		Actions action= new Actions(driver);
		action.sendKeys(Keys.ENTER).build().perform();
	}

}

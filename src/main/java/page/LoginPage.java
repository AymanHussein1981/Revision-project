package page;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;

public class LoginPage {
	
	
	WebDriver driver;
	
	
	public LoginPage(WebDriver driver){
		this.driver=driver;
	}
	
	
	@FindBy(how=How.XPATH,using="//*[@id=\"user_name\"]")WebElement userNameElement;
	@FindBy(how=How.XPATH,using="//*[@id=\"password\"]")WebElement PasswordElement;
	@FindBy(how=How.XPATH,using="//*[@id=\"login_submit\"]")WebElement SigninElement;
	
	
	
	public void insertusername(String username) {
		userNameElement.sendKeys(username);
		
	}
	
	
	public void insertpassword(String password) {
		PasswordElement.sendKeys(password);
		
	}
	
	
	public void presssigninbutton() {
		SigninElement.click();
		
	}
	
	
	public void enterusername(String expectedusernameerrormsg) {
		
		String acutalusernameerrormsg=driver.switchTo().alert().getText();
		Assert.assertEquals(acutalusernameerrormsg, expectedusernameerrormsg, "Msg not correct");
		driver.switchTo().alert().accept();
	}
	
	
	
	public void enterpassword(String expectedpassworderrormsg) {
		
		String acutalpassworderrormsg=driver.switchTo().alert().getText();
		Assert.assertEquals(acutalpassworderrormsg, expectedpassworderrormsg, "Msg not correct");
		driver.switchTo().alert().accept();
	}

}

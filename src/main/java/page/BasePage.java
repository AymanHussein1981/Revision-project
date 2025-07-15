package page;

import java.util.Random;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class BasePage {
	
	
	public void SelectfromDropDown(WebElement element, String visibleText) {
		
		Select sel=new Select(element);
		sel.selectByVisibleText(visibleText);
		
	}
	
	
	public int generateNum(int BoundryNum) {
		
		Random rand=new Random();
		int generaterandNum=rand.nextInt(999);
		return generaterandNum;
	}

}

package bahaso.testing.webElement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import bahaso.testing.general.WaitElement;

public class LoginPage {
	WebDriver driver = null;
	WaitElement wt = new WaitElement();
	public WebElement usernameButton = null;
	
	public LoginPage(WebDriver driver){
		this.driver = driver;
	}
	
	public WebElement getUsernameButton(){
		usernameButton = wt.waitForElement(driver, By.xpath(".//*[@id='nav-main']/ul[2]/li[1]/a"));
		return usernameButton;
	}
	
	
}
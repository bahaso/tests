package bahaso.testing.webElement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	public WebElement usernameButton = null;
	
	public WebElement getUsernameButton(WebDriver driver){
		usernameButton = driver.findElement(By.xpath(".//*[@id='nav-main']/ul[2]/li[1]/a"));
		return usernameButton;
	}
	
	
}

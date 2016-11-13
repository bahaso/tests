package bahaso.testing.webElement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RegisterPage {
	public WebElement inputRegisterFirstname = null;
	public WebElement inputRegisterLastname = null;
	public WebElement inputRegisterEmail = null;
	public WebElement inputRegisterPassword = null;
	public WebElement RegisterButton = null;
	
	public WebElement getInputRegisterFirstname(WebDriver driver){
		inputRegisterFirstname = driver.findElement(By.xpath(".//*[@id='register-firstname']"));
		return inputRegisterFirstname;
	}
	
	public WebElement getInputRegisterLastname(WebDriver driver){
		inputRegisterLastname = driver.findElement(By.xpath(".//*[@id='register-lastname']"));
		return inputRegisterLastname;
	}
	
	public WebElement getInputRegisterEmail(WebDriver driver){
		inputRegisterEmail = driver.findElement(By.xpath(".//*[@id='register-email']"));
		return inputRegisterEmail;
	}
	
	public WebElement getInputRegisterPassword(WebDriver driver){
		inputRegisterPassword = driver.findElement(By.xpath(".//*[@id='register-password']"));
		return inputRegisterPassword;
	}
	
	public WebElement getRegisterButton(WebDriver driver){
		RegisterButton = driver.findElement(By.xpath(".//*[@id='form-register']/div[5]/div/button"));
		return RegisterButton;
	}
}

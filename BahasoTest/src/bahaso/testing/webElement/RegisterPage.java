package bahaso.testing.webElement;

import java.util.HashMap;

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
	
	public String getInputRegisterFirstnameErrorMassage(WebDriver driver){
		return driver.findElement(By.xpath(".//*[@id='form-register']/div[1]/div")).getAttribute("data-original-title");
	}
	
	public String getInputRegisterLastnameErrorMassage(WebDriver driver){
		return driver.findElement(By.xpath(".//*[@id='form-register']/div[2]/div")).getAttribute("data-original-title");
	}
	
	public String getInputRegisterEmailErrorMassage(WebDriver driver){
		return driver.findElement(By.xpath(".//*[@id='form-register']/div[3]/div")).getAttribute("data-original-title");
	}
	
	public String getInputRegisterPasswordErrorMassage(WebDriver driver){
		return driver.findElement(By.xpath(".//*[@id='form-register']/div[4]/div")).getAttribute("data-original-title");
	}
	
	public void doRegister(WebDriver driver, HashMap<String, String> RegisterData) throws InterruptedException{
		getInputRegisterFirstname(driver).sendKeys(RegisterData.get("firstname"));
		getInputRegisterLastname(driver).sendKeys(RegisterData.get("lastname"));
		getInputRegisterEmail(driver).sendKeys(RegisterData.get("email"));
		getInputRegisterPassword(driver).sendKeys(RegisterData.get("password"));
		getRegisterButton(driver).click();
		Thread.sleep(3000);
	}
}

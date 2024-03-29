package bahaso.testing.webElement;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import bahaso.testing.general.WaitElement;

public class RegisterPage {
	WebDriver driver = null;
	WaitElement wt = new WaitElement();
	public WebElement inputRegisterFirstname = null;
	public WebElement inputRegisterLastname = null;
	public WebElement inputRegisterEmail = null;
	public WebElement inputRegisterPassword = null;
	public WebElement RegisterButton = null;
	
	public RegisterPage(WebDriver driver){
		this.driver = driver;
	}
	public WebElement getInputRegisterFirstname(){
		inputRegisterFirstname = wt.waitForElement(driver, By.xpath(".//*[@id='register-firstname']"));
		return inputRegisterFirstname;
	}
	
	public WebElement getInputRegisterLastname(){
		inputRegisterLastname = wt.waitForElement(driver, By.xpath(".//*[@id='register-lastname']"));
		return inputRegisterLastname;
	}
	
	public WebElement getInputRegisterEmail(){
		inputRegisterEmail = wt.waitForElement(driver, By.xpath(".//*[@id='register-email']"));
		return inputRegisterEmail;
	}
	
	public WebElement getInputRegisterPassword(){
		inputRegisterPassword = wt.waitForElement(driver, By.xpath(".//*[@id='register-password']"));
		return inputRegisterPassword;
	}
	
	public WebElement getRegisterButton(){
		RegisterButton = wt.waitForElement(driver, By.xpath(".//*[@id='form-register']/div[5]/div/button"));
		return RegisterButton;
	}
	
	public String getInputRegisterFirstnameErrorMassage(){
		return driver.findElement(By.xpath(".//*[@id='form-register']/div[1]/div")).getAttribute("data-original-title");
	}
	
	public String getInputRegisterLastnameErrorMassage(){
		return driver.findElement(By.xpath(".//*[@id='form-register']/div[2]/div")).getAttribute("data-original-title");
	}
	
	public String getInputRegisterEmailErrorMassage(){
		return driver.findElement(By.xpath(".//*[@id='form-register']/div[3]/div")).getAttribute("data-original-title");
	}
	
	public String getInputRegisterPasswordErrorMassage(){
		return driver.findElement(By.xpath(".//*[@id='form-register']/div[4]/div")).getAttribute("data-original-title");
	}
	
	public void doRegister(HashMap<String, String> RegisterData) throws InterruptedException{
		getInputRegisterFirstname().sendKeys(RegisterData.get("firstname"));
		getInputRegisterLastname().sendKeys(RegisterData.get("lastname"));
		getInputRegisterEmail().sendKeys(RegisterData.get("email"));
		getInputRegisterPassword().sendKeys(RegisterData.get("password"));
		getRegisterButton().click();
	}
}

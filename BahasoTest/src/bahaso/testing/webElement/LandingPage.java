package bahaso.testing.webElement;

import org.openqa.selenium.WebElement;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LandingPage{
	
	public WebElement masukButton = null;
	public WebElement LoginButton = null;
	public WebElement RegisterButton = null;
	
	public WebElement inputLoginEmail = null;
	public WebElement inputLoginPassword = null;
	public WebElement loginErrorMessage = null;
	
	public WebElement inputRegisterFirstname = null;
	public WebElement inputRegisterLastname = null;
	public WebElement inputRegisterEmail = null;
	public WebElement inputRegisterPassword = null;
	
	public WebElement getMasukButtonElement(WebDriver driver){
		masukButton = driver.findElement(By.xpath(".//*[@id='navbar-collapse']/p[2]/button"));
		return masukButton;
	}
	
	public WebElement getLoginButtonElement(WebDriver driver){
		LoginButton = driver.findElement(By.xpath(".//*[@id='form-login']/button"));
		return LoginButton;
	}
	
	public WebElement getInputEmailElement(WebDriver driver){
		inputLoginEmail = driver.findElement(By.xpath(".//*[@id='login-email']"));
		return inputLoginEmail;
	}
	
	public WebElement getInputPasswordElement(WebDriver driver){
		inputLoginPassword = driver.findElement(By.xpath(".//*[@id='login-password']"));
		return inputLoginPassword;
	}
	
	public String getLoginErrorMessage(WebDriver driver){
		loginErrorMessage = driver.findElement(By.xpath(".//*[@id='login-error']"));
		return loginErrorMessage.getText();
	}
	
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
		RegisterButton = driver.findElement(By.xpath(".//*[@id='form-register']/button"));
		return RegisterButton;
	}
	
	public String getInputRegisterFirstnameErrorMassage(WebDriver driver){
		return getInputRegisterFirstname(driver).getAttribute("data-original-title");
	}
	
	public String getInputRegisterLastnameErrorMassage(WebDriver driver){
		return getInputRegisterLastname(driver).getAttribute("data-original-title");
	}
	
	public String getInputRegisterEmailErrorMassage(WebDriver driver){
		return getInputRegisterEmail(driver).getAttribute("data-original-title");
	}
	
	public String getInputRegisterPasswordErrorMassage(WebDriver driver){
		return getInputRegisterPassword(driver).getAttribute("data-original-title");
	}
	
	/**
	 * ################################################################
	 * Operation
	 */
	
	public void doLogin(WebDriver driver, HashMap<String, String> LoginData){
		getMasukButtonElement(driver).click();
		getInputEmailElement(driver).sendKeys(LoginData.get("email"));
		getInputPasswordElement(driver).sendKeys(LoginData.get("password"));
		getLoginButtonElement(driver).click();
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

package bahaso.testing.webElement;

import org.openqa.selenium.WebElement;

import bahaso.testing.general.WaitElement;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LandingPage{
	WebDriver driver = null;
	WaitElement wt = new WaitElement();
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
	
	public LandingPage(WebDriver driver){
		this.driver = driver;
	}
	
	public WebElement getMasukButtonElement(){
		masukButton = wt.waitForElement(driver, By.xpath(".//*[@id='navbar-collapse']/p[2]/button"));
		return masukButton;
	}
	
	public WebElement getLoginButtonElement(){
		LoginButton = wt.waitForElement(driver, By.xpath(".//*[@id='form-login']/button"));
		return LoginButton;
	}
	
	public WebElement getInputEmailElement(){
		inputLoginEmail = wt.waitForElement(driver, By.xpath(".//*[@id='login-email']"));
		return inputLoginEmail;
	}
	
	public WebElement getInputPasswordElement(){
		inputLoginPassword =wt.waitForElement(driver, By.xpath(".//*[@id='login-password']"));
		return inputLoginPassword;
	}
	
	public String getLoginErrorMessage(){
		loginErrorMessage = wt.waitForElement(driver, By.xpath(".//*[@id='login-error']"));
		return loginErrorMessage.getText();
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
		RegisterButton = wt.waitForElement(driver, By.xpath(".//*[@id='form-register']/button"));
		return RegisterButton;
	}
	
	public String getInputRegisterFirstnameErrorMassage(){
		return getInputRegisterFirstname().getAttribute("data-original-title");
	}
	
	public String getInputRegisterLastnameErrorMassage(){
		return getInputRegisterLastname().getAttribute("data-original-title");
	}
	
	public String getInputRegisterEmailErrorMassage(){
		return getInputRegisterEmail().getAttribute("data-original-title");
	}
	
	public String getInputRegisterPasswordErrorMassage(){
		return getInputRegisterPassword().getAttribute("data-original-title");
	}
	
	/**
	 * ################################################################
	 * Operation
	 */
	
	public void doLogin(HashMap<String, String> LoginData){
		getMasukButtonElement().click();
		getInputEmailElement().sendKeys(LoginData.get("email"));
		getInputPasswordElement().sendKeys(LoginData.get("password"));
		getLoginButtonElement().click();
	}
	
	public void doRegister(HashMap<String, String> RegisterData){
		getInputRegisterFirstname().sendKeys(RegisterData.get("firstname"));
		getInputRegisterLastname().sendKeys(RegisterData.get("lastname"));
		getInputRegisterEmail().sendKeys(RegisterData.get("email"));
		getInputRegisterPassword().sendKeys(RegisterData.get("password"));
		getRegisterButton().click();
	}
	
}

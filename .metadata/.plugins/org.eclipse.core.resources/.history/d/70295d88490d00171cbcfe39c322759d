package bahaso.testing.androidElement;

import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;

import io.appium.java_client.android.AndroidDriver;

public class Login {
	AndroidDriver driver;
	public WebElement input_email;
	public WebElement input_Password;
	public WebElement forgot_Password;
	public WebElement btn_Login;
	
	public Login(AndroidDriver driver){
		this.driver = driver;
	}
	
	public WebElement getInputEmail(){
		input_email = driver.findElementById("com.bahaso:id/input_email_username");
		return input_email;
	}
	
	public WebElement getInputPassword(){
		input_Password = driver.findElementById("com.bahaso:id/input_password");
		return input_Password;
	}
	
	public WebElement getForgotPassword(){
		btn_Login = driver.findElementById("com.bahaso:id/txt_forget_pass");
		return btn_Login;
	}
	
	public WebElement getBtnLogin(){
		btn_Login = driver.findElementById("com.bahaso:id/layout_btn_login_email");
		return btn_Login;
	}
	
	@AfterMethod
	public void afterMethod(){	
		driver.quit();
	}
}

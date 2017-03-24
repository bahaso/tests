package bahaso.testing.androidElement;

import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;

import io.appium.java_client.android.AndroidDriver;

public class Login {
	AndroidDriver driver;
	
	public Login(AndroidDriver driver){
		this.driver = driver;
	}
	
	public WebElement getInputEmail(){
		return driver.findElementById("com.bahaso:id/input_email_username");
	}
	
	public WebElement getInputPassword(){
		return driver.findElementById("com.bahaso:id/input_password");
	}
	
	public WebElement getForgotPassword(){
		return driver.findElementById("com.bahaso:id/txt_forget_pass");
	}
	
	public WebElement getBtnLogin(){
		return driver.findElementById("com.bahaso:id/layout_btn_login_email");
	}
	
	@AfterMethod
	public void afterMethod(){	
		driver.quit();
	}
}
package bahaso.testing.androidElement;

import org.openqa.selenium.WebElement;

import io.appium.java_client.android.AndroidDriver;

public class Register {
	AndroidDriver driver;
	public WebElement input_Firstname;
	public WebElement input_LastName;
	public WebElement input_Email;
	public WebElement input_Password;
	public WebElement btn_Register;
	
	public Register(AndroidDriver driver){
		this.driver = driver;
	}
	
	public WebElement getInputFirstname(){
		input_Firstname = driver.findElementById("com.bahaso:id/input_nama_depan");
		return input_Firstname;
	}
	
	public WebElement getInputLastname(){
		input_LastName = driver.findElementById("com.bahaso:id/input_nama_belakang");
		return input_LastName;
	}
	
	public WebElement getInputEmail(){
		input_Email = driver.findElementById("com.bahaso:id/input_email_username");
		return input_Email;
	}
	
	public WebElement getInputPassword(){
		input_Password = driver.findElementById("com.bahaso:id/input_password");
		return input_Password;
	}
	
	public WebElement getBtnRegister(){
		btn_Register = driver.findElementById("com.bahaso:id/layout_btn_register");
		return btn_Register;
	}
}

package bahaso.testing.androidElement;

import org.openqa.selenium.WebElement;

import io.appium.java_client.android.AndroidDriver;

public class Register {
	AndroidDriver driver;
	
	public Register(AndroidDriver driver){
		this.driver = driver;
	}
	
	public WebElement getInputFirstname(){
		return driver.findElementById("com.bahaso:id/input_nama_depan");
	}
	
	public WebElement getInputFirstnameErrorMessage(){
		return driver.findElementById("com.bahaso:id/textinput_error");
	}
	
	public WebElement getInputLastname(){
		return driver.findElementById("com.bahaso:id/input_nama_belakang");
	}
	
	public WebElement getInputLastnameErrorMessage(){
		return driver.findElementById("com.bahaso:id/textinput_error");
	}
	
	public WebElement getInputEmail(){
		return driver.findElementById("com.bahaso:id/input_email_username");
	}
	
	public WebElement getInputEmailErrorMessage(){
		return driver.findElementById("com.bahaso:id/textinput_error");
	}
	
	public WebElement getInputPassword(){
		return driver.findElementById("com.bahaso:id/input_password");
	}
	
	public WebElement getInputPasswordErrorMessage(){
		return driver.findElementById("com.bahaso:id/textinput_error");
	}
	
	public WebElement getBtnRegister(){
		return driver.findElementById("com.bahaso:id/layout_btn_register");
	}
}
package bahaso.testing.androidElement;

import java.util.ArrayList;

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
	
	public WebElement getInputLastname(){
		return driver.findElementById("com.bahaso:id/input_nama_belakang");
	}
	
	public WebElement getInputEmail(){
		return driver.findElementById("com.bahaso:id/input_email_username");
	}
	
	public WebElement getInputPassword(){
		return driver.findElementById("com.bahaso:id/input_password");
	}
	
	public ArrayList<WebElement> getErrorMessage(){
		return (ArrayList<WebElement>) driver.findElementsById("com.bahaso:id/textinput_error");
	}
	
	public WebElement getPopUpErrorMessage(){
		return driver.findElementById("android:id/message");
	}
	
	public WebElement getBtnRegister(){
		return driver.findElementById("com.bahaso:id/layout_btn_register");
	}
}

package mz.page.mobile;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;

public class LoginPage extends MobileApplication {
	public LoginPage(AppiumDriver driver)
	{
		this.driver = driver;
	}
	public void SetTextEmailOrUsername(String emailOrUsername){
		this.FindElementByID("com.bahaso:id/et_username", "").sendKeys(emailOrUsername);
	}
	public void SetTextPassword(String password){
		this.FindElementByID("com.bahaso:id/et_password", "").sendKeys(password);
	}
	public void ClickButtonMasuk(){
		this.FindElementByID("com.bahaso:id/btn_login", "").click();
	}
	public void ClickLinkForgetPassword(){
		this.FindElementByID("com.bahaso:id/forgotPass", "").click();
	}
}

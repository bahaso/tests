package mz.page.android;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;

public class LoginPage{
	AndroidApplication mobileApplication = AndroidApplication.getInstance();
	public void SetTextEmailOrUsername(String emailOrUsername){
		mobileApplication.getDriver().findElementById("com.bahaso:id/et_username").sendKeys(emailOrUsername);
	}
	public void SetTextPassword(String password){
		mobileApplication.getDriver().findElementById("com.bahaso:id/et_password").sendKeys(password);
	}
	public void ClickButtonMasuk(){
		mobileApplication.getDriver().findElementById("com.bahaso:id/btn_login").click();
	}
	public void ClickLinkForgetPassword(){
		mobileApplication.getDriver().findElementById("com.bahaso:id/forgotPass").click();
	}
}

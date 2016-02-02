package mz.page.android;

import io.appium.java_client.AppiumDriver;

public class LandingPage{
	AndroidApplication mobileApplication = AndroidApplication.getInstance();
	
	public void ClickButtonRegister(){
		mobileApplication.getDriver().findElementById("com.bahaso:id/btn_front_register").click();
	}
	
	public void ClickButtonLogin(){
		mobileApplication.getDriver().findElementById("com.bahaso:id/btn_front_login").click();
	}
}

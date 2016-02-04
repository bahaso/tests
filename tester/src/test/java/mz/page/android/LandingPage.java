package mz.page.android;

import mz.page.general.AbstractAndroid;

public class LandingPage extends AbstractAndroid {
	
	private String btnRegister = "com.bahaso:id/btn_front_register";
	
	private String btnLogin = "com.bahaso:id/btn_front_login";
	
	public void ClickButtonRegister(){
		mobileApplication.getDriver().findElementById(btnRegister).click();
	}
	
	public void ClickButtonLogin(){
		mobileApplication.getDriver().findElementById(btnLogin).click();
	}
	
}

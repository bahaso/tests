package mz.page.mobile;

import io.appium.java_client.AppiumDriver;

public class LandingPage extends MobileApplication {
	public LandingPage(AppiumDriver driver){
		this.driver = driver;
	}
	public void ClickButtonRegister(){
		this.FindElementByID("com.bahaso:id/btn_front_register","").click();
	}
	public void ClickButtonLogin(){
		this.FindElementByID("com.bahaso:id/btn_front_login","").click();
	}
}

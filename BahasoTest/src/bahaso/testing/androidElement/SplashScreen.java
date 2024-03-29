package bahaso.testing.androidElement;

import java.util.ArrayList;

import org.openqa.selenium.WebElement;

import io.appium.java_client.android.AndroidDriver;

public class SplashScreen {
	AndroidDriver driver;
	public WebElement FB_Login_Button;
	public WebElement GooglePlus_Login_Button;
	public WebElement Sign_Up_Button;
	public WebElement Login_Email_Button;
	public ArrayList<WebElement> XButton;
	
	public SplashScreen(AndroidDriver driver){
		this.driver = driver;
	}
	
	public WebElement getFBLoginButton(){
		return driver.findElementById("com.bahaso:id/layout_btn_login_fb");
	}
	
	public WebElement getGooglePlusLoginButton(){
		return driver.findElementById("com.bahaso:id/layout_btn_login_gplus");
	}
	
	public WebElement getSignUpButton(){
		return driver.findElementById("com.bahaso:id/btn_daftar_baru");
	}
	
	public WebElement getLoginEmailButton(){
		return driver.findElementById("com.bahaso:id/btn_email_login");
	}
	
	public ArrayList<WebElement> getXButton(){
		return (ArrayList<WebElement>) driver.findElementsByClassName("android.widget.ImageView");
	}
}

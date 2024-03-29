package bahaso.testing.androidElement;

import java.util.ArrayList;

import org.openqa.selenium.WebElement;

import io.appium.java_client.android.AndroidDriver;

public class Setting {
	AndroidDriver driver;
	
	public Setting(AndroidDriver driver){
		this.driver = driver;
	}
	
	public ArrayList<WebElement> getMenu(){
		return (ArrayList<WebElement>) driver.findElementsById("android:id/title");
	}
	
	public WebElement getPopUpErrorMessage(){
		return driver.findElementById("android:id/message");
	}
	
	public WebElement getPopUpErrorMessageBtnYes(){
		return driver.findElementById("android:id/button1");
	}
	
}

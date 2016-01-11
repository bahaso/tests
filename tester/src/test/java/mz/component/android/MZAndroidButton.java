package mz.component.android;

import org.openqa.selenium.WebElement;

import io.appium.java_client.android.AndroidDriver;
import mz.component.behavior.IButton;

public class MZAndroidButton implements IButton{

	AndroidDriver driver = null;
	
	public MZAndroidButton(AndroidDriver driver)
	{
		this.driver = driver;
	}
	
	public WebElement Login() {
		return driver.findElementById("com.bahaso:id/btn_login");
	}

	public WebElement Next() {
		return driver.findElementById("");
	}

	public WebElement PlayVideo() {
		return null;
	}

	public WebElement PlaySound() {
		// TODO Auto-generated method stub
		return null;
	}
	
}

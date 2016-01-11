package mz.page.mobile;

import org.openqa.selenium.WebElement;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;

public abstract class MobileApplication {
	protected AppiumDriver driver;
	public WebElement FindElementByID(String androidID, String iosID)
	{		
		if(this.driver instanceof AndroidDriver)
			return this.driver.findElementById(androidID);
		else if (this.driver instanceof IOSDriver)
			return this.driver.findElementById(iosID);
		else return null;
	}
}

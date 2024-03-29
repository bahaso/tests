package bahaso.testing.general;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;

public class mobileGeneral {
	public AndroidDriver driver;
	public TouchAction action;
	
	public AndroidDriver startEngine(){
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("deviceName", "ASUS_Z010D");
		cap.setCapability("platformVersion", "5.0.2");
		//cap.setCapability("deviceName", "Galaxy J1 ace");
		//cap.setCapability("platformVersion", "5.1.1");
		cap.setCapability("platformName", "Android");
		cap.setCapability("appPackage", "com.bahaso");
		cap.setCapability("appActivity", "com.bahaso.SplashScreen");
		cap.setCapability("noReset", true);
		try {
			driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"), cap);
			//driver = new AndroidDriver(new URL("http://192.168.1.3:4723/wd/hub"), cap);
			//driver = new AndroidDriver(new URL("http://10.10.16.64:4723/wd/hub"), cap);
			driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		action = new TouchAction((PerformsTouchActions)driver);
		return driver;
	}
}

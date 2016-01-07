package mz.driver;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;
import mz.enumeration.DeviceType;

public class MZAndroidDriver extends MZMobileDriver{
	
	public MZAndroidDriver() {}

	@Override
	protected void setApplicationPath() {
		File classpathRoot = new File("D:/bahaso-android/mobile-android");
		File appDir = new File(classpathRoot, "/app/build/outputs/apk/");
		app = new File(appDir, "app-debug.apk");
	}
	
	public AndroidDriver getDriver() throws MalformedURLException {
		if(driver == null) setDriver();
		return (AndroidDriver)driver;
	}

	protected void setDriver() throws MalformedURLException {
		if(capabilities == null)DesiredCapabilitiesSetting();
		this.driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
	}

	public void setDriverDevice(DeviceType device) {
		switch(device)
		{
		case EMULATOR:
			capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Emulator");
			break;
		case REAL_DEVICE:
			capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Device");
			break;
		}
	}
	
	private void DesiredCapabilitiesSetting()
	{
		if(capabilities == null)
		{
			capabilities = new DesiredCapabilities();		
			capabilities.setCapability("platformVersion","4.4.4");
			capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,MobilePlatform.ANDROID);
			capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Emulator");
			capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "100");
			setApplicationPath();
			capabilities.setCapability(MobileCapabilityType.APP, app);
		}
	}
}

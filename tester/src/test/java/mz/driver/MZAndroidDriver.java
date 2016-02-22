package mz.driver;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;
import mz.enumeration.DeviceType;

public class MZAndroidDriver{
	
	private AndroidDriver<MobileElement> driver = null;
	
	private File app;
	
	private DesiredCapabilities capabilities;
	
	public MZAndroidDriver() {}
	
	protected void setApplicationPath() {
		File classpathRoot = new File("D:/bahaso-android/mobile-android");
		File appDir = new File(classpathRoot, "/app/build/outputs/apk/");
		app = new File(appDir, "app-debug.apk");
	}
	
	public AndroidDriver<MobileElement> getDriver()
	{
		if(capabilities == null) DesiredCapabilitiesSetting();
		try {
			if(driver == null)
			{
				this.runAppiumServer();
				driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
			}
			return driver;
		} catch (MalformedURLException e) {
			e.printStackTrace();
			return null;
		}
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
			capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Device");
			capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "100");
			setApplicationPath();
			capabilities.setCapability(MobileCapabilityType.APP, app);
		}
	}
	
	private void runAppiumServer()
	{
		String path = "src\\startappium.bat";
		try {
			Runtime.getRuntime().exec("cmd /c start "+path);
			Thread.sleep(20000L);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}

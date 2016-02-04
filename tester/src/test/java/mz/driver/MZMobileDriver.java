package mz.driver;

import org.openqa.selenium.remote.RemoteWebDriver;

import mz.config.Configuration;

public class MZMobileDriver extends MZPlatformDriver {
	
	protected RemoteWebDriver driver = null;
	
	public MZMobileDriver(){}

	@Override
	public RemoteWebDriver getDriver() {
		if(this.driver == null)
		{
			this.switchDriver();
		}
		return this.driver;
	}

	@Override
	protected void switchDriver() {
		switch(Configuration.MOBILE_DRIVER)
		{
		case ANDROID:
			MZAndroidDriver android = new MZAndroidDriver();
			this.driver = android.getDriver();
			break;
		case IOS:
			break;
		}
	}

}
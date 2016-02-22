package mz.page.android;

import org.openqa.selenium.remote.RemoteWebDriver;
import mz.driver.MZMobileDriver;

public class AndroidApplication {
	
	private static AndroidApplication instance = new AndroidApplication();
	
	protected RemoteWebDriver driver = null;
	
	private AndroidApplication(){}
	
	public static AndroidApplication getInstance()
	{
		return instance;
	}
	
	public RemoteWebDriver getDriver()
	{
		if(driver == null)initializeDriver();
		return driver;
	}
	
	private void initializeDriver()
	{
		MZMobileDriver mobile = new MZMobileDriver();
		this.driver = mobile.getDriver();
	}
	
}

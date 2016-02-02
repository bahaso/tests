package mz.driver;

import java.net.MalformedURLException;
import org.openqa.selenium.remote.RemoteWebDriver;

abstract class MZPlatformDriver{
	
	public abstract RemoteWebDriver getDriver() throws MalformedURLException;
	protected abstract void switchDriver();
}

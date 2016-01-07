package mz.driver;

import java.net.MalformedURLException;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

abstract class MZPlatformDriver {
	protected RemoteWebDriver driver;
	protected DesiredCapabilities capabilities;
	
	public MZPlatformDriver(){}
	protected abstract void setDriver() throws MalformedURLException;
	public abstract RemoteWebDriver getDriver() throws MalformedURLException;
}

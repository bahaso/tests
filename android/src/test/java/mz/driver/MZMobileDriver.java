package mz.driver;

import java.io.File;
import java.net.MalformedURLException;

import org.openqa.selenium.remote.RemoteWebDriver;

abstract class MZMobileDriver extends MZPlatformDriver {
	
	protected File app;
	
	public MZMobileDriver(){}

	@Override
	protected abstract void setDriver() throws MalformedURLException;

	@Override
	public abstract RemoteWebDriver getDriver() throws MalformedURLException;
	
	protected abstract void setApplicationPath();

}

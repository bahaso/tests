package mz.driver;

import org.openqa.selenium.remote.RemoteWebDriver;

abstract class MZWebDriver extends MZPlatformDriver {

	public MZWebDriver(){}
	
	@Override
	protected abstract void setDriver();

	@Override
	public abstract RemoteWebDriver getDriver();

}

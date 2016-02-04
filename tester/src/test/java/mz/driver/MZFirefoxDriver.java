package mz.driver;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class MZFirefoxDriver extends MZWebDriver {

	public MZFirefoxDriver(){}
	
	@Override
	public RemoteWebDriver getDriver() {
		FirefoxDriver driver = new FirefoxDriver();
		return driver;
	}

}

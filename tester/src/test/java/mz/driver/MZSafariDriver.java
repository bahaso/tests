package mz.driver;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;

public class MZSafariDriver extends MZWebDriver {

	public MZSafariDriver(){}

	@Override
	public RemoteWebDriver getDriver() {
		System.setProperty("webdriver.safari.noinstall", "true");
		SafariDriver driver = new SafariDriver();
		return driver;
	}

}

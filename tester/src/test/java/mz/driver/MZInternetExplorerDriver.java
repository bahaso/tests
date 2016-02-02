package mz.driver;

import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class MZInternetExplorerDriver extends MZWebDriver {

	public MZInternetExplorerDriver(){}

	@Override
	public RemoteWebDriver getDriver() {
		System.setProperty("webdriver.ie.driver","src/IEDriverServer.exe" );
		InternetExplorerDriver driver = new InternetExplorerDriver();
		return driver;
	}

}

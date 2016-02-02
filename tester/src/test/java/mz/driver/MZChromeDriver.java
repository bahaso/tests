package mz.driver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class MZChromeDriver extends MZWebDriver {

	public MZChromeDriver(){}
	
	public RemoteWebDriver getDriver() {
		System.setProperty("webdriver.chrome.driver", "src/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		
	    return driver;
	}

}

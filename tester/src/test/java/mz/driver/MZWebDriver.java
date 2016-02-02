package mz.driver;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.remote.RemoteWebDriver;

import mz.config.Configuration;

public class MZWebDriver extends MZPlatformDriver{
	protected RemoteWebDriver driver = null;
	
	public MZWebDriver(){}

	@Override
	public RemoteWebDriver getDriver(){
		if(this.driver == null)
		{
			this.switchDriver();
			driver.manage().window().maximize();
		    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		    driver.get(Configuration.WEB_BASE_URL);
		}
		return this.driver;
	}
	
	@Override
	protected void switchDriver()
	{
		switch(Configuration.WEB_DRIVER)
		{
		case CHROME:
			this.driver = new MZChromeDriver().getDriver();
			break;
		case FIREFOX:
			this.driver = new MZFirefoxDriver().getDriver();
			break;
		case IE:
			this.driver = new MZInternetExplorerDriver().getDriver();
			break;
		case SAFARI:
			this.driver = new MZSafariDriver().getDriver();
			break;
		}
	}	

}

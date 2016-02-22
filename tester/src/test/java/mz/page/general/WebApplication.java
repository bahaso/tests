package mz.page.general;

import org.openqa.selenium.remote.RemoteWebDriver;

import mz.driver.MZWebDriver;

public class WebApplication {
	
	private static WebApplication instance = new WebApplication();
	
	private RemoteWebDriver driver = null;
	
	private WebApplication(){}
	
	public static WebApplication getInstance()
	{
		return instance;
	}
	
	public RemoteWebDriver getDriver()
	{
		if(this.driver == null)this.initializeDriver();
		return this.driver;
	}
	
	private void initializeDriver()
	{
		if(this.driver == null)
		{
			MZWebDriver web = new MZWebDriver();
			this.driver = web.getDriver();
		}
	}
	
	public void quitDriver()
	{
		if(this.driver != null) this.driver.quit();
	}
	
}

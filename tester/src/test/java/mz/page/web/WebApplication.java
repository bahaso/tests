package mz.page.web;

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
		if(this.driver == null)initializeDriver();
		return this.driver;
	}
	
	public void initializeDriver()
	{
		MZWebDriver web = new MZWebDriver();
		this.driver = web.getDriver();
	}
}

package mz.bahaso.testing.web;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import mz.general.Registry;
import mz.page.general.WebApplication;
import mz.report.ExtentReporter;

public class Suite {
	
	WebApplication webApplication = WebApplication.getInstance();
	
	Registry reg = Registry.getInstance();

	
	@BeforeSuite(groups={"loginErrorTest"})
	public void configureTestEnvironment()
	{
		//Membuat object yang akan diakses melalui registry
		//Format: registry(nama key, object);
		reg.registry("report", new ExtentReporter());
	}
	
	@AfterSuite(groups={"loginErrorTest"})
	public void  destroyTestEnvironment()
	{
		webApplication.quitDriver();
	}
	
}
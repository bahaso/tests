package mz.page.web;

import org.openqa.selenium.remote.RemoteWebDriver;

import mz.page.web.feature.Footer;
import mz.page.web.feature.Header;

public class CommonPage extends WebApplication{
	protected Header header;
	protected Footer footer;
	public CommonPage(RemoteWebDriver driver)
	{
		this.driver = driver;
		header = new Header();
		footer = new Footer();
	}
}

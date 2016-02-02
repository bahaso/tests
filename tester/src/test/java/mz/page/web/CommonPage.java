package mz.page.web;

import mz.page.web.feature.Footer;
import mz.page.web.feature.Header;

public class CommonPage{
	protected WebApplication webApplication = WebApplication.getInstance(); 
	protected Header header = new Header();
	protected Footer footer = new Footer();
	public CommonPage()
	{
	}
}

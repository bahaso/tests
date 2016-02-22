package mz.page.web;

import mz.page.general.AbstractWeb;
import mz.page.web.feature.Footer;
import mz.page.web.feature.Header;

public class CommonPage extends AbstractWeb{
	
	protected Header header = new Header();
	
	protected Footer footer = new Footer();
	
	public CommonPage()
	{
	}
	
	public Header getHeader()
	{
		return this.header;
	}
	
	public Footer getFooter()
	{
		return this.footer;
	}
}

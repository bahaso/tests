package mz.page.web.feature;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import mz.page.general.AbstractWeb;

public class UnsupportedMobileAnnouncement extends AbstractWeb {
	
	private String btnClose = "//div[@class=\"modal-header\"]/button";
	
	private String btnOK = "//div[@id=\"modal-user-agent-alert\"]/div/div/div[@class=\"modal-footer\"]/button";
	
	public UnsupportedMobileAnnouncement(){}
	
	public WebElement ButtonOK()
	{
		return FindElement(By.xpath(btnOK));
	}
	
	public Boolean IsPopedUp()
	{
		return FindElement(By.id("modal-user-agent-alert"))==null?false:true;
	}
	
	public void ClickButtonClose()
	{
		FindElement(By.xpath(btnClose)).click();
	}
	
	public void ClickButtonOK()
	{
		this.ButtonOK().click();
	}
	
}

package mz.page.web;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import mz.page.web.feature.Login;
import mz.page.web.feature.Register;

public class LandingPage extends CommonPage{
	
	private Login login = new Login();
	
	private Register register = new Register();
	
	public LandingPage(){}
	
	public void ClickImageLinkBahaso(){}
	
	public WebElement ButtonLogin()
	{
		return FindElement(By.xpath("html/body/nav/div/button"));
	}
	
	public WebElement ButtonLoginOverPopUp()
	{
		return FindElement(By.xpath("html/body/button[@id=\"loginbtn-on-mask\"]"));	
	}
	
	public void ClickButtonLoginOverPopUp()
	{
		WebElement element = this.ButtonLoginOverPopUp();
		if(element != null)
			this.ButtonLoginOverPopUp().click();
	}
	
	public void ClickButtonLogin()
	{
		if(this.ButtonLogin() != null)
			this.ButtonLogin().click();
	}
	
	public Login getLogin(){return this.login;}
	
	public Register getRegister(){return this.register;}
	
}
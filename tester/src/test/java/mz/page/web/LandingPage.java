package mz.page.web;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

import mz.page.web.feature.Login;
import mz.page.web.feature.Register;

public class LandingPage extends CommonPage{
	private Login login = new Login();
	private Register register = new Register();
	
	public LandingPage(){}
	
	public void ClickImageLinkBahaso(){}
	public void ClickButtonLogin(){
		webApplication.getDriver().findElement(By.xpath("html/body/nav/div/button")).click();
	}
	public Login getLogin(){return this.login;}
	public Register getRegister(){return this.register;}
}

package mz.page.web;

import org.openqa.selenium.remote.RemoteWebDriver;

import mz.page.web.feature.Login;
import mz.page.web.feature.Register;

public class LandingPage extends CommonPage{
	private Login login;
	private Register register;
	
	public LandingPage(RemoteWebDriver driver){
		super(driver);
		login = new Login();
		register = new Register();
	}
	public void ClickImageLinkBahaso(){}
	public void ClickButtonLogin(){}
}

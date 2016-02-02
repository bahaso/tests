package mz.bahaso.testing.web;

import org.testng.annotations.Test;

import mz.page.web.LandingPage;

public class LoginTest {
	
	//@Test
	public void loginWithBothEmptyEmailAndEmptyPasswordTextField()
	{
		
	}
	
	//@Test
	public void loginWithEmptyEmailTextfield()
	{
		
	}
	
	//@Test
	public void loginWithEmptyPasswordTextField()
	{
		
	}
	
	//@Test
	public void loginWithExistingEmailWithWrongPassword()
	{
		
	}
	
	//@Test
	public void loginWithExistingPasswordWithWrongEmail()
	{
		
	}
	
	@Test
	public void loginWithExistingEmailWithTruePassword()
	{
		LandingPage landingPage = new LandingPage();
		landingPage.ClickButtonLogin();
		landingPage.getLogin().SetTextUsername("enzpart");
		landingPage.getLogin().SetTextPassword("larabel123");
		landingPage.getLogin().ClickButtonLogin();
	}
	
}
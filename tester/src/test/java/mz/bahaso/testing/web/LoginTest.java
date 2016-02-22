package mz.bahaso.testing.web;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import mz.config.Configuration;
import mz.general.Registry;
import mz.page.general.WebApplication;

import mz.page.web.HomePage;
import mz.page.web.LandingPage;
import mz.report.ExtentReporter;
import mz.report.Screenshot;

@Test(testName="Login Test")
public class LoginTest {
	Registry reg = Registry.getInstance();
	
	final LandingPage landingPage = new LandingPage();
	
	final HomePage homePage = new HomePage();
	
	@AfterMethod(groups={"loginErrorTest"})
	public void takeScreenshot(ITestResult tr)
	{
		Screenshot.saveFile(tr, ((ExtentReporter)reg.registry("report")).getReportFolderFullPath());
		landingPage.ClickButtonLoginOverPopUp();
	}
	
	@Test
	(priority=1,
	description="Testing login dimana email/username dan password dibiarkan kosong.",
	groups={"loginErrorTest"})
	public void loginWithBothEmptyEmailAndEmptyPasswordTextField()
	{
		landingPage.ClickButtonLogin();
		landingPage.getLogin().SetTextUsername("");
		landingPage.getLogin().SetTextPassword("");
		landingPage.getLogin().ClickButtonLogin();
		Assert.assertEquals(landingPage.getLogin().GetLabelErrorMessage(), "Username harus diisi");
	}
	
	@Test
	(priority=2,
	description="Testing login dimana email/username dibiarkan kosong dan password diisi sembarang text.",
	groups={"loginErrorTest"})
	public void loginWithEmptyEmailTextfield()
	{
		landingPage.ClickButtonLogin();
		landingPage.getLogin().SetTextUsername("");
		landingPage.getLogin().SetTextPassword("larabel123");
		landingPage.getLogin().ClickButtonLogin();
		Assert.assertEquals(landingPage.getLogin().GetLabelErrorMessage(), "Username harus diisi");
	}
	
	@Test
	(priority=3,
	description="Testing login dimana password dibiarkan kosong dan email/username diisi sembarang text.",
	groups={"loginErrorTest"})
	public void loginWithEmptyPasswordTextField()
	{
		landingPage.ClickButtonLogin();
		landingPage.getLogin().SetTextUsername("enzpart");
		landingPage.getLogin().SetTextPassword("");
		landingPage.getLogin().ClickButtonLogin();
		Assert.assertEquals(landingPage.getLogin().GetLabelErrorMessage(), "Kata sandi harus diisi");
	}
	
	@Test
	(priority=4,
	description="Testing login dimana email/username diisi dengan email/username yang valid, tetapi dengan password yang salah.",
	groups={"loginErrorTest"})
	public void loginWithExistingEmailWithWrongPassword()
	{
		landingPage.ClickButtonLogin();
		landingPage.getLogin().SetTextUsername("enzpart");
		landingPage.getLogin().SetTextPassword("123");
		landingPage.getLogin().ClickButtonLogin();
		Assert.assertEquals(landingPage.getLogin().GetLabelErrorMessage(), "Gagal masuk, kata sandi anda salah");
	}
	
	@Test
	(priority=5,
	description="Testing login dimana email/username diisi dengan email/username yang tidak valid, tetapi dengan password yang valid.",
	groups={"loginErrorTest"})
	public void loginWithExistingPasswordWithWrongEmail()
	{
		landingPage.ClickButtonLogin();
		landingPage.getLogin().SetTextUsername("enz");
		landingPage.getLogin().SetTextPassword("larabel123");
		landingPage.getLogin().ClickButtonLogin();
		Assert.assertEquals(landingPage.getLogin().GetLabelErrorMessage(), "Username tidak ditemukan.");
	}
	
	@Test(priority=6, description="Testing login dimana email/username dan password diisi dengan data yang valid.")
	public void loginWithExistingEmailWithTruePassword()
	{
		landingPage.ClickButtonLogin();
		landingPage.getLogin().SetTextUsername("enzpart");
		landingPage.getLogin().SetTextPassword("larabel123");
		landingPage.getLogin().ClickButtonLogin();
		homePage.getUnsoppertedMobileAnnouncement().ClickButtonOK();
		Assert.assertEquals(WebApplication.getInstance().getDriver().getCurrentUrl(), Configuration.WEB_BASE_URL+"/home");
	}
	
}
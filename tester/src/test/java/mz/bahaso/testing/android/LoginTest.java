package mz.bahaso.testing.android;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import mz.page.android.LandingPage;
import mz.page.android.LessonPage;
import mz.page.android.LoginPage;
import mz.page.android.AndroidApplication;

public class LoginTest{
	
	@BeforeSuite
  	public void RunAppiumServer() throws IOException, InterruptedException
	{
		String path = "src\\startappium.bat";
		Runtime.getRuntime().exec("cmd /c start "+path);
		Thread.sleep(20000L);
		AndroidApplication mobileApplication = AndroidApplication.getInstance();
		mobileApplication.initializeDriver();
	}

	@AfterSuite
	public void KillAppiumServer() throws IOException {
		Runtime.getRuntime().exec("taskkill /F /IM node.exe");	  
	}
	
	@Test
	public void doLogin() throws InterruptedException 
	{
		LandingPage landingPage = new LandingPage();
		landingPage.ClickButtonLogin();
		LoginPage loginPage = new LoginPage();
		loginPage.SetTextEmailOrUsername("darkeus");
		loginPage.SetTextPassword("asdasd");
		loginPage.ClickButtonMasuk();
		Thread.sleep(50000L);
	}
	
	@Test
	public void moveToLeft()
	{
		LessonPage lessonPage = new LessonPage();
		do{
			if(lessonPage.GetTextCurrentLevel().equals("A1"))
				Assert.assertFalse(lessonPage.ClickLeftArrow());
			else
				Assert.assertTrue(lessonPage.ClickLeftArrow());
		}while(!lessonPage.GetTextCurrentLevel().equals("A1"));
	}
	
	@Test
	public void moveToRight()
	{
		LessonPage lessonPage = new LessonPage();
		do{
			if(lessonPage.GetTextCurrentLevel().equals("B2"))
				Assert.assertFalse(lessonPage.ClickRightArrow());
			else
				Assert.assertTrue(lessonPage.ClickRightArrow());
		}while(!lessonPage.GetTextCurrentLevel().equals("B2"));
	}
	
}

package bahaso.testing.android;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import bahaso.testing.androidElement.SplashScreen;
import bahaso.testing.general.mobileGeneral;

public class SplashScreen_test extends mobileGeneral{
	SplashScreen splashScreen;
	
	@BeforeMethod
	public void beforeMethod(){
		startEngine();
		splashScreen = new SplashScreen(driver);
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void goToFBLoginPage(){
		action.press(splashScreen.getFBLoginButton(), 0, 0).release().perform();
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void goToSignUpPage(){
		action.press(splashScreen.getSignUpButton(), 0, 0).release().perform();
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void goToGPlusLoginPage(){
		action.press(splashScreen.getGooglePlusLoginButton(), 0, 0).release().perform();
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void goToLoginEmailPage(){
		action.press(splashScreen.getLoginEmailButton(), 0, 0).release().perform();
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@AfterMethod
	public void afterMethod(){
		driver.quit();
	}
}
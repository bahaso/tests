package bahaso.testing.android;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import bahaso.testing.androidElement.Login;
import bahaso.testing.androidElement.Register;
import bahaso.testing.androidElement.SplashScreen;
import bahaso.testing.general.mobileGeneral;

public class Login_test extends mobileGeneral{
	SplashScreen splashScreen;
	Login login;
	
	@BeforeMethod
	public void beforeMethod(){
		try {
		startEngine();
		splashScreen = new SplashScreen(driver);
		login = new Login(driver);
		Thread.sleep(10000);
		splashScreen.getLoginEmailButton().click();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//email contain just spaces
	@Test
	public void email_fail_1(){
		try {
		login.getInputEmail().sendKeys(" ");
		driver.hideKeyboard();
		Thread.sleep(4000);
		action.press(login.getBtnLogin(), 0, 0).release().perform();
		Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//email format not valid
	@Test
	public void email_fail_2(){
		try {
		login.getInputEmail().sendKeys("a@a");
		driver.hideKeyboard();
		Thread.sleep(4000);
		action.press(login.getBtnLogin(), 0, 0).release().perform();
		Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//password empty
	@Test
	public void password_fail_1(){
		try {
		login.getInputPassword().sendKeys(" ");
		driver.hideKeyboard();
		Thread.sleep(4000);
		action.press(login.getBtnLogin(), 0, 0).release().perform();
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

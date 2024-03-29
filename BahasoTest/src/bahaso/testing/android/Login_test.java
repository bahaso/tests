package bahaso.testing.android;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import bahaso.testing.androidElement.Login;
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
		Assert.assertEquals(login.getErrorMessage().get(0).getText(), "Username atau email harus diisi", "Pesan error tidak sama");
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
		Assert.assertEquals(login.getErrorMessage().get(1).getText(), "Kata sandi harus diisi", "Pesan error tidak sama");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//password wrong
	@Test
	public void login_fail_1(){
		try {
		login.getInputEmail().sendKeys("ademahendra@bahaso.com");
		login.getInputPassword().sendKeys("aaaa");
		driver.hideKeyboard();
		Thread.sleep(4000);
		action.press(login.getBtnLogin(), 0, 0).release().perform();
		Thread.sleep(4000);
		Assert.assertEquals(login.getPopUpErrorMessage().getText(), "Password anda salah", "Pesan error tidak sama");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//login with email
	@Test
	public void login_succeed_1(){
		try {
		login.getInputEmail().sendKeys("ademahendra@bahaso.com");
		login.getInputPassword().sendKeys("mahendra89");
		driver.hideKeyboard();
		Thread.sleep(4000);
		action.press(login.getBtnLogin(), 0, 0).release().perform();
		Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//login with username
	@Test
	public void login_succeed_2(){
		try {
		login.getInputEmail().sendKeys("reddev");
		login.getInputPassword().sendKeys("mahendra89");
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

package bahaso.testing.android;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import bahaso.testing.androidElement.Register;
import bahaso.testing.androidElement.SplashScreen;
import bahaso.testing.general.mobileGeneral;

public class Register_test extends mobileGeneral{
	SplashScreen splashScreen;
	Register register;
	
	@BeforeMethod
	public void beforeMethod(){
		try {
		startEngine();
		splashScreen = new SplashScreen(driver);
		register = new Register(driver);
		Thread.sleep(10000);
		splashScreen.getSignUpButton().click();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//firstname less then 3 character
	@Test
	public void firstname_fail_1(){
		try {
		register.getInputFirstname().sendKeys("a");
		driver.hideKeyboard();
		Thread.sleep(4000);
		action.press(register.getBtnRegister(), 0, 0).release().perform();
		Thread.sleep(4000);
		Assert.assertEquals(register.getErrorMessage().get(0).getText(), "Nama depan minimum 3 karakter", "Pesan error tidak sama");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//firstname contain illegal character
	@Test
	public void firstname_fail_2(){
		try {
		register.getInputFirstname().sendKeys("a......");
		driver.hideKeyboard();
		Thread.sleep(4000);
		action.press(register.getBtnRegister(), 0, 0).release().perform();
		Thread.sleep(4000);
		Assert.assertEquals(register.getErrorMessage().get(0).getText(), "Isian nama depan hanya boleh diisi huruf, spasi dan apostrof (')", "Pesan error tidak sama");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//lastname less then 2 character
	@Test
	public void lastname_fail_1(){
		try {
		register.getInputLastname().sendKeys("a");
		driver.hideKeyboard();
		Thread.sleep(4000);
		action.press(register.getBtnRegister(), 0, 0).release().perform();
		Thread.sleep(4000);
		Assert.assertEquals(register.getErrorMessage().get(1).getText(), "Nama belakang minimum 2 karakter", "Pesan error tidak sama");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//lastname less then 2 character
	@Test
	public void lastname_fail_2(){
		try {
		register.getInputLastname().sendKeys("a123");
		driver.hideKeyboard();
		Thread.sleep(4000);
		action.press(register.getBtnRegister(), 0, 0).release().perform();
		Thread.sleep(4000);
		Assert.assertEquals(register.getErrorMessage().get(1).getText(), "Nama belakang hanya boleh diisi huruf, spasi, titik, apostrof (') dan tanda hubung (-)", "Pesan error tidak sama");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	 
	//email format not valid
	@Test
	public void email_fail_1(){
		try {
		register.getInputEmail().sendKeys("aaaa");
		driver.hideKeyboard();
		Thread.sleep(4000);
		action.press(register.getBtnRegister(), 0, 0).release().perform();
		Thread.sleep(4000);
		Assert.assertEquals(register.getErrorMessage().get(2).getText(), "Email harus valid, contoh john@example.com", "Pesan error tidak sama");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//email has registered
	@Test
	public void email_fail_2(){
		try {
		register.getInputFirstname().sendKeys("aaaa");
		register.getInputLastname().sendKeys("bbb");
		register.getInputEmail().sendKeys("ademahendra@bahaso.com");
		register.getInputPassword().sendKeys("bahaso");
		driver.hideKeyboard();
		Thread.sleep(4000);
		action.press(register.getBtnRegister(), 0, 0).release().perform();
		Thread.sleep(4000);
		Assert.assertEquals(register.getPopUpErrorMessage().getText(), "Akun anda telah terdaftar, mohon periksa email yang anda masukkan.", "Pesan error tidak sama");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//password less then 6 character
	@Test
	public void password_fail_1(){
		try {
		register.getInputPassword().sendKeys("aaaa");
		driver.hideKeyboard();
		Thread.sleep(4000);
		action.press(register.getBtnRegister(), 0, 0).release().perform();
		Thread.sleep(4000);
		Assert.assertEquals(register.getErrorMessage().get(3).getText(), "Kata sandi minimum 6 karakter", "Pesan error tidak sama");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
//	//register succeed
//	@Test
//	public void register_succeed(){
//		try {
//		register.getInputFirstname().sendKeys("aaaa");
//		register.getInputLastname().sendKeys("bbb");
//		register.getInputEmail().sendKeys("bahasotest@mailinator.com");
//		register.getInputPassword().sendKeys("bahaso");
//		driver.hideKeyboard();
//		Thread.sleep(4000);
//		action.press(register.getBtnRegister(), 0, 0).release().perform();
//		Thread.sleep(4000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
	
	@AfterMethod
	public void afterMethod(){	
		driver.quit();
	}
}

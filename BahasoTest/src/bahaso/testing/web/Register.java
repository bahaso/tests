package bahaso.testing.web;

import org.testng.annotations.Test;

import bahaso.testing.webElement.LandingPage;
import bahaso.testing.webElement.LoginPage;
import bahaso.testing.general.General;

import org.testng.annotations.BeforeMethod;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class Register extends General{
	String firstname = "bahaso";
	String lastname = "bahaso";
	String email = "a@a.com";
	String password = "bahaso";
	
  	@BeforeMethod
  	public void before() {
	  driver = getDriver();
  	}
  
  	@Test
  	public void RegisterCorrect() throws InterruptedException {
  		HashMap<String, String> RegisterData = new HashMap<String, String>();
  		RegisterData.put("firstname",firstname);
  		RegisterData.put("lastname",lastname);
  		RegisterData.put("email",email);
  		RegisterData.put("password",password);
  		LandingPage lp = new LandingPage();
  		LoginPage loginPage = new LoginPage();
  		lp.doRegister(driver, RegisterData);
 	    Assert.assertEquals(loginPage.getUsernameButton(driver).getText().trim(), "bahaso", "Error Massage not same as Expected");
  	}
  	
  	/*
  	 * all form is blank
  	 */
  	@Test
  	public void RegisterFail1() throws InterruptedException {
  		HashMap<String, String> RegisterData = new HashMap<String, String>();
  		RegisterData.put("firstname","");
  		RegisterData.put("lastname","");
  		RegisterData.put("email","");
  		RegisterData.put("password","");
  		LandingPage lp = new LandingPage();
  		lp.doRegister(driver, RegisterData);
  		Assert.assertEquals(lp.getInputRegisterFirstnameErrorMassage(driver), "Nama depan harus diisi", "Error Massage not same as Expected");
  		Assert.assertEquals(lp.getInputRegisterLastnameErrorMassage(driver), "Nama belakang harus diisi", "Error Massage not same as Expected");
  		Assert.assertEquals(lp.getInputRegisterEmailErrorMassage(driver), "Email harus diisi", "Error Massage not same as Expected");
  		Assert.assertEquals(lp.getInputRegisterPasswordErrorMassage(driver), "Kata sandi harus diisi", "Error Massage not same as Expected");
  	}
  	
  	/*
  	 * Firstname less than 3 char
  	 */
  	@Test
  	public void RegisterFail2() throws InterruptedException {
  		HashMap<String, String> RegisterData = new HashMap<String, String>();
  		RegisterData.put("firstname","a");
  		RegisterData.put("lastname","");
  		RegisterData.put("email","");
  		RegisterData.put("password","");
  		LandingPage lp = new LandingPage();
  		lp.doRegister(driver, RegisterData);
  		Assert.assertEquals(lp.getInputRegisterFirstnameErrorMassage(driver), "Nama depan minimal terdiri dari 3 karakter", "Error Massage not same as Expected");
  	}
  	
  	/*
  	 * Firstname contains invalid char
  	 */
  	@Test
  	public void RegisterFail3() throws InterruptedException {
  		HashMap<String, String> RegisterData = new HashMap<String, String>();
  		RegisterData.put("firstname","aaa---!!!");
  		RegisterData.put("lastname","");
  		RegisterData.put("email","");
  		RegisterData.put("password","");
  		LandingPage lp = new LandingPage();
  		lp.doRegister(driver, RegisterData);
  		Assert.assertEquals(lp.getInputRegisterFirstnameErrorMassage(driver), "Nama depan hanya boleh diisi huruf, spasi dan apostrof (')", "Error Massage not same as Expected");
  	}
  	
  	/*
  	 * Lastname less than 2 char
  	 */
  	@Test
  	public void RegisterFail4() throws InterruptedException {
  		HashMap<String, String> RegisterData = new HashMap<String, String>();
  		RegisterData.put("firstname","");
  		RegisterData.put("lastname","a");
  		RegisterData.put("email","");
  		RegisterData.put("password","");
  		LandingPage lp = new LandingPage();
  		lp.doRegister(driver, RegisterData);
  		Assert.assertEquals(lp.getInputRegisterLastnameErrorMassage(driver), "Nama belakang minimal terdiri dari 2 karakter", "Error Massage not same as Expected");
  	}
  	
  	/*
  	 * Lastname contains invalid char
  	 */
  	@Test
  	public void RegisterFail5() throws InterruptedException {
  		HashMap<String, String> RegisterData = new HashMap<String, String>();
  		RegisterData.put("firstname","");
  		RegisterData.put("lastname","a!!!!!!!!");
  		RegisterData.put("email","");
  		RegisterData.put("password","");
  		LandingPage lp = new LandingPage();
  		lp.doRegister(driver, RegisterData);
  		Assert.assertEquals(lp.getInputRegisterLastnameErrorMassage(driver), "Nama belakang hanya boleh diisi oleh huruf, spasi, titik, apostrof (') dan hifenasi (-)", "Error Massage not same as Expected");
  	}
  	
  	/*
  	 * Email is blank
  	 */
  	@Test
  	public void RegisterFail6() throws InterruptedException {
  		HashMap<String, String> RegisterData = new HashMap<String, String>();
  		RegisterData.put("firstname","");
  		RegisterData.put("lastname","");
  		RegisterData.put("email","");
  		RegisterData.put("password","");
  		LandingPage lp = new LandingPage();
  		lp.doRegister(driver, RegisterData);
  		Assert.assertEquals(lp.getInputRegisterEmailErrorMassage(driver), "Email harus diisi", "Error Massage not same as Expected");
  	}
  	
  	/*
  	 * Email without "@" and "."
  	 */
  	@Test
  	public void RegisterFail7() throws InterruptedException {
  		HashMap<String, String> RegisterData = new HashMap<String, String>();
  		RegisterData.put("firstname","");
  		RegisterData.put("lastname","");
  		RegisterData.put("email","a");
  		RegisterData.put("password","");
  		LandingPage lp = new LandingPage();
  		lp.doRegister(driver, RegisterData);
  		Assert.assertEquals(lp.getInputRegisterEmailErrorMassage(driver), "Format email salah", "Error Massage not same as Expected");
  	}
  	
  	/*
  	 * Email without "." after "@"
  	 */
  	@Test
  	public void RegisterFail8() throws InterruptedException {
  		HashMap<String, String> RegisterData = new HashMap<String, String>();
  		RegisterData.put("firstname","");
  		RegisterData.put("lastname","");
  		RegisterData.put("email","a@");
  		RegisterData.put("password","");
  		LandingPage lp = new LandingPage();
  		lp.doRegister(driver, RegisterData);
  		Assert.assertEquals(lp.getInputRegisterEmailErrorMassage(driver), "Format email salah", "Error Massage not same as Expected");
  	}
  	
  	/*
  	 * Email with "@" and "." but without any character between "@" and "."
  	 */
  	@Test
  	public void RegisterFail9() throws InterruptedException {
  		HashMap<String, String> RegisterData = new HashMap<String, String>();
  		RegisterData.put("firstname","");
  		RegisterData.put("lastname","");
  		RegisterData.put("email","a@.");
  		RegisterData.put("password","");
  		LandingPage lp = new LandingPage();
  		lp.doRegister(driver, RegisterData);
  		Assert.assertEquals(lp.getInputRegisterEmailErrorMassage(driver), "Format email salah", "Error Massage not same as Expected");
  	}
  	
  	/*
  	 * Email with "@", "." and any character between "@" and "." but without any character after last "."
  	 */
  	@Test
  	public void RegisterFail10() throws InterruptedException {
  		HashMap<String, String> RegisterData = new HashMap<String, String>();
  		RegisterData.put("firstname","");
  		RegisterData.put("lastname","");
  		RegisterData.put("email","a@a.");
  		RegisterData.put("password","");
  		LandingPage lp = new LandingPage();
  		lp.doRegister(driver, RegisterData);
  		Assert.assertEquals(lp.getInputRegisterEmailErrorMassage(driver), "Format email salah", "Error Massage not same as Expected");
  	}
  	
  	/*
  	 * Password is blank
  	 */
  	@Test
  	public void RegisterFail11() throws InterruptedException {
  		HashMap<String, String> RegisterData = new HashMap<String, String>();
  		RegisterData.put("firstname","");
  		RegisterData.put("lastname","");
  		RegisterData.put("email","");
  		RegisterData.put("password","");
  		LandingPage lp = new LandingPage();
  		lp.doRegister(driver, RegisterData);
  		Assert.assertEquals(lp.getInputRegisterPasswordErrorMassage(driver), "Kata sandi harus diisi", "Error Massage not same as Expected");
  	}
  	
  	/*
  	 * Password is full of space
  	 */
  	@Test
  	public void RegisterFail12() throws InterruptedException {
  		HashMap<String, String> RegisterData = new HashMap<String, String>();
  		RegisterData.put("firstname","");
  		RegisterData.put("lastname","");
  		RegisterData.put("email","");
  		RegisterData.put("password","      ");
  		LandingPage lp = new LandingPage();
  		lp.doRegister(driver, RegisterData);
  		Assert.assertEquals(lp.getInputRegisterPasswordErrorMassage(driver), "Kata sandi harus diisi", "Error Massage not same as Expected");
  	}
  	
  	/*
  	 * Password less than 6 char
  	 */
  	@Test
  	public void RegisterFail13() throws InterruptedException {
  		HashMap<String, String> RegisterData = new HashMap<String, String>();
  		RegisterData.put("firstname","");
  		RegisterData.put("lastname","");
  		RegisterData.put("email","");
  		RegisterData.put("password","aaa");
  		LandingPage lp = new LandingPage();
  		lp.doRegister(driver, RegisterData);
  		Assert.assertEquals(lp.getInputRegisterPasswordErrorMassage(driver), "Kata sandi minimal terdiri dari 6 karakter", "Error Massage not same as Expected");
  	}

  	@AfterMethod
  	public void after() {
  		driver.close();
  	}

}

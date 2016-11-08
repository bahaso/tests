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
  	 * name less than 3 char
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
  	 * name contains invalid char
  	 */
  	@Test
  	public void RegisterFail3() throws InterruptedException {
  		HashMap<String, String> RegisterData = new HashMap<String, String>();
  		RegisterData.put("firstname","aaa---");
  		RegisterData.put("lastname","");
  		RegisterData.put("email","");
  		RegisterData.put("password","");
  		LandingPage lp = new LandingPage();
  		lp.doRegister(driver, RegisterData);
  		Assert.assertEquals(lp.getInputRegisterFirstnameErrorMassage(driver), "Nama depan hanya boleh diisi huruf, spasi dan apostrof (')", "Error Massage not same as Expected");
  	}

  	@AfterMethod
  	public void after() {
  		driver.close();
  	}

}

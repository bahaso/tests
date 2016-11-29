package bahaso.testing.web;

import org.testng.annotations.Test;

import bahaso.testing.webElement.LandingPage;
import bahaso.testing.webElement.LoginPage;
import bahaso.testing.general.General;

import org.testng.annotations.BeforeMethod;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class RegisterViaLandingPage extends General{
	LandingPage lp = null;
	LoginPage loginPage = null;
	
	String firstname = "bahaso";
	String lastname = "bahaso";
	String email = "a@a.com";
	String password = "bahaso";
	
  	@BeforeMethod
  	public void before() {
	  driver = getDriver();
	  lp = new LandingPage(driver);
	  loginPage = new LoginPage(driver);
  	}
  
  	@Test
  	public void RegisterCorrect()  {
  		HashMap<String, String> RegisterData = new HashMap<String, String>();
  		RegisterData.put("firstname",firstname);
  		RegisterData.put("lastname",lastname);
  		RegisterData.put("email",email);
  		RegisterData.put("password",password);
  		lp.doRegister(RegisterData);
 	    Assert.assertEquals(loginPage.getUsernameButton().getText().trim(), "bahaso", "Error Massage not same as Expected");
  	}
  	
  	/*
  	 * all form is blank
  	 */
  	@Test
  	public void RegisterFailAllBlank(){
  		HashMap<String, String> RegisterData = new HashMap<String, String>();
  		RegisterData.put("firstname","");
  		RegisterData.put("lastname","");
  		RegisterData.put("email","");
  		RegisterData.put("password","");
  		lp.doRegister(RegisterData);
  		Assert.assertEquals(lp.getInputRegisterFirstnameErrorMassage(), "Nama depan harus diisi", "Error Massage not same as Expected");
  		Assert.assertEquals(lp.getInputRegisterLastnameErrorMassage(), "Nama belakang harus diisi", "Error Massage not same as Expected");
  		Assert.assertEquals(lp.getInputRegisterEmailErrorMassage(), "Email harus diisi", "Error Massage not same as Expected");
  		Assert.assertEquals(lp.getInputRegisterPasswordErrorMassage(), "Kata sandi harus diisi", "Error Massage not same as Expected");
  	}
  	
  	/*
  	 * Firstname less than 3 char
  	 */
  	@Test
  	public void RegisterFailFirstname1(){
  		HashMap<String, String> RegisterData = new HashMap<String, String>();
  		RegisterData.put("firstname","a");
  		RegisterData.put("lastname","");
  		RegisterData.put("email","");
  		RegisterData.put("password","");
  		lp.doRegister(RegisterData);
  		Assert.assertEquals(lp.getInputRegisterFirstnameErrorMassage(), "Nama depan minimal terdiri dari 3 karakter.", "Error Massage not same as Expected");
  	}
  	
  	/*
  	 * Firstname contains invalid char
  	 */
  	@Test
  	public void RegisterFailFirstname2(){
  		HashMap<String, String> RegisterData = new HashMap<String, String>();
  		RegisterData.put("firstname","aaa---!!!");
  		RegisterData.put("lastname","");
  		RegisterData.put("email","");
  		RegisterData.put("password","");
  		lp.doRegister(RegisterData);
  		Assert.assertEquals(lp.getInputRegisterFirstnameErrorMassage(), "Nama depan hanya boleh diisi huruf, spasi dan apostrof (')", "Error Massage not same as Expected");
  	}
  	
  	/*
  	 * Lastname less than 2 char
  	 */
  	@Test
  	public void RegisterFailLastname1(){
  		HashMap<String, String> RegisterData = new HashMap<String, String>();
  		RegisterData.put("firstname","");
  		RegisterData.put("lastname","a");
  		RegisterData.put("email","");
  		RegisterData.put("password","");
  		lp.doRegister(RegisterData);
  		Assert.assertEquals(lp.getInputRegisterLastnameErrorMassage(), "Nama belakang minimal terdiri dari 2 karakter.", "Error Massage not same as Expected");
  	}
  	
  	/*
  	 * Lastname contains invalid char
  	 */
  	@Test
  	public void RegisterFailLastname2(){
  		HashMap<String, String> RegisterData = new HashMap<String, String>();
  		RegisterData.put("firstname","");
  		RegisterData.put("lastname","a!!!!!!!!");
  		RegisterData.put("email","");
  		RegisterData.put("password","");
  		lp.doRegister(RegisterData);
  		Assert.assertEquals(lp.getInputRegisterLastnameErrorMassage(), "Nama belakang hanya boleh diisi oleh huruf, spasi, titik, apostrof (') dan hifenasi (-)", "Error Massage not same as Expected");
  	}
  	
  	/*
  	 * Email is blank
  	 */
  	@Test
  	public void RegisterFailEmail1(){
  		HashMap<String, String> RegisterData = new HashMap<String, String>();
  		RegisterData.put("firstname","");
  		RegisterData.put("lastname","");
  		RegisterData.put("email","");
  		RegisterData.put("password","");
  		lp.doRegister(RegisterData);
  		Assert.assertEquals(lp.getInputRegisterEmailErrorMassage(), "Email harus diisi", "Error Massage not same as Expected");
  	}
  	
  	/*
  	 * Email without "@" and "."
  	 */
  	@Test
  	public void RegisterFailEmail2() throws InterruptedException{
  		HashMap<String, String> RegisterData = new HashMap<String, String>();
  		RegisterData.put("firstname","");
  		RegisterData.put("lastname","");
  		RegisterData.put("email","a");
  		RegisterData.put("password","");
  		lp.doRegister(RegisterData);
  		Thread.sleep(2000);
  		Assert.assertEquals(lp.getInputRegisterEmailErrorMassage(), "Email harus valid\ncontoh:john@example.com", "Error Massage not same as Expected");
  	}
  	
  	/*
  	 * Email without "." after "@"
  	 */
  	@Test
  	public void RegisterFailEmail3() throws InterruptedException{
  		HashMap<String, String> RegisterData = new HashMap<String, String>();
  		RegisterData.put("firstname","");
  		RegisterData.put("lastname","");
  		RegisterData.put("email","a@");
  		RegisterData.put("password","");
  		lp.doRegister(RegisterData);
  		Thread.sleep(3000);
  		Assert.assertEquals(lp.getInputRegisterEmailErrorMassage(), "Email harus valid\ncontoh:john@example.com", "Error Massage not same as Expected");
  	}
  	
  	/*
  	 * Email with "@" and "." but without any character between "@" and "."
  	 */
  	@Test
  	public void RegisterFailEmail4() throws InterruptedException{
  		HashMap<String, String> RegisterData = new HashMap<String, String>();
  		RegisterData.put("firstname","");
  		RegisterData.put("lastname","");
  		RegisterData.put("email","a@.");
  		RegisterData.put("password","");
  		lp.doRegister(RegisterData);
  		Thread.sleep(3000);
  		Assert.assertEquals(lp.getInputRegisterEmailErrorMassage(), "Email harus valid\ncontoh:john@example.com", "Error Massage not same as Expected");
  	}
  	
  	/*
  	 * Email with "@", "." and any character between "@" and "." but without any character after last "."
  	 */
  	@Test
  	public void RegisterFailEmail5() throws InterruptedException{
  		HashMap<String, String> RegisterData = new HashMap<String, String>();
  		RegisterData.put("firstname","");
  		RegisterData.put("lastname","");
  		RegisterData.put("email","a@a.");
  		RegisterData.put("password","");
  		lp.doRegister(RegisterData);
  		Thread.sleep(3000);
  		Assert.assertEquals(lp.getInputRegisterEmailErrorMassage(), "Email harus valid\ncontoh:john@example.com", "Error Massage not same as Expected");
  	}
  	
  	/*
  	 * Email is exist
  	 */
  	@Test
  	public void RegisterFailEmail6() throws InterruptedException{
  		HashMap<String, String> RegisterData = new HashMap<String, String>();
  		RegisterData.put("firstname",firstname);
  		RegisterData.put("lastname",lastname);
  		RegisterData.put("email",email);
  		RegisterData.put("password",password);
  		lp.doRegister(RegisterData);
  		Thread.sleep(3000);
 	    Assert.assertEquals(lp.getInputRegisterEmailErrorMassage(), "Email telah dipakai. Gunakan email lainnya.", "Error Massage not same as Expected");
  	}
  	
  	/*
  	 * Password is blank
  	 */
  	@Test
  	public void RegisterFailPassword1(){
  		HashMap<String, String> RegisterData = new HashMap<String, String>();
  		RegisterData.put("firstname","");
  		RegisterData.put("lastname","");
  		RegisterData.put("email","");
  		RegisterData.put("password","");
  		lp.doRegister(RegisterData);
  		Assert.assertEquals(lp.getInputRegisterPasswordErrorMassage(), "Kata sandi harus diisi", "Error Massage not same as Expected");
  	}
  	
  	/*
  	 * Password is full of space
  	 */
  	@Test
  	public void RegisterFailPassword2(){
  		HashMap<String, String> RegisterData = new HashMap<String, String>();
  		RegisterData.put("firstname","");
  		RegisterData.put("lastname","");
  		RegisterData.put("email","");
  		RegisterData.put("password","      ");
  		lp.doRegister(RegisterData);
  		Assert.assertEquals(lp.getInputRegisterPasswordErrorMassage(), "Kata sandi harus diisi", "Error Massage not same as Expected");
  	}
  	
  	/*
  	 * Password less than 6 char
  	 */
  	@Test
  	public void RegisterFailPassword3(){
  		HashMap<String, String> RegisterData = new HashMap<String, String>();
  		RegisterData.put("firstname","");
  		RegisterData.put("lastname","");
  		RegisterData.put("email","");
  		RegisterData.put("password","aaa");
  		lp.doRegister(RegisterData);
  		Assert.assertEquals(lp.getInputRegisterPasswordErrorMassage(), "Kata sandi minimal terdiri dari 6 karakter.", "Error Massage not same as Expected");
  	}

  	@AfterMethod
  	public void after() {
  		driver.close();
  	}

}
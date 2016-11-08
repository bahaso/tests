package bahaso.testing.web;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import bahaso.testing.general.General;
import bahaso.testing.webElement.LandingPage;
import bahaso.testing.webElement.LoginPage;;

public class Login extends General{
	
  @BeforeMethod
  public void before(){
	  driver = getDriver();
  }
	
  @Test
  public void LoginCorrect() {
	   HashMap<String, String> LoginData = new HashMap<String, String>();
	   LoginData.put("email","reddev");
	   LoginData.put("password","mahendralubis");
	   LandingPage lp = new LandingPage();
	   LoginPage loginPage = new LoginPage();
	   lp.doLogin(driver, LoginData);
	   Assert.assertEquals(loginPage.getUsernameButton(driver).getText().trim(), "hendra", "Error Massage not same as Expected");
  }
  
  /*
   * Username doesn't exist
   */
  @Test
  public void LoginFail1() {
	   HashMap<String, String> LoginData = new HashMap<String, String>();
	   LoginData.put("email","a");
	   LoginData.put("password","a");
	   LandingPage lp = new LandingPage();
	   lp.doLogin(driver, LoginData);
	   Assert.assertEquals(lp.getLoginErrorMessage(driver), "Username tidak ditemukan.", "Error Massage not same as Expected");
  }
  
  /*
   * Email doesn't exist;
   */
  @Test
  public void LoginFail2() {
	   HashMap<String, String> LoginData = new HashMap<String, String>();
	   LoginData.put("email","a@a.com");
	   LoginData.put("password","a");
	   LandingPage lp = new LandingPage();
	   lp.doLogin(driver, LoginData);
	   Assert.assertEquals(lp.getLoginErrorMessage(driver), "Username tidak ditemukan.", "Error Massage not same as Expected");
  }
  
  /*
   * Password is Wrong
   */
  @Test
  public void LoginFail3() {
	   HashMap<String, String> LoginData = new HashMap<String, String>();
	   LoginData.put("email","reddev");
	   LoginData.put("password","a");
	   LandingPage lp = new LandingPage();
	   lp.doLogin(driver, LoginData);
	   Assert.assertEquals(lp.getLoginErrorMessage(driver), "Gagal masuk, kata sandi anda salah", "Error Massage not same as Expected");
  }
  
  @AfterMethod
  public void after(){
	  driver.close();
  }
}

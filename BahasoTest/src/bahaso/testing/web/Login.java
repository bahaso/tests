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
	LandingPage lp = null;
	LoginPage loginPage = null;
	
  @BeforeMethod
  public void before(){
	  driver = getDriver();
	  lp = new LandingPage(driver);
	  loginPage = new LoginPage(driver);
  }
	
  @Test
  public void LoginCorrect() {
	   HashMap<String, String> LoginData = new HashMap<String, String>();
	   LoginData.put("email","reddev");
	   LoginData.put("password","mahendralubis");
	   lp.doLogin(LoginData);
	   Assert.assertEquals(loginPage.getUsernameButton().getText().trim(), "hendra", "Error Massage not same as Expected");
  }
  
  /*
   * Username doesn't exist
   */
  @Test
  public void LoginFail1() {
	   HashMap<String, String> LoginData = new HashMap<String, String>();
	   LoginData.put("email","a");
	   LoginData.put("password","a");
	   lp.doLogin(LoginData);
	   Assert.assertEquals(lp.getLoginErrorMessage(), "Username tidak ditemukan.", "Error Massage not same as Expected");
  }
  
  /*
   * Email doesn't exist;
   */
  @Test
  public void LoginFail2() {
	   HashMap<String, String> LoginData = new HashMap<String, String>();
	   LoginData.put("email","a@a.com");
	   LoginData.put("password","a");
	   lp.doLogin(LoginData);
	   Assert.assertEquals(lp.getLoginErrorMessage(), "Username tidak ditemukan.", "Error Massage not same as Expected");
  }
  
  /*
   * Password is Wrong
   */
  @Test
  public void LoginFail3() {
	   HashMap<String, String> LoginData = new HashMap<String, String>();
	   LoginData.put("email","reddev");
	   LoginData.put("password","a");
	   lp.doLogin(LoginData);
	   Assert.assertEquals(lp.getLoginErrorMessage(), "Gagal masuk, kata sandi anda salah", "Error Massage not same as Expected");
  }
  
  @AfterMethod
  public void after(){
	  driver.close();
  }
}
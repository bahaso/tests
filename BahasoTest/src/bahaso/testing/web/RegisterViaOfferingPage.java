package bahaso.testing.web;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import bahaso.testing.general.General;
import bahaso.testing.webElement.OfferingPage;

public class RegisterViaOfferingPage extends General{
	String name = "bahaso";
	String email = "a@a.com";
	
	@BeforeMethod
  	public void before() {
	  driver = getDriver();
	  driver.get("http://localhost/offering");
  	}
	
	@Test
  	public void RegisterCorrect1() throws InterruptedException {
  		HashMap<String, String> RegisterData = new HashMap<String, String>();
  		RegisterData.put("name",name);
  		RegisterData.put("email",email);
  		OfferingPage offeringPage = new OfferingPage();
  		offeringPage.doRegister1(driver, RegisterData);
  		Assert.assertEquals(offeringPage.getRegisterButton1(driver).getAttribute("disabled")==null, true);
  	}
	
	@Test
  	public void RegisterCorrect2() throws InterruptedException {
  		HashMap<String, String> RegisterData = new HashMap<String, String>();
  		RegisterData.put("name",name);
  		RegisterData.put("email",email);
  		OfferingPage offeringPage = new OfferingPage();
  		offeringPage.doRegister2(driver, RegisterData);
  		Assert.assertEquals(offeringPage.getRegisterButton2(driver).getAttribute("disabled")==null, true);
  	}
	
	@Test
  	public void RegisterCorrect3() throws InterruptedException {
  		HashMap<String, String> RegisterData = new HashMap<String, String>();
  		RegisterData.put("name",name);
  		RegisterData.put("email",email);
  		OfferingPage offeringPage = new OfferingPage();
  		offeringPage.doRegister3(driver, RegisterData);
  		Assert.assertEquals(offeringPage.getRegisterButton3(driver).getAttribute("disabled")==null, true);
  	}
	
	/*
	 * Name is blank in form 1
	 */
	@Test
  	public void RegisterFailName1() throws InterruptedException {
  		HashMap<String, String> RegisterData = new HashMap<String, String>();
  		RegisterData.put("name","");
  		RegisterData.put("email",email);
  		OfferingPage offeringPage = new OfferingPage();
  		offeringPage.doRegister1(driver, RegisterData);
  		Assert.assertEquals(offeringPage.getRegisterButton1(driver).getAttribute("disabled")!=null, true);
  	}
	
	/*
	 * Name is blank in form 2
	 */
	@Test
  	public void RegisterFailName2() throws InterruptedException {
  		HashMap<String, String> RegisterData = new HashMap<String, String>();
  		RegisterData.put("name","");
  		RegisterData.put("email",email);
  		OfferingPage offeringPage = new OfferingPage();
  		offeringPage.doRegister2(driver, RegisterData);
  		Assert.assertEquals(offeringPage.getRegisterButton2(driver).getAttribute("disabled")!=null, true);
  	}
	
	/*
	 * Name is blank in form 3
	 */
	@Test
  	public void RegisterFailName3() throws InterruptedException {
  		HashMap<String, String> RegisterData = new HashMap<String, String>();
  		RegisterData.put("name","");
  		RegisterData.put("email",email);
  		OfferingPage offeringPage = new OfferingPage();
  		offeringPage.doRegister3(driver, RegisterData);
  		Assert.assertEquals(offeringPage.getRegisterButton3(driver).getAttribute("disabled")!=null, true);
  	}
	
	/*
	 * Email is blank in form 1
	 */
	@Test
  	public void RegisterFailEmail1() throws InterruptedException {
  		HashMap<String, String> RegisterData = new HashMap<String, String>();
  		RegisterData.put("name",name);
  		RegisterData.put("email","");
  		OfferingPage offeringPage = new OfferingPage();
  		offeringPage.doRegister1(driver, RegisterData);
  		Assert.assertEquals(offeringPage.getRegisterButton1(driver).getAttribute("disabled")!=null, true);
  	}
	
	/*
	 * Email is blank in form 2
	 */
	@Test
  	public void RegisterFailEmail2() throws InterruptedException {
  		HashMap<String, String> RegisterData = new HashMap<String, String>();
  		RegisterData.put("name",name);
  		RegisterData.put("email","");
  		OfferingPage offeringPage = new OfferingPage();
  		offeringPage.doRegister2(driver, RegisterData);
  		Assert.assertEquals(offeringPage.getRegisterButton2(driver).getAttribute("disabled")!=null, true);
  	}
	
	/*
	 * Email is blank in form 3
	 */
	@Test
  	public void RegisterFailEmail3() throws InterruptedException {
  		HashMap<String, String> RegisterData = new HashMap<String, String>();
  		RegisterData.put("name",name);
  		RegisterData.put("email","");
  		OfferingPage offeringPage = new OfferingPage();
  		offeringPage.doRegister3(driver, RegisterData);
  		Assert.assertEquals(offeringPage.getRegisterButton3(driver).getAttribute("disabled")!=null, true);
  	}
	
	@AfterMethod
  	public void after() {
  		driver.quit();
  	}
}

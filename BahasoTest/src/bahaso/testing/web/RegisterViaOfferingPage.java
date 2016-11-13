package bahaso.testing.web;

import java.util.HashMap;

import org.testng.annotations.Test;

import bahaso.testing.webElement.OfferingPage;

public class RegisterViaOfferingPage {
	String name = "bahaso";
	String email = "a@a.com";
	
	@Test
  	public void RegisterCorrect() throws InterruptedException {
  		HashMap<String, String> RegisterData = new HashMap<String, String>();
  		RegisterData.put("firstname",name);
  		RegisterData.put("email",email);
  		OfferingPage offeringPage = new OfferingPage();
  	}
	
	/*
	 * Name is blank
	 */
	@Test
  	public void RegisterFailName1() throws InterruptedException {
  		HashMap<String, String> RegisterData = new HashMap<String, String>();
  		RegisterData.put("firstname","");
  		RegisterData.put("lastname",email);
  		OfferingPage offeringPage = new OfferingPage();
  	}
	
	/*
	 * Email is blank
	 */
	@Test
  	public void RegisterFailEmail1() throws InterruptedException {
  		HashMap<String, String> RegisterData = new HashMap<String, String>();
  		RegisterData.put("firstname",name);
  		RegisterData.put("lastname","");
  		OfferingPage offeringPage = new OfferingPage();
  	}
}

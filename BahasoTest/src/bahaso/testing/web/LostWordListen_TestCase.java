package bahaso.testing.web;

import java.util.HashMap;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import bahaso.testing.general.General;
import bahaso.testing.webElement.LandingPage;
import bahaso.testing.webElement.LostWordListen;

public class LostWordListen_TestCase extends General{
	LandingPage landingPage = null;
	LostWordListen lostWordListen = null;
	HashMap<String, String> LoginData = new HashMap<String, String>();
	
	@BeforeMethod
  	public void before() {
	  driver = getDriver();
	  LoginData.put("email","reddev");
	  LoginData.put("password","mahendralubis");
	  landingPage = new LandingPage(driver);
	  lostWordListen = new LostWordListen(driver);
	  landingPage.doLogin(LoginData);
	  driver.get(baseUrl + "/ngeadmin/previewCaseNewTab/5680de85938e8e173c8b456b");
  	}
	
	@Test
  	public void cekAllElements() throws InterruptedException {
		Thread.sleep(3000);
		lostWordListen.getBoxAnswer().get(0).sendKeys("a");
		lostWordListen.getBoxAnswer().get(1).sendKeys("a");
		lostWordListen.getBoxAnswer().get(2).sendKeys("a");
	}
}

package bahaso.testing.web;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import bahaso.testing.general.General;
import bahaso.testing.webElement.BoxMatchListen;
import bahaso.testing.webElement.LandingPage;

public class BoxMatchListen_TestCase extends General{
	LandingPage landingPage = null;
	BoxMatchListen boxMatchListen = null;
	HashMap<String, String> LoginData = new HashMap<String, String>();
	String[] answer = {"A","U","O","I"};
	

	@BeforeMethod
  	public void beforeMethod() {
	  driver = getDriver();
	  LoginData.put("email","reddev");
	  LoginData.put("password","mahendralubis");
	  landingPage = new LandingPage(driver);
	  boxMatchListen = new BoxMatchListen(driver);
	  landingPage.doLogin(LoginData);
	  driver.get(baseUrl + "/ngeadmin/previewCaseNewTab/56810456938e8e173c8b4575");
  	}
	
	@Test
  	public void answerRight() throws InterruptedException{
		boxMatchListen.answerRight(answer);
		String status[] = boxMatchListen.getLessonStatus().getAttribute("class").split(" ");
		Assert.assertEquals(status[status.length-1], "true");
	}
	
	@Test
  	public void answerWrong() throws InterruptedException{
		boxMatchListen.answerWrong(answer);
		String status[] = boxMatchListen.getLessonStatus().getAttribute("class").split(" ");
		Assert.assertEquals(status[status.length-1], "false");
	}
	
	@AfterMethod
  	public void after() {
  		driver.quit();
  	}
}

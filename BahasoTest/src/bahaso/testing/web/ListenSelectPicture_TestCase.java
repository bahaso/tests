package bahaso.testing.web;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import bahaso.testing.general.General;
import bahaso.testing.webElement.LandingPage;
import bahaso.testing.webElement.ListenSelectPicture;

public class ListenSelectPicture_TestCase extends General{
	LandingPage landingPage = null;
	ListenSelectPicture listenSelectPicture = null;
	HashMap<String, String> LoginData = new HashMap<String, String>();
	String[] answer = {"two tables"};
	
	/**
	 * 
	 */
	@BeforeMethod
  	public void beforeMethod() {
	  driver = getDriver();
	  LoginData.put("email","reddev");
	  LoginData.put("password","mahendralubis");
	  landingPage = new LandingPage(driver);
	  listenSelectPicture = new ListenSelectPicture(driver);
	  landingPage.doLogin(LoginData);
	  driver.get(baseUrl + "/ngeadmin/previewCaseNewTab/56825cdf938e8ed6498b4567");
  	}
	
	@Test
  	public void answerRight() throws InterruptedException{
		listenSelectPicture.answerRight(answer);
		String status[] = listenSelectPicture.getLessonStatus().getAttribute("class").split(" ");
		Assert.assertEquals(status[status.length-1], "true");
	}
	
	@Test
  	public void answerWrong() throws InterruptedException{
		listenSelectPicture.answerWrong(answer);
		String status[] = listenSelectPicture.getLessonStatus().getAttribute("class").split(" ");
		Assert.assertEquals(status[status.length-1], "false");
	}
	
	@AfterMethod
  	public void after() {
  		driver.quit();
  	}
}

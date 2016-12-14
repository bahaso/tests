package bahaso.testing.web;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import bahaso.testing.general.General;
import bahaso.testing.webElement.LandingPage;
import bahaso.testing.webElement.ListenSelectMultipleBox;

public class ListenSelectMultipleBox_TestCase extends General{
	LandingPage landingPage = null;
	ListenSelectMultipleBox listenSelectMultipleBox = null;
	HashMap<String, String> LoginData = new HashMap<String, String>();
	String[] answer = {"beautiful","handsome","awesome"};
	
	@BeforeMethod
  	public void beforeMethod() {
	  driver = getDriver();
	  LoginData.put("email","reddev");
	  LoginData.put("password","mahendralubis");
	  landingPage = new LandingPage(driver);
	  listenSelectMultipleBox = new ListenSelectMultipleBox(driver);
	  landingPage.doLogin(LoginData);
	  driver.get(baseUrl + "/ngeadmin/previewCaseNewTab/568a22d9938e8e8e4f8b456a");
  	}
	
	@Test
  	public void answerRight() throws InterruptedException{
		listenSelectMultipleBox.answerRight(answer);
		String status[] = listenSelectMultipleBox.getLessonStatus().getAttribute("class").split(" ");
		Assert.assertEquals(status[status.length-1], "true");
	}
	
	@Test
  	public void answerWrong() throws InterruptedException{
		listenSelectMultipleBox.answerWrong(answer);
		String status[] = listenSelectMultipleBox.getLessonStatus().getAttribute("class").split(" ");
		Assert.assertEquals(status[status.length-1], "false");
	}
	
	@AfterMethod
  	public void after() {
  		driver.quit();
  	}
	
}


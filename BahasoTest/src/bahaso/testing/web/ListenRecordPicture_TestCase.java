package bahaso.testing.web;

import java.util.ArrayList;
import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import bahaso.testing.general.General;
import bahaso.testing.webElement.LandingPage;
import bahaso.testing.webElement.ListenRecordPicture;

public class ListenRecordPicture_TestCase extends General{
	LandingPage landingPage = null;
	ListenRecordPicture listenRecordPicture = null;
	HashMap<String, String> LoginData = new HashMap<String, String>();
	ArrayList<ArrayList<String>> choices = new ArrayList<ArrayList<String>>();
	ArrayList<String> choice = new ArrayList<String>();
	String answer = "I am from the united kingdom.";
	

	@BeforeMethod
  	public void beforeMethod() {
	  driver = getDriver();
	  LoginData.put("email","reddev");
	  LoginData.put("password","mahendralubis");
	  landingPage = new LandingPage(driver);
	  listenRecordPicture = new ListenRecordPicture(driver);
	  landingPage.doLogin(LoginData);
	  driver.get(baseUrl + "/ngeadmin/previewCaseNewTab/5684b7da938e8e99778b457b");
  	}
	
	@Test
  	public void answerRight() throws InterruptedException{
		listenRecordPicture.answerRight(answer);
		String status[] = listenRecordPicture.getLessonStatus().getAttribute("class").split(" ");
		Assert.assertEquals(status[status.length-1], "true");
	}
	
	@Test
  	public void answerWrong() throws InterruptedException{
		listenRecordPicture.answerWrong(answer);
		String status[] = listenRecordPicture.getLessonStatus().getAttribute("class").split(" ");
		Assert.assertEquals(status[status.length-1], "false");
	}
	
	@AfterMethod
  	public void after() {
  		driver.quit();
  	}
}

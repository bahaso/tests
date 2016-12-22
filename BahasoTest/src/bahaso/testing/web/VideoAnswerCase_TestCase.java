package bahaso.testing.web;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import bahaso.testing.general.General;
import bahaso.testing.webElement.LandingPage;
import bahaso.testing.webElement.VideoAnswerCase;

public class VideoAnswerCase_TestCase extends General{
	LandingPage landingPage = null;
	VideoAnswerCase videoAnswerCase = null;
	HashMap<String, String> LoginData = new HashMap<String, String>();
	String[] answer = {"Good morning, Kevin."};
	

	@BeforeMethod
  	public void beforeMethod() {
	  driver = getDriver();
	  LoginData.put("email","reddev");
	  LoginData.put("password","mahendralubis");
	  landingPage = new LandingPage(driver);
	  videoAnswerCase = new VideoAnswerCase(driver);
	  landingPage.doLogin(LoginData);
	  driver.get(baseUrl + "/ngeadmin/previewCaseNewTab/5680bf66938e8ec1788b4567");
  	}
	
	@Test
  	public void answerRight() throws InterruptedException{
		videoAnswerCase.answerRight(answer);
		String status[] = videoAnswerCase.getLessonStatus().getAttribute("class").split(" ");
		Assert.assertEquals(status[status.length-1], "true");
	}
	
	@Test
  	public void answerWrong() throws InterruptedException{
		videoAnswerCase.answerWrong(answer);
		String status[] = videoAnswerCase.getLessonStatus().getAttribute("class").split(" ");
		Assert.assertEquals(status[status.length-1], "false");
	}
	
	@AfterMethod
  	public void after() {
  		driver.quit();
  	}
}
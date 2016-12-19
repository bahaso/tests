package bahaso.testing.web;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import bahaso.testing.general.General;
import bahaso.testing.webElement.BoxMatchSentence;
import bahaso.testing.webElement.LandingPage;

public class BoxMatchSentence_TestCase extends General{
	LandingPage landingPage = null;
	BoxMatchSentence boxMatchSentence = null;
	HashMap<String, String> LoginData = new HashMap<String, String>();
	String[] answer = {"Good afternoon, Sadie.","How are you doing?","Nice to see you, Britanny."};
	

	@BeforeMethod
  	public void beforeMethod() {
	  driver = getDriver();
	  LoginData.put("email","reddev");
	  LoginData.put("password","mahendralubis");
	  landingPage = new LandingPage(driver);
	  boxMatchSentence = new BoxMatchSentence(driver);
	  landingPage.doLogin(LoginData);
	  driver.get(baseUrl + "/ngeadmin/previewCaseNewTab/5680e70a938e8e173c8b456d");
  	}
	
	@Test
  	public void answerRight() throws InterruptedException{
		boxMatchSentence.answerRight(answer);
		String status[] = boxMatchSentence.getLessonStatus().getAttribute("class").split(" ");
		Assert.assertEquals(status[status.length-1], "true");
	}
	
	@Test
  	public void answerWrong() throws InterruptedException{
		boxMatchSentence.answerWrong(answer);
		String status[] = boxMatchSentence.getLessonStatus().getAttribute("class").split(" ");
		Assert.assertEquals(status[status.length-1], "false");
	}
	
	@AfterMethod
  	public void after() {
  		driver.quit();
  	}
}

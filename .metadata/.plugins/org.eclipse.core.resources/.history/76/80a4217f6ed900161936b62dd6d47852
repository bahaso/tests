package bahaso.testing.web;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import bahaso.testing.general.General;
import bahaso.testing.webElement.LandingPage;
import bahaso.testing.webElement.SentenceFormation;

public class SentenceFormation_TestCase extends General{
	LandingPage landingPage = null;
	SentenceFormation sentenceFormation = null;
	HashMap<String, String> LoginData = new HashMap<String, String>();
	String[] answer = {"Their names","are Vince","and Derek"};
	

	@BeforeMethod
  	public void beforeMethod() {
	  driver = getDriver();
	  LoginData.put("email","reddev");
	  LoginData.put("password","mahendralubis");
	  landingPage = new LandingPage(driver);
	  sentenceFormation = new SentenceFormation(driver);
	  landingPage.doLogin(LoginData);
	  driver.get(baseUrl + "/ngeadmin/previewCaseNewTab/567926da938e8e6c5f8b4572");
  	}
	
	@Test
  	public void answerRight() throws InterruptedException{
		sentenceFormation.answerRight(answer);
		String status[] = sentenceFormation.getLessonStatus().getAttribute("class").split(" ");
		Assert.assertEquals(status[status.length-1], "true");
	}
	
	@Test
  	public void answerWrong() throws InterruptedException{
		sentenceFormation.answerWrong(answer);
		String status[] = sentenceFormation.getLessonStatus().getAttribute("class").split(" ");
		Assert.assertEquals(status[status.length-1], "false");
	}
	
	@AfterMethod
  	public void after() {
  		driver.quit();
  	}
}

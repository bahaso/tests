package bahaso.testing.web;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import bahaso.testing.general.General;
import bahaso.testing.webElement.LandingPage;
import bahaso.testing.webElement.PictureMultipleChoice;

public class PictureMultipleChoice_TestCase extends General{
	LandingPage landingPage = null;
	PictureMultipleChoice PictureMultipleChoice = null;
	HashMap<String, String> LoginData = new HashMap<String, String>();
	String answer = "His name is John.";
	
	@BeforeMethod
  	public void beforeMethod() {
	  driver = getDriver();
	  LoginData.put("email","reddev");
	  LoginData.put("password","mahendralubis");
	  landingPage = new LandingPage(driver);
	  PictureMultipleChoice = new PictureMultipleChoice(driver);
	  landingPage.doLogin(LoginData);
	  driver.get(baseUrl + "/ngeadmin/previewCaseNewTab/5679286f938e8e0a3a8b4579");
  	}
	
	@Test
  	public void answerRight() throws InterruptedException{
		PictureMultipleChoice.answerRight(answer);
		String status[] = PictureMultipleChoice.getLessonStatus().getAttribute("class").split(" ");
		Assert.assertEquals(status[status.length-1], "true");
	}
	
	@Test
  	public void answerWrong() throws InterruptedException{
		PictureMultipleChoice.answerWrong(answer);
		String status[] = PictureMultipleChoice.getLessonStatus().getAttribute("class").split(" ");
		Assert.assertEquals(status[status.length-1], "false");
	}
	
	@AfterMethod
  	public void after() {
  		driver.quit();
  	}
}

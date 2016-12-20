package bahaso.testing.web;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import bahaso.testing.general.General;
import bahaso.testing.webElement.DragMultipleChoice;
import bahaso.testing.webElement.LandingPage;

public class DragMultipleChoice_TestCase extends General{
	LandingPage landingPage = null;
	DragMultipleChoice dragMultipleChoice = null;
	HashMap<String, String> LoginData = new HashMap<String, String>();
	String[] answer = {"him"};
	

	@BeforeMethod
  	public void beforeMethod() {
	  driver = getDriver();
	  LoginData.put("email","reddev");
	  LoginData.put("password","mahendralubis");
	  landingPage = new LandingPage(driver);
	  dragMultipleChoice = new DragMultipleChoice(driver);
	  landingPage.doLogin(LoginData);
	  driver.get(baseUrl + "/ngeadmin/previewCaseNewTab/568b3969938e8e4d3d8b4656");
  	}
	
	@Test
  	public void answerRight() throws InterruptedException{
		dragMultipleChoice.answerRight(answer);
		String status[] = dragMultipleChoice.getLessonStatus().getAttribute("class").split(" ");
		Assert.assertEquals(status[status.length-1], "true");
	}
	
	@Test
  	public void answerWrong() throws InterruptedException{
		dragMultipleChoice.answerWrong(answer);
		String status[] = dragMultipleChoice.getLessonStatus().getAttribute("class").split(" ");
		Assert.assertEquals(status[status.length-1], "false");
	}
	
	@AfterMethod
  	public void after() {
  		driver.quit();
  	}
}

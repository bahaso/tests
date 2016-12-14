package bahaso.testing.web;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import bahaso.testing.general.General;
import bahaso.testing.webElement.LandingPage;
import bahaso.testing.webElement.ListenSelectSingleBox;

public class ListenSelectSingleBox_TestCase extends General{
	LandingPage landingPage = null;
	ListenSelectSingleBox listenSelectSingleBox = null;
	HashMap<String, String> LoginData = new HashMap<String, String>();
	String[] answer = {"My name is Diana."};
	
	@BeforeMethod
  	public void beforeMethod() {
	  driver = getDriver();
	  LoginData.put("email","reddev");
	  LoginData.put("password","mahendralubis");
	  landingPage = new LandingPage(driver);
	  listenSelectSingleBox = new ListenSelectSingleBox(driver);
	  landingPage.doLogin(LoginData);
	  driver.get(baseUrl + "/ngeadmin/previewCaseNewTab/56792283938e8e6c5f8b4570");
  	}
	
	@Test
  	public void answerRight() throws InterruptedException{
		listenSelectSingleBox.answerRight(answer);
		String status[] = listenSelectSingleBox.getLessonStatus().getAttribute("class").split(" ");
		Assert.assertEquals(status[status.length-1], "true");
	}
	
	@Test
  	public void answerWrong() throws InterruptedException{
		listenSelectSingleBox.answerWrong(answer);
		String status[] = listenSelectSingleBox.getLessonStatus().getAttribute("class").split(" ");
		Assert.assertEquals(status[status.length-1], "false");
	}
	
	@AfterMethod
  	public void after() {
  		driver.quit();
  	}
}

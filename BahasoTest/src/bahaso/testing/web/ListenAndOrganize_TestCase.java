package bahaso.testing.web;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import bahaso.testing.general.General;
import bahaso.testing.webElement.LandingPage;
import bahaso.testing.webElement.ListenAndOrganize;

public class ListenAndOrganize_TestCase extends General{
	LandingPage landingPage = null;
	ListenAndOrganize listenAndOrganize = null;
	HashMap<String, String> LoginData = new HashMap<String, String>();
	String[] answer = {"Hello, my name is Michelle. I'm 33 years old.","Hello! My name is Julian.","How old are you, Julian?",
						"I am 28 years old. Where are you from, Michelle?","I'm from Paris, France, and you?","I'm from Brussels, Belgium. "};
	

	@BeforeMethod
  	public void beforeMethod() {
	  driver = getDriver();
	  LoginData.put("email","reddev");
	  LoginData.put("password","mahendralubis");
	  landingPage = new LandingPage(driver);
	  listenAndOrganize = new ListenAndOrganize(driver);
	  landingPage.doLogin(LoginData);
	  driver.get(baseUrl + "/ngeadmin/previewCaseNewTab/568a1241938e8e4d3d8b4568");
  	}
	
	@Test
  	public void answerRight() throws InterruptedException{
		listenAndOrganize.answerRight(answer);
		String status[] = listenAndOrganize.getLessonStatus().getAttribute("class").split(" ");
		Assert.assertEquals(status[status.length-1], "true");
	}
	
	@Test
  	public void answerWrong() throws InterruptedException{
		listenAndOrganize.answerWrong(answer);
		String status[] = listenAndOrganize.getLessonStatus().getAttribute("class").split(" ");
		Assert.assertEquals(status[status.length-1], "false");
	}
	
	@AfterMethod
  	public void after() {
  		driver.quit();
  	}
}

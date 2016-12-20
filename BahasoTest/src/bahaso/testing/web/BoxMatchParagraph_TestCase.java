package bahaso.testing.web;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import bahaso.testing.general.General;
import bahaso.testing.webElement.BoxMatchParagraph;
import bahaso.testing.webElement.LandingPage;

public class BoxMatchParagraph_TestCase extends General{
	LandingPage landingPage = null;
	BoxMatchParagraph boxMatchParagraph = null;
	HashMap<String, String> LoginData = new HashMap<String, String>();
	String[] answer = {"Korean","funny guy","Japan","Japanese","Tokyo","quiet"};
	

	@BeforeMethod
  	public void beforeMethod() {
	  driver = getDriver();
	  LoginData.put("email","reddev");
	  LoginData.put("password","mahendralubis");
	  landingPage = new LandingPage(driver);
	  boxMatchParagraph = new BoxMatchParagraph(driver);
	  landingPage.doLogin(LoginData);
	  driver.get(baseUrl + "/ngeadmin/previewCaseNewTab/568a2486938e8e4d3d8b456e");
  	}
	
	@Test
  	public void answerRight() throws InterruptedException{
		boxMatchParagraph.answerRight(answer);
		String status[] = boxMatchParagraph.getLessonStatus().getAttribute("class").split(" ");
		Assert.assertEquals(status[status.length-1], "true");
	}
	
	@Test
  	public void answerWrong() throws InterruptedException{
		boxMatchParagraph.answerWrong(answer);
		String status[] = boxMatchParagraph.getLessonStatus().getAttribute("class").split(" ");
		Assert.assertEquals(status[status.length-1], "false");
	}
	
	@AfterMethod
  	public void after() {
  		driver.quit();
  	}
}
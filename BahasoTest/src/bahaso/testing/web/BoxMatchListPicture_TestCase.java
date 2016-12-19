package bahaso.testing.web;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import bahaso.testing.general.General;
import bahaso.testing.webElement.BoxMatchListPicture;
import bahaso.testing.webElement.LandingPage;

public class BoxMatchListPicture_TestCase extends General{
	LandingPage landingPage = null;
	BoxMatchListPicture boxMatchListPicture = null;
	HashMap<String, String> LoginData = new HashMap<String, String>();
	String[] answer = {"on"};
	

	@BeforeMethod
  	public void beforeMethod() {
	  driver = getDriver();
	  LoginData.put("email","reddev");
	  LoginData.put("password","mahendralubis");
	  landingPage = new LandingPage(driver);
	  boxMatchListPicture = new BoxMatchListPicture(driver);
	  landingPage.doLogin(LoginData);
	  driver.get(baseUrl + "/ngeadmin/previewCaseNewTab/568382ed938e8ec0348b4567");
  	}
	
	@Test
  	public void answerRight() throws InterruptedException{
		boxMatchListPicture.answerRight(answer);
		String status[] = boxMatchListPicture.getLessonStatus().getAttribute("class").split(" ");
		Assert.assertEquals(status[status.length-1], "true");
	}
	
	@Test
  	public void answerWrong() throws InterruptedException{
		boxMatchListPicture.answerWrong(answer);
		String status[] = boxMatchListPicture.getLessonStatus().getAttribute("class").split(" ");
		Assert.assertEquals(status[status.length-1], "false");
	}
	
	@AfterMethod
  	public void after() {
  		driver.quit();
  	}
}

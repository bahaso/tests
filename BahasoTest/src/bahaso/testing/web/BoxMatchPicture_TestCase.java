package bahaso.testing.web;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import bahaso.testing.general.General;
import bahaso.testing.webElement.BoxMatchPicture;
import bahaso.testing.webElement.LandingPage;

public class BoxMatchPicture_TestCase extends General{
	LandingPage landingPage = null;
	BoxMatchPicture boxMatchPicture = null;
	HashMap<String, String> LoginData = new HashMap<String, String>();
	String[] answer = {"five","eight","two","three"};
	

	@BeforeMethod
  	public void beforeMethod() {
	  driver = getDriver();
	  LoginData.put("email","reddev");
	  LoginData.put("password","mahendralubis");
	  landingPage = new LandingPage(driver);
	  boxMatchPicture = new BoxMatchPicture(driver);
	  landingPage.doLogin(LoginData);
	  driver.get(baseUrl + "/ngeadmin/previewCaseNewTab/56810f0e938e8e32528b456f");
  	}
	
	@Test
  	public void answerRight() throws InterruptedException{
		boxMatchPicture.answerRight(answer);
		String status[] = boxMatchPicture.getLessonStatus().getAttribute("class").split(" ");
		Assert.assertEquals(status[status.length-1], "true");
	}
	
	@Test
  	public void answerWrong() throws InterruptedException{
		boxMatchPicture.answerWrong(answer);
		String status[] = boxMatchPicture.getLessonStatus().getAttribute("class").split(" ");
		Assert.assertEquals(status[status.length-1], "false");
	}
	
	@AfterMethod
  	public void after() {
  		driver.quit();
  	}
}
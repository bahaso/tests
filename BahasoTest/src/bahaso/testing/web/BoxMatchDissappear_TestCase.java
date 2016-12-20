package bahaso.testing.web;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import bahaso.testing.general.General;
import bahaso.testing.webElement.BoxMatchDissappear;
import bahaso.testing.webElement.LandingPage;

public class BoxMatchDissappear_TestCase extends General{
	LandingPage landingPage = null;
	BoxMatchDissappear boxMatchDissappear = null;
	HashMap<String, String> LoginData = new HashMap<String, String>();
	String[][] answer = {{"good morning","good afternoon","good evening"},{"good bye","see you later"}};
	

	@BeforeMethod
  	public void beforeMethod() {
	  driver = getDriver();
	  LoginData.put("email","reddev");
	  LoginData.put("password","mahendralubis");
	  landingPage = new LandingPage(driver);
	  boxMatchDissappear = new BoxMatchDissappear(driver);
	  landingPage.doLogin(LoginData);
	  driver.get(baseUrl + "/ngeadmin/previewCaseNewTab/5680dfcb938e8e7f2c8b456a");
  	}
	
	@Test
  	public void answerRight() throws InterruptedException{
		boxMatchDissappear.answerRight(answer);
		String status[] = boxMatchDissappear.getLessonStatus().getAttribute("class").split(" ");
		Assert.assertEquals(status[status.length-1], "true");
	}
	
	@Test
  	public void answerWrong() throws InterruptedException{
		boxMatchDissappear.answerWrong(answer);
		String status[] = boxMatchDissappear.getLessonStatus().getAttribute("class").split(" ");
		Assert.assertEquals(status[status.length-1], "false");
	}
	
	@AfterMethod
  	public void after() {
  		driver.quit();
  	}
}

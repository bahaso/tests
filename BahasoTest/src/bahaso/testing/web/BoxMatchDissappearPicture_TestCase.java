package bahaso.testing.web;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import bahaso.testing.general.General;
import bahaso.testing.webElement.BoxMatchDissappearPicture;
import bahaso.testing.webElement.LandingPage;

public class BoxMatchDissappearPicture_TestCase extends General{
	LandingPage landingPage = null;
	BoxMatchDissappearPicture boxMatchDissappearPicture = null;
	HashMap<String, String> LoginData = new HashMap<String, String>();
	String[][] answer = {{"jam-10.png","jam-8.png","jam-1.png"},{"jam-9.png","jam-7.png","jam-3.png"}};
	

	@BeforeMethod
  	public void beforeMethod() {
	  driver = getDriver();
	  LoginData.put("email","reddev");
	  LoginData.put("password","mahendralubis");
	  landingPage = new LandingPage(driver);
	  boxMatchDissappearPicture = new BoxMatchDissappearPicture(driver);
	  landingPage.doLogin(LoginData);
	  driver.get(baseUrl + "/ngeadmin/previewCaseNewTab/569776c2938e8e97658b456c");
  	}
	
	@Test
  	public void answerRight() throws InterruptedException{
		boxMatchDissappearPicture.answerRight(answer);
		String status[] = boxMatchDissappearPicture.getLessonStatus().getAttribute("class").split(" ");
		Assert.assertEquals(status[status.length-1], "true");
	}
	
	@Test
  	public void answerWrong() throws InterruptedException{
		boxMatchDissappearPicture.answerWrong(answer);
		String status[] = boxMatchDissappearPicture.getLessonStatus().getAttribute("class").split(" ");
		Assert.assertEquals(status[status.length-1], "false");
	}
	
	@AfterMethod
  	public void after() {
  		driver.quit();
  	}
}

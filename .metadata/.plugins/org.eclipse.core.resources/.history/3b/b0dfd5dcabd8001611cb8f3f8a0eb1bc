package bahaso.testing.web;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import bahaso.testing.general.General;
import bahaso.testing.webElement.BoxMatchList;
import bahaso.testing.webElement.LandingPage;

public class BoxMatchList_TestCase extends General{
	LandingPage landingPage = null;
	BoxMatchList boxMatchList = null;
	HashMap<String, String> LoginData = new HashMap<String, String>();
	String[] answer = {"is","is","is","are"};
	

	@BeforeMethod
  	public void beforeMethod() {
	  driver = getDriver();
	  LoginData.put("email","reddev");
	  LoginData.put("password","mahendralubis");
	  landingPage = new LandingPage(driver);
	  boxMatchList = new BoxMatchList(driver);
	  landingPage.doLogin(LoginData);
	  driver.get(baseUrl + "/ngeadmin/previewCaseNewTab/5679264d938e8e0a3a8b4578");
  	}
	
	@Test
  	public void answerRight() throws InterruptedException{
		boxMatchList.answerRight(answer);
		String status[] = boxMatchList.getLessonStatus().getAttribute("class").split(" ");
		Assert.assertEquals(status[status.length-1], "true");
	}
	
	@Test
  	public void answerWrong() throws InterruptedException{
		boxMatchList.answerWrong(answer);
		String status[] = boxMatchList.getLessonStatus().getAttribute("class").split(" ");
		Assert.assertEquals(status[status.length-1], "false");
	}
	
	@AfterMethod
  	public void after() {
  		driver.quit();
  	}
}

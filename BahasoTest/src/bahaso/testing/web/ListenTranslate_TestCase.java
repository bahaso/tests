package bahaso.testing.web;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import bahaso.testing.general.General;
import bahaso.testing.webElement.LandingPage;
import bahaso.testing.webElement.ListenTranslate;

public class ListenTranslate_TestCase extends General{
	LandingPage landingPage = null;
	ListenTranslate listenTranslate = null;
	HashMap<String, String> LoginData = new HashMap<String, String>();
	String answer = "Keponakan Perempuan";
	
	@BeforeMethod
  	public void before() {
	  driver = getDriver();
	  LoginData.put("email","reddev");
	  LoginData.put("password","mahendralubis");
	  landingPage = new LandingPage(driver);
	  listenTranslate = new ListenTranslate(driver);
	  landingPage.doLogin(LoginData);
	  driver.get(baseUrl + "/ngeadmin/previewCaseNewTab/568cc89d938e8edf248b457b");
  	}
	
	@Test
  	public void cekAllElements() throws InterruptedException {
		Thread.sleep(3000);
		String status[] = listenTranslate.getAudioButton().getAttribute("class").split(" ");
		Assert.assertEquals(status[status.length-1], "audio-playing");
	}
	
	@Test
  	public void answerRight() throws InterruptedException{
		listenTranslate.answerRight(answer);
		String status[] = listenTranslate.getLessonStatus().getAttribute("class").split(" ");
		Assert.assertEquals(status[status.length-1], "true");
	}
	
	@Test
  	public void answerWrong() throws InterruptedException{
		listenTranslate.answerWrong(answer);
		String status[] = listenTranslate.getLessonStatus().getAttribute("class").split(" ");
		Assert.assertEquals(status[status.length-1], "false");
	}
	
	@AfterMethod
  	public void after() {
  		driver.quit();
  	}
	
}

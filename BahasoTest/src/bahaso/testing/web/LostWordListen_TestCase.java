package bahaso.testing.web;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import bahaso.testing.general.General;
import bahaso.testing.webElement.LandingPage;
import bahaso.testing.webElement.LostWordListen;

public class LostWordListen_TestCase extends General{
	LandingPage landingPage = null;
	LostWordListen lostWordListen = null;
	HashMap<String, String> LoginData = new HashMap<String, String>();
	String[] answer = {"morning","later","evening"};
	
	@BeforeMethod
  	public void before() {
	  driver = getDriver();
	  LoginData.put("email","reddev");
	  LoginData.put("password","mahendralubis");
	  landingPage = new LandingPage(driver);
	  lostWordListen = new LostWordListen(driver);
	  landingPage.doLogin(LoginData);
	  driver.get(baseUrl + "/ngeadmin/previewCaseNewTab/5680de85938e8e173c8b456b");
  	}
	
	@Test
  	public void cekAllElements() throws InterruptedException {
		Thread.sleep(3000);
		String status[] = lostWordListen.getAudioButton().getAttribute("class").split(" ");
		Assert.assertEquals(status[status.length-1], "audio-playing");
	}
	
	@Test
  	public void answerRight() throws InterruptedException{
		lostWordListen.answerRight(answer);
		String status[] = lostWordListen.getLessonStatus().getAttribute("class").split(" ");
		Assert.assertEquals(status[status.length-1], "true");
	}
	
	@Test
  	public void answerWrong() throws InterruptedException{
		lostWordListen.answerWrong(answer);
		String status[] = lostWordListen.getLessonStatus().getAttribute("class").split(" ");
		Assert.assertEquals(status[status.length-1], "false");
	}
	
	@AfterMethod
  	public void after() {
  		driver.quit();
  	}
}
package bahaso.testing.web;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import bahaso.testing.general.General;
import bahaso.testing.webElement.LandingPage;
import bahaso.testing.webElement.TrueFalseListen;;

public class TrueFalseListen_TestCase extends General{
	String instruction = "Tentukan benar atau salah berdasarkan suara dan kalimat di bawah ini";
	String question = "What time is it?";
	String description = "It's twenty five past four o'clock.";
	boolean answer = true;
	TrueFalseListen TrueFalseListen = null;
	LandingPage landingPage = null;
	HashMap<String, String> LoginData = new HashMap<String, String>();
	
	@BeforeMethod
  	public void before() throws InterruptedException {
	  driver = getDriver();
	  LoginData.put("email","reddev");
	  LoginData.put("password","mahendralubis");
	  TrueFalseListen = new TrueFalseListen(driver);
	  landingPage = new LandingPage(driver);
	  landingPage.doLogin(LoginData);
	  driver.get(baseUrl +"/ngeadmin/previewCaseNewTab/568ba5c3938e8ebe3d8b4569");
  	}
	
	@Test
  	public void cekAllElement() throws InterruptedException{
		Thread.sleep(2000);
		String status[] = TrueFalseListen.getAudioButton().getAttribute("class").split(" ");
		Assert.assertEquals(status[status.length-1], "audio-playing");
		Assert.assertEquals(TrueFalseListen.getInstruction().getText(), instruction);
		Assert.assertEquals(TrueFalseListen.getQuestion().getText(), question);
		Assert.assertEquals(TrueFalseListen.getDescription().getText(), description);
	}
	
	@Test
  	public void answerRight() throws InterruptedException{
		Thread.sleep(2000);
		if(answer){
			TrueFalseListen.getTrueButton().click();
			TrueFalseListen.getButtonCheck().click();
			Thread.sleep(2000);
			String status[] = TrueFalseListen.getLessonStatus().getAttribute("class").split(" ");
			Assert.assertEquals(status[status.length-1], "true");
		}else{
			TrueFalseListen.getFalseButton().click();
			TrueFalseListen.getButtonCheck().click();
			Thread.sleep(2000);
			String status[] = TrueFalseListen.getLessonStatus().getAttribute("class").split(" ");
			Assert.assertEquals(status[status.length-1], "true");
		}
	}
	
	@Test
  	public void answerWrong() throws InterruptedException{
		Thread.sleep(2000);
		if(!answer){
			TrueFalseListen.getTrueButton().click();
			TrueFalseListen.getButtonCheck().click();
			Thread.sleep(2000);
			String status[] = TrueFalseListen.getLessonStatus().getAttribute("class").split(" ");
			Assert.assertEquals(status[status.length-1], "false");
		}else{
			TrueFalseListen.getFalseButton().click();
			TrueFalseListen.getButtonCheck().click();
			Thread.sleep(2000);
			String status[] = TrueFalseListen.getLessonStatus().getAttribute("class").split(" ");
			Assert.assertEquals(status[status.length-1], "false");
		}
	}
	
	@AfterMethod
  	public void after() {
  		driver.quit();
  	}
}
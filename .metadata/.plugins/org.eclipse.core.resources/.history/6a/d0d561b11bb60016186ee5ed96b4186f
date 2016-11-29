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
	TrueFalseListen TrueFalseListen = new TrueFalseListen();
	LandingPage landingPage = new LandingPage();
	HashMap<String, String> LoginData = new HashMap<String, String>();
	
	@BeforeMethod
  	public void before() throws InterruptedException {
	  driver = getDriver();
	  LoginData.put("email","reddev");
	  LoginData.put("password","mahendralubis");
	  landingPage.doLogin(driver, LoginData);
	  driver.get(baseUrl +"/ngeadmin/previewCaseNewTab/568ba5c3938e8ebe3d8b4569");
  	}
	
	@Test
  	public void cekAllElement() throws InterruptedException{
		Thread.sleep(2000);
		String status[] = TrueFalseListen.getAudioButton(driver).getAttribute("class").split(" ");
		Assert.assertEquals(status[status.length-1], "audio-playing");
		Assert.assertEquals(TrueFalseListen.getInstruction(driver).getText(), instruction);
		Assert.assertEquals(TrueFalseListen.getQuestion(driver).getText(), question);
		Assert.assertEquals(TrueFalseListen.getDescription(driver).getText(), description);
	}
	
	@Test
  	public void answerRight() throws InterruptedException{
		Thread.sleep(2000);
		if(answer){
			TrueFalseListen.getTrueButton(driver).click();
			TrueFalseListen.getButtonCheck(driver).click();
			Thread.sleep(2000);
			String status[] = TrueFalseListen.getLessonStatus(driver).getAttribute("class").split(" ");
			Assert.assertEquals(status[status.length-1], "true");
		}else{
			TrueFalseListen.getTrueButton(driver).click();
			TrueFalseListen.getButtonCheck(driver).click();
			Thread.sleep(2000);
			String status[] = TrueFalseListen.getLessonStatus(driver).getAttribute("class").split(" ");
			Assert.assertEquals(status[status.length-1], "false");
		}
	}
	
	@Test
  	public void answerWrong() throws InterruptedException{
		Thread.sleep(2000);
		if(!answer){
			TrueFalseListen.getTrueButton(driver).click();
			TrueFalseListen.getButtonCheck(driver).click();
			Thread.sleep(2000);
			String status[] = TrueFalseListen.getLessonStatus(driver).getAttribute("class").split(" ");
			Assert.assertEquals(status[status.length-1], "false");
		}else{
			TrueFalseListen.getTrueButton(driver).click();
			TrueFalseListen.getButtonCheck(driver).click();
			Thread.sleep(2000);
			String status[] = TrueFalseListen.getLessonStatus(driver).getAttribute("class").split(" ");
			Assert.assertEquals(status[status.length-1], "true");
		}
	}
	
	@AfterMethod
  	public void after() {
  		driver.quit();
  	}
}

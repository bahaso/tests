package bahaso.testing.web;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import bahaso.testing.general.General;
import bahaso.testing.webElement.LandingPage;
import bahaso.testing.webElement.TrueFalseSentence;

public class TrueFalseSentence_TestCase extends General{
	String instruction = "Tentukan benar atau salah berdasarkan kalimat di bawah ini";
	String description = "This necklaces is most expensive.";
	boolean answer = false;
	TrueFalseSentence trueFalseSentence = new TrueFalseSentence();
	LandingPage landingPage = new LandingPage();
	HashMap<String, String> LoginData = new HashMap<String, String>();
	
	@BeforeMethod
  	public void before() throws InterruptedException {
	  driver = getDriver();
	  LoginData.put("email","reddev");
	  LoginData.put("password","mahendralubis");
	  landingPage.doLogin(driver, LoginData);
	  driver.get(baseUrl + "/ngeadmin/previewCaseNewTab/56961fde938e8e7c358b4575");
  	}
	
	@Test
  	public void cekAllElement() throws InterruptedException{
		Thread.sleep(2000);
		Assert.assertEquals(trueFalseSentence.getInstruction(driver).getText(), instruction);
		Assert.assertEquals(trueFalseSentence.getDescription(driver).getText(), description);
	}
	
	@Test
  	public void answerRight() throws InterruptedException{
		Thread.sleep(2000);
		if(answer){
			trueFalseSentence.getTrueButton(driver).click();
			trueFalseSentence.getButtonCheck(driver).click();
			Thread.sleep(2000);
			String status[] = trueFalseSentence.getLessonStatus(driver).getAttribute("class").split(" ");
			Assert.assertEquals(status[status.length-1], "true");
		}else{
			trueFalseSentence.getTrueButton(driver).click();
			trueFalseSentence.getButtonCheck(driver).click();
			Thread.sleep(2000);
			String status[] = trueFalseSentence.getLessonStatus(driver).getAttribute("class").split(" ");
			Assert.assertEquals(status[status.length-1], "false");
		}
	}
	
	@Test
  	public void answerWrong() throws InterruptedException{
		Thread.sleep(2000);
		if(!answer){
			trueFalseSentence.getTrueButton(driver).click();
			trueFalseSentence.getButtonCheck(driver).click();
			Thread.sleep(2000);
			String status[] = trueFalseSentence.getLessonStatus(driver).getAttribute("class").split(" ");
			Assert.assertEquals(status[status.length-1], "false");
		}else{
			trueFalseSentence.getTrueButton(driver).click();
			trueFalseSentence.getButtonCheck(driver).click();
			Thread.sleep(2000);
			String status[] = trueFalseSentence.getLessonStatus(driver).getAttribute("class").split(" ");
			Assert.assertEquals(status[status.length-1], "true");
		}
	}
	
	@AfterMethod
  	public void after() {
  		driver.quit();
  	}
}

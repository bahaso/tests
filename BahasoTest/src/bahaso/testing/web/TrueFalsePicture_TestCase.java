package bahaso.testing.web;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import bahaso.testing.general.General;
import bahaso.testing.webElement.LandingPage;
import bahaso.testing.webElement.TrueFalsePicture;

public class TrueFalsePicture_TestCase extends General{
	String instruction = "Tentukan benar atau salah berdasarkan gambar berikut ini";
	String question = "Apakah pernyataan ini benar?";
	String description = "Her name is Kevin";
	boolean answer = false;
	TrueFalsePicture trueFalsePicture = new TrueFalsePicture();
	LandingPage landingPage = new LandingPage();
	HashMap<String, String> LoginData = new HashMap<String, String>();
	
	@BeforeMethod
  	public void before() throws InterruptedException {
	  driver = getDriver();
	  LoginData.put("email","reddev");
	  LoginData.put("password","mahendralubis");
	  landingPage.doLogin(driver, LoginData);
	  driver.get(baseUrl + "/ngeadmin/previewCaseNewTab/567929fb938e8e0a3a8b457a");
  	}
	
	@Test
  	public void cekAllElement() throws InterruptedException{
		Thread.sleep(2000);
		Assert.assertEquals(trueFalsePicture.getInstruction(driver).getText(), instruction);
		Assert.assertEquals(trueFalsePicture.getQuestion(driver).getText(), question);
		Assert.assertEquals(trueFalsePicture.getDescription(driver).getText(), description);
	}
	
	@Test
  	public void answerRight() throws InterruptedException{
		Thread.sleep(2000);
		if(answer){
			trueFalsePicture.getTrueButton(driver).click();
			trueFalsePicture.getButtonCheck(driver).click();
			Thread.sleep(2000);
			String status[] = trueFalsePicture.getLessonStatus(driver).getAttribute("class").split(" ");
			Assert.assertEquals(status[status.length-1], "true");
		}else{
			trueFalsePicture.getTrueButton(driver).click();
			trueFalsePicture.getButtonCheck(driver).click();
			Thread.sleep(2000);
			String status[] = trueFalsePicture.getLessonStatus(driver).getAttribute("class").split(" ");
			Assert.assertEquals(status[status.length-1], "false");
		}
	}
	
	@Test
  	public void answerWrong() throws InterruptedException{
		Thread.sleep(2000);
		if(!answer){
			trueFalsePicture.getTrueButton(driver).click();
			trueFalsePicture.getButtonCheck(driver).click();
			Thread.sleep(2000);
			String status[] = trueFalsePicture.getLessonStatus(driver).getAttribute("class").split(" ");
			Assert.assertEquals(status[status.length-1], "false");
		}else{
			trueFalsePicture.getTrueButton(driver).click();
			trueFalsePicture.getButtonCheck(driver).click();
			Thread.sleep(2000);
			String status[] = trueFalsePicture.getLessonStatus(driver).getAttribute("class").split(" ");
			Assert.assertEquals(status[status.length-1], "true");
		}
	}
	
	@AfterMethod
  	public void after() {
  		driver.quit();
  	}
	
}

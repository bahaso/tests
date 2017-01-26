package bahaso.testing.web;

import java.util.ArrayList;
import java.util.HashMap;

import org.bson.Document;
import org.bson.types.ObjectId;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.mongodb.BasicDBObject;
import com.mongodb.client.MongoCollection;

import bahaso.testing.general.General;
import bahaso.testing.webElement.LandingPage;
import bahaso.testing.webElement.TrueFalseListen;;

public class TrueFalseListen_TestCase extends General{
	String instruction = "Tentukan benar atau salah berdasarkan suara dan kalimat di bawah ini";
	String question = "What time is it?";
	String description = "It's twenty five past four o'clock.";
	TrueFalseListen TrueFalseListen = null;
	LandingPage landingPage = null;
	HashMap<String, String> LoginData = new HashMap<String, String>();
	ArrayList<WebElement> buttonPage = new ArrayList<WebElement>();
	Object answer;
	
	@BeforeMethod
  	public void before(){
	  driver = getDriver();
	  LoginData.put("email","reddev");
	  LoginData.put("password","mahendra89");
	  TrueFalseListen = new TrueFalseListen(driver);
	  landingPage = new LandingPage(driver);
	  landingPage.doLogin(LoginData);
	  driver.get(baseUrl +"/ngeadmin/previewCaseNewTab/568ba5c3938e8ebe3d8b4569");
	  
	  //Get Case ID
	  buttonPage = (ArrayList<WebElement>) driver.findElements(By.className("btn-page"));
	  
	  //Get Data from Database
	  MongoCollection<Document> table = db.getCollection("case");
	  BasicDBObject searchQuery = new BasicDBObject();
	  searchQuery.put("_id", new ObjectId(buttonPage.get(0).getAttribute("data-id")));
	  Document cursor = table.find(searchQuery).first();
	  
	  //Convert answer
	  answer = TrueFalseListen.getAnswerData(cursor);
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
		TrueFalseListen.answerRight(answer);
		String status[] = TrueFalseListen.getLessonStatus().getAttribute("class").split(" ");
		Assert.assertEquals(status[status.length-1], "true");
	}
	
	@Test
  	public void answerWrong() throws InterruptedException{
		TrueFalseListen.answerWrong(answer);
		String status[] = TrueFalseListen.getLessonStatus().getAttribute("class").split(" ");
		Assert.assertEquals(status[status.length-1], "false");
	}
	
	@AfterMethod
  	public void after() {
  		driver.quit();
  	}
}

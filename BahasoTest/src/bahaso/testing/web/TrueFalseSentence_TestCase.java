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
import bahaso.testing.webElement.TrueFalseSentence;

public class TrueFalseSentence_TestCase extends General{
	String instruction = "Tentukan benar atau salah berdasarkan kalimat di bawah ini";
	String description = "This necklaces is most expensive.";
	TrueFalseSentence TrueFalseSentence = null;
	LandingPage landingPage = null;
	HashMap<String, String> LoginData = new HashMap<String, String>();
	ArrayList<WebElement> buttonPage = new ArrayList<WebElement>();
	Object answer;
	
	@BeforeMethod
  	public void before() throws InterruptedException {
	  driver = getDriver();
	  LoginData.put("email","reddev");
	  LoginData.put("password","mahendra89");
	  TrueFalseSentence = new TrueFalseSentence(driver);
	  landingPage = new LandingPage(driver);
	  landingPage.doLogin(LoginData);
	  driver.get(baseUrl + "/ngeadmin/previewCaseNewTab/56961fde938e8e7c358b4575");
	  
	  //Get Case ID
	  buttonPage = (ArrayList<WebElement>) driver.findElements(By.className("btn-page"));
	  
	  //Get Data from Database
	  MongoCollection<Document> table = db.getCollection("case");
	  BasicDBObject searchQuery = new BasicDBObject();
	  searchQuery.put("_id", new ObjectId(buttonPage.get(0).getAttribute("data-id")));
	  Document cursor = table.find(searchQuery).first();
	  
	  //Convert answer
	  answer = TrueFalseSentence.getAnswerData(cursor);
  	}
	
	@Test
  	public void cekAllElement() throws InterruptedException{
		Thread.sleep(2000);
		Assert.assertEquals(TrueFalseSentence.getInstruction().getText(), instruction);
		Assert.assertEquals(TrueFalseSentence.getDescription().getText(), description);
	}
	
	@Test
  	public void answerRight() throws InterruptedException{
		TrueFalseSentence.answerRight(answer);
		String status[] = TrueFalseSentence.getLessonStatus().getAttribute("class").split(" ");
		Assert.assertEquals(status[status.length-1], "true");
	}
	
	@Test
  	public void answerWrong() throws InterruptedException{
		TrueFalseSentence.answerWrong(answer);
		String status[] = TrueFalseSentence.getLessonStatus().getAttribute("class").split(" ");
		Assert.assertEquals(status[status.length-1], "false");
	}
	
	@AfterMethod
  	public void after() {
  		driver.quit();
  	}
}

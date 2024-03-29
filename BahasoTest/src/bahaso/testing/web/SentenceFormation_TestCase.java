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
import bahaso.testing.webElement.SentenceFormation;

public class SentenceFormation_TestCase extends General{
	LandingPage landingPage = null;
	SentenceFormation sentenceFormation = null;
	HashMap<String, String> LoginData = new HashMap<String, String>();
	ArrayList<WebElement> buttonPage = new ArrayList<WebElement>();
	Object answer;
	

	@BeforeMethod
  	public void beforeMethod() {
	  driver = getDriver();
	  LoginData.put("email","reddev");
	  LoginData.put("password","mahendra89");
	  landingPage = new LandingPage(driver);
	  sentenceFormation = new SentenceFormation(driver);
	  landingPage.doLogin(LoginData);
	  driver.get(baseUrl + "/ngeadmin/previewCaseNewTab/567926da938e8e6c5f8b4572");
	  
	  //Get Case ID
	  buttonPage = (ArrayList<WebElement>) driver.findElements(By.className("btn-page"));
	  
	  //Get Data from Database
	  MongoCollection<Document> table = db.getCollection("case");
	  BasicDBObject searchQuery = new BasicDBObject();
	  searchQuery.put("_id", new ObjectId(buttonPage.get(0).getAttribute("data-id")));
	  Document cursor = table.find(searchQuery).first();
	  
	  //Convert answer
	  answer = sentenceFormation.getAnswerData(cursor);
  	}
	
	@Test
  	public void answerRight() throws InterruptedException{
		sentenceFormation.answerRight(answer);
		String status[] = sentenceFormation.getLessonStatus().getAttribute("class").split(" ");
		Assert.assertEquals(status[status.length-1], "true");
	}
	
	@Test
  	public void answerWrong() throws InterruptedException{
		sentenceFormation.answerWrong(answer);
		String status[] = sentenceFormation.getLessonStatus().getAttribute("class").split(" ");
		Assert.assertEquals(status[status.length-1], "false");
	}
	
	@AfterMethod
  	public void after() {
  		driver.quit();
  	}
}

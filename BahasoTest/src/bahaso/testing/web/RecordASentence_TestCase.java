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
import bahaso.testing.webElement.RecordASentence;

public class RecordASentence_TestCase extends General{
	LandingPage landingPage = null;
	RecordASentence recordASentence = null;
	HashMap<String, String> LoginData = new HashMap<String, String>();
	ArrayList<ArrayList<String>> choices = new ArrayList<ArrayList<String>>();
	ArrayList<String> choice = new ArrayList<String>();
	ArrayList<WebElement> buttonPage = new ArrayList<WebElement>();
	Object answer;
	

	@BeforeMethod
  	public void beforeMethod() {
	  driver = getDriver();
	  LoginData.put("email","reddev");
	  LoginData.put("password","mahendralubis");
	  landingPage = new LandingPage(driver);
	  recordASentence = new RecordASentence(driver);
	  landingPage.doLogin(LoginData);
	  driver.get(baseUrl + "/ngeadmin/previewCaseNewTab/56810b41938e8e7b148b4579");
	  
	  //Get Case ID
	  buttonPage = (ArrayList<WebElement>) driver.findElements(By.className("btn-page"));
	  
	  //Get Data from Database
	  MongoCollection<Document> table = db.getCollection("case");
	  BasicDBObject searchQuery = new BasicDBObject();
	  searchQuery.put("_id", new ObjectId(buttonPage.get(0).getAttribute("data-id")));
	  Document cursor = table.find(searchQuery).first();
	  
	  //Convert answer
	  answer = recordASentence.getAnswerData(cursor);
  	}
	
	@Test
  	public void answerRight() throws InterruptedException{
		recordASentence.answerRight(answer);
		String status[] = recordASentence.getLessonStatus().getAttribute("class").split(" ");
		Assert.assertEquals(status[status.length-1], "true");
	}
	
	@Test
  	public void answerWrong() throws InterruptedException{
		recordASentence.answerWrong(answer);
		String status[] = recordASentence.getLessonStatus().getAttribute("class").split(" ");
		Assert.assertEquals(status[status.length-1], "false");
	}
	
	@AfterMethod
  	public void after() {
  		driver.quit();
  	}
}

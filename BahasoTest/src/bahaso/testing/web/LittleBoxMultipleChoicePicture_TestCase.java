package bahaso.testing.web;

import java.util.ArrayList;
import java.util.HashMap;

import org.bson.Document;
import org.bson.types.ObjectId;
import org.junit.Before;
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
import bahaso.testing.webElement.LittleBoxMultipleChoicePicture;

public class LittleBoxMultipleChoicePicture_TestCase extends General{
	LandingPage landingPage = null;
	LittleBoxMultipleChoicePicture littleBoxMultipleChoicePicture = null;
	HashMap<String, String> LoginData = new HashMap<String, String>();
	ArrayList<ArrayList<String>> choices = new ArrayList<ArrayList<String>>();
	ArrayList<String> choice = new ArrayList<String>();
	ArrayList<WebElement> buttonPage = new ArrayList<WebElement>();
	Object answer;
	
	@Before
	public void before(){
		for(int i=0;i<6;i++){
			choice.add("is");
			choice.add("am");
			choice.add("are");
			choices.add(choice);
			choice.clear();
		}
	}
	
	@BeforeMethod
  	public void beforeMethod() {
	  driver = getDriver();
	  LoginData.put("email","reddev");
	  LoginData.put("password","mahendralubis");
	  landingPage = new LandingPage(driver);
	  littleBoxMultipleChoicePicture = new LittleBoxMultipleChoicePicture(driver);
	  landingPage.doLogin(LoginData);
	  driver.get(baseUrl + "/ngeadmin/previewCaseNewTab/56838e1c938e8ec0348b4569");
	  
	  //Get Case ID
	  buttonPage = (ArrayList<WebElement>) driver.findElements(By.className("btn-page"));
	  
	  //Get Data from Database
	  MongoCollection<Document> table = db.getCollection("case");
	  BasicDBObject searchQuery = new BasicDBObject();
	  searchQuery.put("_id", new ObjectId(buttonPage.get(0).getAttribute("data-id")));
	  Document cursor = table.find(searchQuery).first();
	  
	  //Convert answer
	  answer = littleBoxMultipleChoicePicture.getAnswerData(cursor);
  	}
	
	@Test
  	public void answerRight() throws InterruptedException{
		littleBoxMultipleChoicePicture.answerRight(answer);
		String status[] = littleBoxMultipleChoicePicture.getLessonStatus().getAttribute("class").split(" ");
		Assert.assertEquals(status[status.length-1], "true");
	}
	
	@Test
  	public void answerWrong() throws InterruptedException{
		littleBoxMultipleChoicePicture.answerWrong(answer);
		String status[] = littleBoxMultipleChoicePicture.getLessonStatus().getAttribute("class").split(" ");
		Assert.assertEquals(status[status.length-1], "false");
	}
	
	@AfterMethod
  	public void after() {
  		driver.quit();
  	}
}

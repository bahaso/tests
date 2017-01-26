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
import bahaso.testing.webElement.LittleBoxMultipleChoice;

public class LittleBoxMultipleChoice_TestCase extends General{
	LandingPage landingPage = null;
	LittleBoxMultipleChoice littleBoxMultipleChoice = null;
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
	  LoginData.put("password","mahendra89");
	  landingPage = new LandingPage(driver);
	  littleBoxMultipleChoice = new LittleBoxMultipleChoice(driver);
	  landingPage.doLogin(LoginData);
	  driver.get(baseUrl + "/ngeadmin/previewCaseNewTab/5681033b938e8e7b148b4570");
	  
	  //Get Case ID
	  buttonPage = (ArrayList<WebElement>) driver.findElements(By.className("btn-page"));
	  
	  //Get Data from Database
	  MongoCollection<Document> table = db.getCollection("case");
	  BasicDBObject searchQuery = new BasicDBObject();
	  searchQuery.put("_id", new ObjectId(buttonPage.get(0).getAttribute("data-id")));
	  Document cursor = table.find(searchQuery).first();
	  
	  //Convert answer
	  answer = littleBoxMultipleChoice.getAnswerData(cursor);
  	}
	
	@Test
  	public void answerRight() throws InterruptedException{
		littleBoxMultipleChoice.answerRight(answer);
		String status[] = littleBoxMultipleChoice.getLessonStatus().getAttribute("class").split(" ");
		Assert.assertEquals(status[status.length-1], "true");
	}
	
	@Test
  	public void answerWrong() throws InterruptedException{
		littleBoxMultipleChoice.answerWrong(answer);
		String status[] = littleBoxMultipleChoice.getLessonStatus().getAttribute("class").split(" ");
		Assert.assertEquals(status[status.length-1], "false");
	}
	
	@AfterMethod
  	public void after() {
  		driver.quit();
  	}
}

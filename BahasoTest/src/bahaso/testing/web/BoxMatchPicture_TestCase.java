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
import bahaso.testing.webElement.BoxMatchPicture;
import bahaso.testing.webElement.LandingPage;

public class BoxMatchPicture_TestCase extends General{
	LandingPage landingPage = null;
	BoxMatchPicture boxMatchPicture = null;
	HashMap<String, String> LoginData = new HashMap<String, String>();
	ArrayList<WebElement> buttonPage = new ArrayList<WebElement>();
	Object answer;
	//String[] answer = {"five","eight","two","three"};
	

	@BeforeMethod
  	public void beforeMethod() {
	  driver = getDriver();
	  LoginData.put("email","reddev");
	  LoginData.put("password","mahendralubis");
	  landingPage = new LandingPage(driver);
	  boxMatchPicture = new BoxMatchPicture(driver);
	  landingPage.doLogin(LoginData);
	  driver.get(baseUrl + "/ngeadmin/previewCaseNewTab/56810f0e938e8e32528b456f");
	  
	  //Get Case ID
	  buttonPage = (ArrayList<WebElement>) driver.findElements(By.className("btn-page"));
	  
	  //Get Data from Database
	  MongoCollection<Document> table = db.getCollection("case");
	  BasicDBObject searchQuery = new BasicDBObject();
	  searchQuery.put("_id", new ObjectId(buttonPage.get(0).getAttribute("data-id")));
	  Document cursor = table.find(searchQuery).first();
	  
	  //Convert answer
	  answer = boxMatchPicture.getAnswerData(cursor);
  	}
	
	@Test
  	public void answerRight() throws InterruptedException{
		boxMatchPicture.answerRight(answer);
		String status[] = boxMatchPicture.getLessonStatus().getAttribute("class").split(" ");
		Assert.assertEquals(status[status.length-1], "true");
	}
	
	@Test
  	public void answerWrong() throws InterruptedException{
		boxMatchPicture.answerWrong(answer);
		String status[] = boxMatchPicture.getLessonStatus().getAttribute("class").split(" ");
		Assert.assertEquals(status[status.length-1], "false");
	}
	
	@AfterMethod
  	public void after() {
  		driver.quit();
  	}
}

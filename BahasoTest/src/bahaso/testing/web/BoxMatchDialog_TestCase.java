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
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import bahaso.testing.general.General;
import bahaso.testing.webElement.BoxMatchDialog;
import bahaso.testing.webElement.LandingPage;

public class BoxMatchDialog_TestCase extends General{
	LandingPage landingPage = null;
	BoxMatchDialog boxMatchDialog = null;
	HashMap<String, String> LoginData = new HashMap<String, String>();
	ArrayList<WebElement> buttonPage = new ArrayList<WebElement>();
	Object answer;
	

	@BeforeMethod
  	public void beforeMethod() {
	  driver = getDriver();
	  LoginData.put("email","reddev");
	  LoginData.put("password","mahendralubis");
	  landingPage = new LandingPage(driver);
	  boxMatchDialog = new BoxMatchDialog(driver);
	  landingPage.doLogin(LoginData);
	  driver.get(baseUrl + "/ngeadmin/previewCaseNewTab/5680eb93938e8e7b148b4568");
	  
	  //Get Case ID
	  buttonPage = (ArrayList<WebElement>) driver.findElements(By.className("btn-page"));
	  
	  //Get Data from Database
	  MongoCollection<Document> table = db.getCollection("case");
	  BasicDBObject searchQuery = new BasicDBObject();
	  searchQuery.put("_id", new ObjectId(buttonPage.get(0).getAttribute("data-id")));
	  Document cursor = table.find(searchQuery).first();
	  
	  //Convert answer
	  answer = boxMatchDialog.getAnswerData(cursor);
  	}
	
	@Test
  	public void answerRight() throws InterruptedException{
		boxMatchDialog.answerRight(answer);
		String status[] = boxMatchDialog.getLessonStatus().getAttribute("class").split(" ");
		Assert.assertEquals(status[status.length-1], "true");
	}
	
	@Test
  	public void answerWrong() throws InterruptedException{
		boxMatchDialog.answerWrong(answer);
		String status[] = boxMatchDialog.getLessonStatus().getAttribute("class").split(" ");
		Assert.assertEquals(status[status.length-1], "false");
	}
	
	@AfterMethod
  	public void after() {
  		driver.quit();
  	}
}	

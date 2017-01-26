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
import bahaso.testing.webElement.BoxMatchDissappearPicture;
import bahaso.testing.webElement.LandingPage;

public class BoxMatchDissappearPicture_TestCase extends General{
	LandingPage landingPage = null;
	BoxMatchDissappearPicture boxMatchDissappearPicture = null;
	HashMap<String, String> LoginData = new HashMap<String, String>();
	ArrayList<WebElement> buttonPage = new ArrayList<WebElement>();
	Object answer;
	//String[][] answer = {{"jam-10.png","jam-8.png","jam-3.png"},{"jam-9.png","jam-7.png","jam-1.png"}};
	

	@BeforeMethod
  	public void beforeMethod() {	
	  driver = getDriver();
	  LoginData.put("email","reddev");
	  LoginData.put("password","mahendralubis");
	  landingPage = new LandingPage(driver);
	  boxMatchDissappearPicture = new BoxMatchDissappearPicture(driver);
	  landingPage.doLogin(LoginData);
	  driver.get(baseUrl + "/ngeadmin/previewCaseNewTab/569776c2938e8e97658b456c");
	  
	  //Get Case ID
	  buttonPage = (ArrayList<WebElement>) driver.findElements(By.className("btn-page"));
	  
	  //Get Data from Database
	  MongoCollection<Document> table = db.getCollection("case");
	  BasicDBObject searchQuery = new BasicDBObject();
	  searchQuery.put("_id", new ObjectId(buttonPage.get(0).getAttribute("data-id")));
	  Document cursor = table.find(searchQuery).first();
	  
	  //Convert answer
	  answer = boxMatchDissappearPicture.getAnswerData(cursor);	  
  	}
	
	@Test
  	public void answerRight() throws InterruptedException{
		boxMatchDissappearPicture.answerRight(answer);
		String status[] = boxMatchDissappearPicture.getLessonStatus().getAttribute("class").split(" ");
		Assert.assertEquals(status[status.length-1], "true");
	}
	
	@Test
  	public void answerWrong() throws InterruptedException{
		boxMatchDissappearPicture.answerWrong(answer);
		String status[] = boxMatchDissappearPicture.getLessonStatus().getAttribute("class").split(" ");
		Assert.assertEquals(status[status.length-1], "false");
	}
	
	@AfterMethod
  	public void after() {
  		driver.quit();
  	}
}

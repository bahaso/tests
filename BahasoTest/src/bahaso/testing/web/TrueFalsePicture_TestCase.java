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
import bahaso.testing.webElement.TrueFalsePicture;

public class TrueFalsePicture_TestCase extends General{
	String instruction = "Tentukan benar atau salah berdasarkan gambar berikut ini";
	String question = "Apakah pernyataan ini benar?";
	String description = "Her name is Kevin";
	TrueFalsePicture TrueFalsePicture = null;
	LandingPage landingPage = null;
	HashMap<String, String> LoginData = new HashMap<String, String>();
	ArrayList<WebElement> buttonPage = new ArrayList<WebElement>();
	Object answer;
	
	@BeforeMethod
  	public void before() throws InterruptedException {
	  driver = getDriver();
	  LoginData.put("email","reddev");
	  LoginData.put("password","mahendra89");
	  TrueFalsePicture = new TrueFalsePicture(driver);
	  landingPage = new LandingPage(driver);
	  landingPage.doLogin(LoginData);
	  driver.get(baseUrl + "/ngeadmin/previewCaseNewTab/567929fb938e8e0a3a8b457a");
	  
	  //Get Case ID
	  buttonPage = (ArrayList<WebElement>) driver.findElements(By.className("btn-page"));
	  
	  //Get Data from Database
	  MongoCollection<Document> table = db.getCollection("case");
	  BasicDBObject searchQuery = new BasicDBObject();
	  searchQuery.put("_id", new ObjectId(buttonPage.get(0).getAttribute("data-id")));
	  Document cursor = table.find(searchQuery).first();
	  
	  //Convert answer
	  answer = TrueFalsePicture.getAnswerData(cursor);
  	}
	
	@Test
  	public void cekAllElement() throws InterruptedException{
		Thread.sleep(2000);
		Assert.assertEquals(TrueFalsePicture.getInstruction().getText(), instruction);
		Assert.assertEquals(TrueFalsePicture.getQuestion().getText(), question);
		Assert.assertEquals(TrueFalsePicture.getDescription().getText(), description);
	}
	
	@Test
  	public void answerRight() throws InterruptedException{
		TrueFalsePicture.answerRight(answer);
		String status[] = TrueFalsePicture.getLessonStatus().getAttribute("class").split(" ");
		Assert.assertEquals(status[status.length-1], "true");
	}
	
	@Test
  	public void answerWrong() throws InterruptedException{
		TrueFalsePicture.answerWrong(answer);
		String status[] = TrueFalsePicture.getLessonStatus().getAttribute("class").split(" ");
		Assert.assertEquals(status[status.length-1], "false");
	}
	
	@AfterMethod
  	public void after() {
  		driver.quit();
  	}
	
}

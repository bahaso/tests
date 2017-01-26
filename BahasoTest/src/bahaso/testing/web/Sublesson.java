package bahaso.testing.web;

import java.util.ArrayList;
import java.util.HashMap;

import org.bson.Document;
import org.bson.types.ObjectId;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.mongodb.BasicDBObject;
import com.mongodb.client.MongoCollection;

import bahaso.testing.general.General;
import bahaso.testing.webElement.*;

public class Sublesson extends General{
	ArrayList<WebElement> buttonPage = new ArrayList<WebElement>();
	LandingPage landingPage = null;
	LoginPage loginPage = null;
	answerLesson obj = null;
	HashMap<String, String> LoginData = new HashMap<String, String>();
	Object answer;
	
	public void getTypes(String val,WebDriver driver){
		Integer value = Integer.parseInt(val);
		if(value==2){
			obj = new SentenceFormation(driver);
		}else if(value==3){
			obj = new ListenRecord(driver);
		}else if(value==4){
			obj = new ListenRecordPicture(driver);
		}else if(value==5){
			obj = new ListenType(driver);
		}else if(value==7){
			obj = new ListenSelectPicture(driver);
		}else if(value==8){
			obj = new ListenSelectSingleBox(driver);
		}else if(value==10){
			obj = new BoxMatchPicture(driver);
		}else if(value==11){
			obj = new BoxMatchListen(driver);
		}else if(value==13){
			obj = new ListenSelectMultipleBox(driver);
		}else if(value==14){
			obj = new LostWordListen(driver);
		}else if(value==15){
			//obj = new LostWordTell(driver);
		}else if(value==16){
			obj = new ListenAndOrganize(driver);
		}else if(value==19){
			obj = new LittleBoxMultipleChoice(driver);
		}else if(value==20){
			obj = new BoxMatchDissappear(driver);
		}else if(value==21){
			obj = new Comprehension(driver);
		}else if(value==22){
			obj = new BoxMatchSentence(driver);
		}else if(value==25){
			obj = new TrueFalsePicture(driver);
		}else if(value==26){
			obj = new BoxMatchList(driver);
		}else if(value==27){
			obj = new LostWordType(driver);
		}else if(value==28){
			obj = new BoxMatchDissappearPicture(driver);
		}else if(value==30){
			obj = new LittleBoxMultipleChoice(driver);
		}else if(value==31){
			obj = new DragMultipleChoice(driver);
		}else if(value==35){
			obj = new BoxMatchParagraph(driver);
		}else if(value==36){
			obj = new PictureMultipleChoice(driver);
		}else if(value==37){
			obj = new BoxMatchDialog(driver);
		}else if(value==39){
			obj = new TrueFalseListen(driver);
		}else if(value==40){
			obj = new TrueFalseSentence(driver);
		}else if(value==41){
			obj = new VideoAnswerCase(driver);
		}else if(value==44){
			obj = new BoxMatchListPicture(driver);
		}else if(value==45){
			obj = new LittleBoxMultipleChoicePicture(driver);
		}else if(value==46){
			obj = new RecordASentence(driver);
		}
		return;
	}
	

	@BeforeMethod
  	public void beforeMethod() {
	  driver = getDriver();
	  LoginData.put("email","reddev");
	  LoginData.put("password","mahendra89");
	  landingPage = new LandingPage(driver);
	  loginPage = new LoginPage(driver);
	  //obj = new VideoAnswerCase(driver);
	  landingPage.doLogin(LoginData);
	  //driver.get(baseUrl + "/ngeadmin/previewCaseNewTab/5680bf66938e8ec1788b4567");
  	}
	
	@Test  
  	public void Simulation(){
//		try {
//			Thread.sleep(3000);
//			System.out.println(loginPage.getLessonListA1().size());
//			for(int i=0;i<loginPage.getLessonList().size();i++){
//				loginPage.getLessonListA1().get(i).click();
//				Thread.sleep(3000);
//			}
//			driver.get(baseUrl);
//			Thread.sleep(3000);
//			loginPage.getLevelButton().get(1).click();
//			Thread.sleep(3000);
//			for(int i=0;i<loginPage.getLessonListA2().size();i++){
//				loginPage.getLessonListA2().get(i).click();
//				Thread.sleep(3000);
//			}
//			driver.get(baseUrl);
//			Thread.sleep(3000);
//			loginPage.getLevelButton().get(2).click();
//			Thread.sleep(3000);
//			for(int i=0;i<loginPage.getLessonListB1().size();i++){
//				loginPage.getLessonListB1().get(i).click();
//				Thread.sleep(3000);
//			}
//			driver.get(baseUrl);
//			Thread.sleep(3000);
//			loginPage.getLevelButton().get(3).click();
//			Thread.sleep(3000);
//			for(int i=0;i<loginPage.getLessonListB2().size();i++){
//				loginPage.getLessonListB2().get(i).click();
//				Thread.sleep(3000);
//			}
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		//String status[] = boxMatchSentence.getLessonStatus().getAttribute("class").split(" ");
//		//Assert.assertEquals(status[status.length-1], "true");
	}
	
	@Test  
  	public void Simulation2(){
		try {
			Integer level = 1;
			Integer lesson = 3;
			Integer sublesson = 1;
			int value = ((lesson-1)/3*2)+lesson;
			loginPage.getLevelButton().get(level-1).click();
			Thread.sleep(3000);
			loginPage.getLessonListA1(level-1).get(lesson-1).click();
			Thread.sleep(3000);
			loginPage.getSubLesson(level-1,value).get(sublesson-1).click();
			Thread.sleep(5000);
			while(true){
				workPractice();
				Thread.sleep(3000);
				WebElement next = driver.findElement(By.id("next-button"));
				next.click();
			}
		}catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
	}
	
	public void workPractice(){
		WebElement buttonFinish = driver.findElement(By.className("btn-finish"));
		WebElement buttonNext = driver.findElement(By.className("btn-next"));
		try {
			buttonPage = (ArrayList<WebElement>) driver.findElements(By.className("btn-page"));
			for(int i=0;i<buttonPage.size();i++){
				Thread.sleep(3000);
				if(buttonPage.get(i).getAttribute("data-type").equals("case")==false){
					buttonNext.click();
				}else{
					System.out.println(buttonPage.get(i).getText());
					MongoCollection<Document> table = db.getCollection("case");
					BasicDBObject searchQuery = new BasicDBObject();
					searchQuery.put("_id", new ObjectId(buttonPage.get(i).getAttribute("data-id")));
					Document cursor = table.find(searchQuery).first();
					getTypes(cursor.get("type").toString(), driver);
					answer = obj.getAnswerData(cursor);
					obj.answerRight(answer);
					Thread.sleep(5000);
					if(i<buttonPage.size()-1)buttonNext.click();
					else buttonFinish.click();
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	@AfterMethod
  	public void after() {
  		//driver.quit();
  	}
}

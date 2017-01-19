package bahaso.testing.web;

import java.awt.print.Printable;
import java.util.ArrayList;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import bahaso.testing.general.General;
import bahaso.testing.webElement.*;

public class Sublesson extends General{
	LandingPage landingPage = null;
	LoginPage loginPage = null;
	answerLesson obj = null;
	HashMap<String, String> LoginData = new HashMap<String, String>();
	String[] answer = {"Good morning, Kevin."};
	
	public void getTypes(Integer value,WebDriver driver){
		if(value==2){
			obj = new SentenceFormation(driver);
		}else if(value==11){
			obj = new BoxMatchListen(driver);
		}else if(value==22){
			obj = new BoxMatchSentence(driver);
		}else if(value==35){
			obj = new BoxMatchParagraph(driver);
		}else if(value==26){
			obj = new BoxMatchList(driver);
		}else if(value==10){
			obj = new BoxMatchPicture(driver);
		}else if(value==15){
			//obj = new LostWordTell(driver);
		}else if(value==14){
			obj = new LostWordListen(driver);
		}else if(value==27){
			obj = new LostWordType(driver);
		}else if(value==8){
			obj = new ListenSelectSingleBox(driver);
		}else if(value==13){
			obj = new ListenSelectMultipleBox(driver);
		}else if(value==36){
			obj = new PictureMultipleChoice(driver);
		}else if(value==7){
			obj = new ListenSelectPicture(driver);
		}else if(value==4){
			obj = new ListenRecordPicture(driver);
		}else if(value==3){
			obj = new ListenRecord(driver);
		}else if(value==5){
			//obj = new Listen(driver);
		}else if(value==30){
			obj = new LittleBoxMultipleChoice(driver);
		}else if(value==31){
			obj = new DragMultipleChoice(driver);
		}else if(value==37){
			obj = new BoxMatchDialog(driver);
		}else if(value==28){
			obj = new BoxMatchDissappearPicture(driver);
		}else if(value==20){
			obj = new BoxMatchDissappear(driver);
		}else if(value==16){
			obj = new ListenAndOrganize(driver);
		}else if(value==21){
			//obj = new LittleBoxMultipleChoice(driver);
		}else if(value==19){
			obj = new LittleBoxMultipleChoice(driver);
		}
	}
	

	@BeforeMethod
  	public void beforeMethod() {
	  driver = getDriver();
	  LoginData.put("email","reddev");
	  LoginData.put("password","mahendralubis");
	  landingPage = new LandingPage(driver);
	  loginPage = new LoginPage(driver);
	  obj = new VideoAnswerCase(driver);
	  landingPage.doLogin(LoginData);
	  //driver.get(baseUrl + "/ngeadmin/previewCaseNewTab/5680bf66938e8ec1788b4567");
  	}
	
	@Test  
  	public void Simulation(){
		try {
			Thread.sleep(3000);
			System.out.println(loginPage.getLessonListA1().size());
			for(int i=0;i<loginPage.getLessonListA1().size();i++){
				loginPage.getLessonListA1().get(i).click();
				Thread.sleep(3000);
			}
			driver.get(baseUrl);
			Thread.sleep(3000);
			loginPage.getLevelButton().get(1).click();
			Thread.sleep(3000);
			for(int i=0;i<loginPage.getLessonListA2().size();i++){
				loginPage.getLessonListA2().get(i).click();
				Thread.sleep(3000);
			}
			driver.get(baseUrl);
			Thread.sleep(3000);
			loginPage.getLevelButton().get(2).click();
			Thread.sleep(3000);
			for(int i=0;i<loginPage.getLessonListB1().size();i++){
				loginPage.getLessonListB1().get(i).click();
				Thread.sleep(3000);
			}
			driver.get(baseUrl);
			Thread.sleep(3000);
			loginPage.getLevelButton().get(3).click();
			Thread.sleep(3000);
			for(int i=0;i<loginPage.getLessonListB2().size();i++){
				loginPage.getLessonListB2().get(i).click();
				Thread.sleep(3000);
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//String status[] = boxMatchSentence.getLessonStatus().getAttribute("class").split(" ");
		//Assert.assertEquals(status[status.length-1], "true");
	}
	
	@Test  
  	public void Simulation2(){
		try {
			Integer level = 1;
			Integer lesson = 4;
			Integer sublesson = 2;	
			int value = ((lesson-1)/3*2)+lesson;
			System.out.println(value);
			System.out.println(loginPage.getSubLesson(value).size());
			loginPage.getLevelButton().get(level-1).click();
			Thread.sleep(3000);
			loginPage.getLessonListA1().get(lesson-1).click();
			Thread.sleep(3000);
			loginPage.getSubLesson(value).get(sublesson-1).click();
			Thread.sleep(5000);
		}catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
	}
	
	
	@Test  
  	public void answerRight(){
		obj.answerRight(answer);
		//String status[] = boxMatchSentence.getLessonStatus().getAttribute("class").split(" ");
		//Assert.assertEquals(status[status.length-1], "true");
	}
	
	@Test
  	public void answerWrong(){
		obj.answerWrong(answer);
		//String status[] = boxMatchSentence.getLessonStatus().getAttribute("class").split(" ");
		//Assert.assertEquals(status[status.length-1], "false");
	}
	
	@AfterMethod
  	public void after() {
  		driver.quit();
  	}
}

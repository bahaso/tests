package bahaso.testing.web;

import java.util.HashMap;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import bahaso.testing.general.General;
import bahaso.testing.webElement.*;

public class Sublesson extends General{
	LandingPage landingPage = null;
	answerLesson obj = null;
	HashMap<String, String> LoginData = new HashMap<String, String>();
	String[] answer = {"Their names","are Vince","and Derek"};
	

	@BeforeMethod
  	public void beforeMethod() {
	  driver = getDriver();
	  LoginData.put("email","reddev");
	  LoginData.put("password","mahendralubis");
	  landingPage = new LandingPage(driver);
	  obj = new SentenceFormation(driver);
	  landingPage.doLogin(LoginData);
	  driver.get(baseUrl + "/ngeadmin/previewCaseNewTab/567926da938e8e6c5f8b4572");
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

package bahaso.testing.web;

import java.util.ArrayList;
import java.util.HashMap;

import org.junit.Before;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import bahaso.testing.general.General;
import bahaso.testing.webElement.LandingPage;
import bahaso.testing.webElement.LittleBoxMultipleChoice;

public class LittleBoxMultipleChoice_TestCase extends General{
	LandingPage landingPage = null;
	LittleBoxMultipleChoice littleBoxMultipleChoice = null;
	HashMap<String, String> LoginData = new HashMap<String, String>();
	ArrayList<ArrayList<String>> choices = new ArrayList<ArrayList<String>>();
	ArrayList<String> choice = new ArrayList<String>();
	String[] answer = {"is","are","is","is","am","are"};
	
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
	  littleBoxMultipleChoice = new LittleBoxMultipleChoice(driver);
	  landingPage.doLogin(LoginData);
	  driver.get(baseUrl + "/ngeadmin/previewCaseNewTab/5681033b938e8e7b148b4570");
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

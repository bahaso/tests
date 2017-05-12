package bahaso.testing.android;

import java.util.ArrayList;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import bahaso.testing.androidElement.BoxMatchList;
import bahaso.testing.androidElement.Home;
import bahaso.testing.androidElement.SplashScreen;
import bahaso.testing.general.mobileGeneral;

public class BoxMatchList_test extends mobileGeneral{
	SplashScreen splashScreen;
	Home home;
	BoxMatchList boxMatchList;
	ArrayList<String> answers = new ArrayList<String>();
	
	@BeforeClass
	public void beforeclass(){
		answers.add("is");
		answers.add("is");
		answers.add("is");
		answers.add("are");
	}
	
	@BeforeMethod
	public void beforeMethod(){
		try {
		startEngine();
		splashScreen = new SplashScreen(driver);
		home = new Home(driver);
		boxMatchList = new BoxMatchList(driver);
		Thread.sleep(4000);
		action.press(home.getAllTypeCase(), 0, 0).release().perform();
		Thread.sleep(4000);
		driver.findElementById("com.bahaso:id/radioButtonIntroAndGeneralCase").click();
		driver.findElementById("com.bahaso:id/buttonLoadTestingCase").click();
		Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void test1(){
		try {
			boxMatchList.answerRight(answers);
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void test2(){
		try {
			boxMatchList.answerWrong(answers);
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@AfterMethod
	public void afterMethod(){	
		driver.quit();
	}
}

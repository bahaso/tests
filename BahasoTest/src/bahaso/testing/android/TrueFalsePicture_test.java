package bahaso.testing.android;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import bahaso.testing.androidElement.Home;
import bahaso.testing.androidElement.SplashScreen;
import bahaso.testing.androidElement.TrueFalsePicture;
import bahaso.testing.general.mobileGeneral;

public class TrueFalsePicture_test extends mobileGeneral{
	
	SplashScreen splashScreen;
	Home home;
	TrueFalsePicture trueFalsePicture;
	Boolean answer;
	
	@BeforeClass
	public void beforeclass(){
		answer = false;
	}
	
	@BeforeMethod
	public void beforeMethod(){
		try {
		startEngine();
		splashScreen = new SplashScreen(driver);
		home = new Home(driver);
		trueFalsePicture = new TrueFalsePicture(driver);
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
			trueFalsePicture.answerRight(answer);
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void test2(){
		try {
			trueFalsePicture.answerWrong(answer);
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

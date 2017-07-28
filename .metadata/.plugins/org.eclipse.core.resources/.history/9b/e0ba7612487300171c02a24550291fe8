package bahaso.testing.android;

import java.util.ArrayList;

import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import bahaso.testing.androidElement.ChooseCourse;
import bahaso.testing.androidElement.Home;
import bahaso.testing.androidElement.LittleBoxMultipleChoice;
import bahaso.testing.androidElement.SplashScreen;
import bahaso.testing.general.mobileGeneral;

public class LittleBoxMultipleChoice_test extends mobileGeneral{
	SplashScreen splashScreen;
	Home home;
	LittleBoxMultipleChoice littleBoxMultipleChoice;
	
	@BeforeMethod
	public void beforeMethod(){
		try {
		startEngine();
		splashScreen = new SplashScreen(driver);
		home = new Home(driver);
		littleBoxMultipleChoice = new LittleBoxMultipleChoice(driver);
		Thread.sleep(4000);
		action.press(home.getAllTypeCase(), 0, 0).release().perform();
		Thread.sleep(4000);
		driver.findElementById("com.bahaso:id/radioButtonIntroAndGeneralCase").click();
		driver.findElementById("com.bahaso:id/buttonLoadTestingCase").click();
		Thread.sleep(4000);
		ArrayList<WebElement> btn = (ArrayList<WebElement>) driver.findElementsById("com.bahaso:id/btnCaseNumber");
		btn.get(0).click();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void test1(){
		try {
//			System.out.println(littleBoxMultipleChoice.getBtnSelection().size());
//			for(int i=0;i<littleBoxMultipleChoice.getBtnSelection().size();i++){
//				littleBoxMultipleChoice.getBtnSelection().get(i).click();
			}
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

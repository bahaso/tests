package bahaso.testing.android;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import bahaso.testing.androidElement.ChooseCourse;
import bahaso.testing.androidElement.Home;
import bahaso.testing.androidElement.Login;
import bahaso.testing.androidElement.SplashScreen;
import bahaso.testing.general.mobileGeneral;

public class ChooseCourse_test extends mobileGeneral{
	SplashScreen splashScreen;
	Home home;
	ChooseCourse chooseCourse;
	
	@BeforeMethod
	public void beforeMethod(){
		try {
		startEngine();
		splashScreen = new SplashScreen(driver);
		home = new Home(driver);
		chooseCourse = new ChooseCourse(driver);
		Thread.sleep(4000);
		action.press(home.getCourse(), 0, 0).release().perform();
		Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void choose_tab_course_1(){
		try {
			//System.out.println(chooseCourse.getBtnPlacement().getText());
//			chooseCourse.getTabCourse().click();
			Thread.sleep(4000);
//			for(int i=0;i<chooseCourse.getTabCourse().size();i++){
//				chooseCourse.getTabCourse().get(i).click();
//				Thread.sleep(4000);
//			}
			chooseCourse.getTabCourse("Perancis");
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

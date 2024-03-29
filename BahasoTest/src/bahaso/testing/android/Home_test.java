package bahaso.testing.android;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import bahaso.testing.androidElement.Home;
import bahaso.testing.androidElement.Login;
import bahaso.testing.androidElement.Setting;
import bahaso.testing.androidElement.SplashScreen;
import bahaso.testing.general.mobileGeneral;

public class Home_test extends mobileGeneral{
	SplashScreen splashScreen;
	Login login;
	Home home;
	Setting setting;
	
	@BeforeMethod
	public void beforeMethod(){
		try {
		startEngine();
		splashScreen = new SplashScreen(driver);
		login = new Login(driver);
		home = new Home(driver);
		setting = new Setting(driver);
		Thread.sleep(4000);
//		splashScreen.getLoginEmailButton().click();
//		Thread.sleep(4000);
//		login.getInputEmail().sendKeys("ademahendra@bahaso.com");
//		login.getInputPassword().sendKeys("mahendra89");
//		driver.hideKeyboard();
//		Thread.sleep(4000);
//		action.press(login.getBtnLogin(), 0, 0).release().perform();
//		Thread.sleep(4000);
//		action.press(home.getCourse(), 0, 0).release().perform();
//		Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void go_to_choose_course_1(){
		try {
			action.press(home.getCourse(), 0, 0).release().perform();
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void choose_tab_1(){
		try {
			for(int i=0;i<home.getTab().size();i++){
				action.press(home.getTab().get(i), 0, 0).release().perform();
				Thread.sleep(4000);
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void go_to_setting_page(){
		try {
			home.getBtnSetting().click();
			//action.press(home.getBtnSetting(), 0, 0).release().perform();
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void logout(){
		try {
			home.getBtnSetting().click();
			setting.getMenu().get(7).click();
			setting.getPopUpErrorMessageBtnYes().click();
			//action.press(home.getBtnSetting(), 0, 0).release().perform();
			Thread.sleep(4000);
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

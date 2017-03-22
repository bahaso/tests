package bahaso.testing.android;

import org.testng.annotations.BeforeMethod;

import bahaso.testing.androidElement.Home;
import bahaso.testing.androidElement.Login;
import bahaso.testing.androidElement.SplashScreen;
import bahaso.testing.general.mobileGeneral;

public class ChooseCourse_test extends mobileGeneral{
	SplashScreen splashScreen;
	Login login;
	Home home;
	
	@BeforeMethod
	public void beforeMethod(){
		try {
		startEngine();
		splashScreen = new SplashScreen(driver);
		login = new Login(driver);
		home = new Home(driver);
		Thread.sleep(10000);
		splashScreen.getLoginEmailButton().click();
		Thread.sleep(4000);
		login.getInputEmail().sendKeys("ademahendra@bahaso.com");
		login.getInputPassword().sendKeys("mahendra89");
		driver.hideKeyboard();
		Thread.sleep(4000);
		action.press(login.getBtnLogin(), 0, 0).release().perform();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

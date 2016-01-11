package bahaso;

import java.net.MalformedURLException;

import org.testng.annotations.Test;

import mz.driver.MZAndroidDriver;
import mz.page.mobile.LandingPage;
import mz.page.mobile.LoginPage;

public class LoginTest {
	
	MZAndroidDriver driver = null;
	
	@Test
	public void doLogin() throws MalformedURLException, InterruptedException 
	{
		driver = new MZAndroidDriver();
		LandingPage landingPage = new LandingPage(driver.getDriver());
		landingPage.ClickButtonLogin();
		LoginPage loginPage = new LoginPage(driver.getDriver());
		loginPage.SetTextEmailOrUsername("enzpart");
		loginPage.SetTextPassword("larabel123");
		loginPage.ClickButtonMasuk();
	}
	
}

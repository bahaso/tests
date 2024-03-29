package bahaso.testing.android;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import bahaso.testing.androidElement.Gold;
import bahaso.testing.androidElement.Home;
import bahaso.testing.androidElement.Voucher;
import bahaso.testing.general.mobileGeneral;

public class Gold_test extends mobileGeneral{
	Home home;
	Gold gold;
	
	@BeforeMethod
	public void beforeMethod(){
		try {
		startEngine();
		home = new Home(driver);
		gold = new Gold(driver);
		Thread.sleep(4000);
		home.getTab().get(0).click();
		Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void check_price(){
		gold.getAddGold().sendKeys("22");
		driver.hideKeyboard();
		Assert.assertEquals(gold.getPrice().getText(), "IDR 220,000", "Harga tidak sama");
	}
	
	@AfterMethod
	public void afterMethod(){	
		driver.quit();
	}
}

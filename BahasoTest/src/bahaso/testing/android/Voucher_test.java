package bahaso.testing.android;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import bahaso.testing.androidElement.Home;
import bahaso.testing.androidElement.Voucher;
import bahaso.testing.general.mobileGeneral;

public class Voucher_test extends mobileGeneral{
	Home home;
	Voucher voucher;
	
	@BeforeMethod
	public void beforeMethod(){
		try {
		startEngine();
		home = new Home(driver);
		voucher = new Voucher(driver);
		Thread.sleep(4000);
		home.getTab().get(2).click();
		Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//input Voucher just contains a-zA-z and 1-9
	@Test
	public void inputVoucher_is_alphanumeric(){
		String pattern = "^[a-zA-Z0-9]*$";
		voucher.getInputVoucher().sendKeys("aaa aaaa 123");
		System.out.println(voucher.getInputVoucher().getText().matches(pattern));
		Assert.assertEquals(voucher.getInputVoucher().getText().matches(pattern), true, "input voucher code tidak alphanumeric");
	}
	
	@AfterMethod
	public void afterMethod(){	
		driver.quit();
	}
}

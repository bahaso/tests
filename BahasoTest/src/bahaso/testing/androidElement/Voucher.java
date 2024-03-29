package bahaso.testing.androidElement;

import org.openqa.selenium.WebElement;

import io.appium.java_client.android.AndroidDriver;

public class Voucher {
	AndroidDriver driver;
	
	public Voucher(AndroidDriver driver){
		this.driver = driver;
	}
	
	public WebElement getInputVoucher(){
		return driver.findElementById("com.bahaso:id/et_voucher");
	}
	
	public WebElement getButtonVoucher(){
		return driver.findElementById("com.bahaso:id/layout_btn_payment_method");
	}
}

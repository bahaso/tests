package bahaso.testing.androidElement;

import org.openqa.selenium.WebElement;

import io.appium.java_client.android.AndroidDriver;

public class Gold {
	AndroidDriver driver;
	
	public Gold(AndroidDriver driver){
		this.driver = driver;
	}
	
	public WebElement getGold(){
		return driver.findElementById("com.bahaso:id/tv_gold");
	}
	
	public WebElement getPaymentHistory(){
		return driver.findElementById("com.bahaso:id/tv_gold");
	}
	
	public WebElement getUseVoucher(){
		return driver.findElementById("com.bahaso:id/pny_kode_voucher");
	}
	
	public WebElement getAddGold(){
		return driver.findElementById("com.bahaso:id/et_gold");
	}
	
	public WebElement getBtnPayment(){
		return driver.findElementById("com.bahaso:id/layout_btn_payment_method");
	}
}
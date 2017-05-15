package bahaso.testing.androidElement;

import java.util.ArrayList;

import org.openqa.selenium.WebElement;

import io.appium.java_client.android.AndroidDriver;

public class Gold {
	AndroidDriver driver;
	
	public Gold(AndroidDriver driver){
		this.driver = driver;
	}
	
	public void scrollToById(String ID){
		ArrayList<WebElement> Element = (ArrayList<WebElement>) driver.findElementsById(ID);
		while(Element.size()==0){
			Element = (ArrayList<WebElement>) driver.findElementsById(ID);
			WebElement screen = driver.findElementByClassName("android.widget.FrameLayout");
			int xStart = screen.getLocation().getX() + screen.getSize().width/2;
			int yStart = screen.getLocation().getY() + screen.getSize().height-50;
			driver.swipe(xStart, yStart, xStart, yStart-100, 1000);
		}
	}
	
	public WebElement getGold(){
		String ID = "com.bahaso:id/tv_gold";
		scrollToById(ID);
		return driver.findElementById(ID);
	}
	
	public WebElement getPaymentHistory(){
		String ID = "com.bahaso:id/layout_payment_history";
		scrollToById(ID);
		return driver.findElementById(ID);
	}
	
	public WebElement getCheckButton(){
		String ID = "com.bahaso:id/checkbox_voucher";
		scrollToById(ID);
		return driver.findElementById(ID);
	}
	
	public WebElement getVoucherForm(){
		String ID = "com.bahaso:id/et_voucher";
		scrollToById(ID);
		return driver.findElementById(ID);
	}
	
	public WebElement getVoucherButton(){
		String ID = "com.bahaso:id/layout_btn_redeem_voucher";
		scrollToById(ID);
		return driver.findElementById(ID);
	}
	
	public WebElement getAddGold(){
		String ID = "com.bahaso:id/et_gold";
		scrollToById(ID);
		return driver.findElementById(ID);
	}
	
	public WebElement getPrice(){
		String ID = "com.bahaso:id/tv_price";
		scrollToById(ID);
		return driver.findElementById(ID);
	}
	
	public WebElement getBtnPayment(){
		String ID = "com.bahaso:id/layout_btn_payment_method";
		scrollToById(ID);
		return driver.findElementById(ID);
	}
}

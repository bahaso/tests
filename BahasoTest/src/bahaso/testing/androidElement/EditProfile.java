package bahaso.testing.androidElement;

import java.lang.reflect.Array;
import java.time.temporal.WeekFields;
import java.util.ArrayList;

import org.openqa.selenium.WebElement;

import io.appium.java_client.android.AndroidDriver;

public class EditProfile {
	AndroidDriver driver;
	
	public EditProfile(AndroidDriver driver){
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
	
	public ArrayList<WebElement> searcErrorMessage(String ID){
			ArrayList<WebElement> Element = (ArrayList<WebElement>) driver.findElementsById(ID);
			return Element;
			//System.out.println(Element.size());
			//break;
//			int xStart = screen.getLocation().getX() + screen.getSize().width/2;
//			int yStart = screen.getLocation().getY() + screen.getSize().height-50;
//			driver.swipe(xStart, yStart, xStart, yStart-100, 1000);
	}
	
	//Button
	
	public WebElement getButtonSave(){
		String ID = "com.bahaso:id/layout_btn_simpan_edit_profile";
		scrollToById(ID);
		return driver.findElementById(ID);
	}
	
	//Edit Text
	
	public WebElement getInputFirstname(){
		String ID = "com.bahaso:id/input_firstname";
		scrollToById(ID);
		return driver.findElementById(ID);
	}
	
	public WebElement getInputLastname(){
		String ID = "com.bahaso:id/input_lastname";
		scrollToById(ID);
		return driver.findElementById(ID);
	}
	
	public WebElement getRadioButtonMale(){
		String ID = "com.bahaso:id/rb_male";
		scrollToById(ID);
		return driver.findElementById(ID);
	}
	
	public WebElement getRadioButtonFemale(){
		String ID = "com.bahaso:id/rb_female";
		scrollToById(ID);
		return driver.findElementById(ID);
	}
	
	public WebElement getInputBirthdate(){
		String ID = "com.bahaso:id/input_dob";
		scrollToById(ID);
		return driver.findElementById(ID);
	}
	
	public WebElement getInputCountry(){
		String ID = "com.bahaso:id/tv_input_country";
		scrollToById(ID);
		return driver.findElementById(ID);
	}
	
	public WebElement getInputCallingCode(){
		String ID = "com.bahaso:id/tv_calling_code";
		scrollToById(ID);
		return driver.findElementById(ID);
	}
	
	public WebElement getInputPhoneNumber(){
		String ID = "com.bahaso:id/et_phone_number";
		scrollToById(ID);
		return driver.findElementById(ID);
	}
	
	public WebElement getInputJob(){
		String ID = "com.bahaso:id/input_job";
		scrollToById(ID);
		return driver.findElementById(ID);
	}
	
	public WebElement getInputAboutMe(){
		String ID = "com.bahaso:id/input_about_me";
		scrollToById(ID);
		return driver.findElementById(ID);
	}
	
	public WebElement getMessageError(){
		String ID = "com.bahaso:id/textinput_error";
		scrollToById(ID);
		return driver.findElementById(ID);
	}
	
	public ArrayList<WebElement> getMessagesError(){
		String ID = "com.bahaso:id/textinput_error";
		scrollToById(ID);
		return (ArrayList<WebElement>) driver.findElementsById(ID);
	}
	
	
}

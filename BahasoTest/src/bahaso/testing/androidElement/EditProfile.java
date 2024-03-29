package bahaso.testing.androidElement;

import java.lang.reflect.Array;
import java.time.temporal.WeekFields;
import java.util.ArrayList;

import org.openqa.selenium.WebElement;

import com.gargoylesoftware.htmlunit.javascript.host.Element;

import io.appium.java_client.android.AndroidDriver;

public class EditProfile {
	AndroidDriver driver;
	
	public EditProfile(AndroidDriver driver){
		this.driver = driver;
	}
	
	public void scroll(){
		WebElement sizeScreen = driver.findElementByClassName("android.widget.FrameLayout");
		int middleX = sizeScreen.getLocation().getX() + sizeScreen.getSize().width/2;
		int bottomY = sizeScreen.getLocation().getY() + sizeScreen.getSize().height-50;
		int topY = sizeScreen.getLocation().getY()+100;
		
		driver.swipe(middleX, bottomY, middleX, bottomY-100, 2000);
		driver.swipe(middleX, 150, middleX, 200, 2000);
	}
	
	public WebElement scrollToById(String ID){
		String top = "com.bahaso:id/input_firstname";
		String bottom = "com.bahaso:id/layout_btn_simpan_edit_profile";
		int direction = 0;
		int size = 0;
		WebElement sizeScreen = driver.findElementByClassName("android.widget.FrameLayout");
		
		int middleX = sizeScreen.getLocation().getX() + sizeScreen.getSize().width/2;
		int bottomY = sizeScreen.getLocation().getY() + sizeScreen.getSize().height-50;
		int topY = sizeScreen.getLocation().getY()+150;
		
		do{
			ArrayList<WebElement> topElement = (ArrayList<WebElement>) driver.findElementsById(top);
			ArrayList<WebElement> bottomElement = (ArrayList<WebElement>) driver.findElementsById(bottom);
			ArrayList<WebElement> Elements = (ArrayList<WebElement>) driver.findElementsById(ID);
			size = Elements.size();
			if(size>0){
				System.out.println("Found it : " + ID);
				return Elements.get(0);
			}
			if(direction==0 && bottomElement.size()==0){
				System.out.println("Scroll down");
				driver.swipe(middleX, bottomY, middleX, bottomY-100, 500);
			}else if(direction==0 && bottomElement.size()>0){
				System.out.println("found bottom, scroll up");
				direction=1;
				driver.swipe(middleX, topY, middleX, topY+100, 500);
			}else if(direction==1 && topElement.size()==0){
				System.out.println("Scroll up");
				driver.swipe(middleX, topY, middleX, topY+100, 500);
			}else if(direction==1 && topElement.size()>0){
				System.out.println("No Found");
				break;
			}
			Elements.clear();
			topElement.clear();
			bottomElement.clear();
		}while(size==0);
		return driver.findElementById(ID);
	}
	
	public String searcErrorMessage(String err){
			ArrayList<WebElement> Element = (ArrayList<WebElement>) driver.findElementsById("com.bahaso:id/textinput_error");
			for(int i=0;i<Element.size();i++){
				if(Element.get(i).getText().equals(err)){
					return err;
				}
			}
			return null;
	}
	
	//Button
	
	public WebElement getButtonSave(){
		String ID = "com.bahaso:id/layout_btn_simpan_edit_profile";
		return scrollToById(ID);
	}
	
	//Edit Text
	
	public WebElement getInputFirstname(){
		String ID = "com.bahaso:id/input_firstname";
		return scrollToById(ID);
	}
	
	public WebElement getInputLastname(){
		String ID = "com.bahaso:id/input_lastname";
		return scrollToById(ID);
	}
	
	public WebElement getRadioButtonMale(){
		String ID = "com.bahaso:id/rb_male";
		return scrollToById(ID);
	}
	
	public WebElement getRadioButtonFemale(){
		String ID = "com.bahaso:id/rb_female";
		return scrollToById(ID);
	}
	
	public WebElement getInputBirthdate(){
		String ID = "com.bahaso:id/input_dob";
		return scrollToById(ID);
	}
	
	public WebElement getInputCountry(){
		String ID = "com.bahaso:id/tv_input_country";
		return scrollToById(ID);
	}
	
	public WebElement getInputCallingCode(){
		String ID = "com.bahaso:id/tv_calling_code";
		return scrollToById(ID);
	}
	
	public WebElement getInputPhoneNumber(){
		String ID = "com.bahaso:id/et_phone_number";
		return scrollToById(ID);
	}
	
	public WebElement getInputJob(){
		String ID = "com.bahaso:id/input_job";
		return scrollToById(ID);
	}
	
	public WebElement getInputAboutMe(){
		String ID = "com.bahaso:id/input_about_me";
		return scrollToById(ID);
	}
	
	public String getMessageError(String err){
		return searcErrorMessage(err);
	}
	
	public ArrayList<WebElement> getMessagesError(){
		String ID = "com.bahaso:id/textinput_error";
		scrollToById(ID);
		return (ArrayList<WebElement>) driver.findElementsById(ID);
	}
	
	
}

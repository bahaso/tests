package bahaso.testing.androidElement;

import java.time.temporal.WeekFields;
import java.util.ArrayList;

import org.openqa.selenium.WebElement;

import io.appium.java_client.android.AndroidDriver;

public class EditProfile {
	AndroidDriver driver;
	
	public EditProfile(AndroidDriver driver){
		this.driver = driver;
	}
	
	//Button
	
	public WebElement getButtonSave(){
		boolean flag = true;
		while(flag){
			ArrayList<WebElement> et = (ArrayList<WebElement>) driver.findElementsByClassName("android.widget.TextView");
			for(WebElement element : et){
				if(element.getText().equals("Simpan")){
					flag=false;
				}
			}
			int xStart = et.get(et.size()-1).getLocation().getX() + et.get(et.size()-1).getSize().width/2;
			int yStart = et.get(et.size()-1).getLocation().getY() + et.get(et.size()-1).getSize().height/2;
			driver.swipe(xStart, yStart, xStart, yStart-300, 3000);
		}
		return driver.findElementById("com.bahaso:id/layout_btn_simpan_edit_profile");
	}
	
	//Edit Text
	
	public WebElement getInputFirstname(){
		return driver.findElementById("com.bahaso:id/input_firstname");
	}
	
	public WebElement getInputLastname(){
		return driver.findElementById("com.bahaso:id/input_lastname");
	}
	
	public WebElement getRadioButtonMale(){
		return driver.findElementById("com.bahaso:id/rb_male");
	}
	
	public WebElement getRadioButtonFemale(){
		return driver.findElementById("com.bahaso:id/rb_female");
	}
	
	public WebElement getInputBirthdate(){
		return driver.findElementById("com.bahaso:id/input_dob");
	}
	
	public WebElement getInputCountry(){
		return driver.findElementById("com.bahaso:id/tv_input_country");
	}
	
	public WebElement getInputCallingCode(){
		return driver.findElementById("com.bahaso:id/tv_calling_code");
	}
	
	public WebElement getInputPhoneNumber(){
		return driver.findElementById("com.bahaso:id/et_phone_number");
	}
	
	public WebElement getInputJob(){
		return driver.findElementById("com.bahaso:id/input_job");
	}
	
	public WebElement getInputAboutMe(){
		return driver.findElementById("com.bahaso:id/input_about_me");
	}
	
	
}

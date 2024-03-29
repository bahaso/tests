package bahaso.testing.androidElement;

import java.util.ArrayList;

import org.openqa.selenium.WebElement;

import io.appium.java_client.android.AndroidDriver;

public class Profile {
	AndroidDriver driver;
	
	public Profile(AndroidDriver driver){
		this.driver = driver;
	}
	
	public void scrollToById(String ID){
		ArrayList<WebElement> Elements = (ArrayList<WebElement>) driver.findElementsById(ID);
		while(Elements.size()==0){
			Elements = (ArrayList<WebElement>) driver.findElementsById(ID);
			WebElement screen = driver.findElementByClassName("android.widget.FrameLayout");
			int xStart = screen.getLocation().getX() + screen.getSize().width/2;
			int yStart = screen.getLocation().getY() + screen.getSize().height-50;
			driver.swipe(xStart, yStart, xStart, yStart-100, 3000);
		}
	}
	
	//BUTTON
	
	public WebElement getBtnEditProfile(){
		String ID = "com.bahaso:id/iv_edit_profile";
		scrollToById(ID);
		return driver.findElementById(ID);
	}
	
	//TEXTVIEW
	
	public WebElement getProfileImage(){
		String ID = "com.bahaso:id/iv_profile_image";
		scrollToById(ID);
		return driver.findElementById(ID);
	}
	
	
	public WebElement getFullName(){
		String ID = "com.bahaso:id/tv_name";
		scrollToById(ID);
		return driver.findElementById(ID);
	}
	
	public WebElement getUsername(){
		String ID = "com.bahaso:id/tv_username";
		scrollToById(ID);
		return driver.findElementById(ID);
	}
	
	public WebElement getPremiumStatus(){
		String ID = "com.bahaso:id/tv_premium_status";
		scrollToById(ID);
		return driver.findElementById(ID);
	}
	
	public WebElement getPoints(){
		String ID = "com.bahaso:id/tv_points";
		scrollToById(ID);
		return driver.findElementById(ID);
	}
	
	public WebElement getBirthDate(){
		String ID = "com.bahaso:id/tv_birthdate";
		scrollToById(ID);
		return driver.findElementById(ID);
	}
	
	public WebElement getEmail(){
		String ID = "com.bahaso:id/tv_email";
		scrollToById(ID);
		return driver.findElementById(ID);
	}
	
	public WebElement getJob(){
		String ID = "com.bahaso:id/tv_job";
		scrollToById(ID);
		return driver.findElementById(ID);
	}
	
	public WebElement getCountry(){
		String ID = "com.bahaso:id/tv_country";
		scrollToById(ID);
		return driver.findElementById(ID);
	}
	
	public WebElement getAboutMe(){
		String ID = "com.bahaso:id/tv_about";
		scrollToById(ID);
		return driver.findElementById(ID);
	}
}	

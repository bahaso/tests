package bahaso.testing.androidElement;

import org.openqa.selenium.WebElement;

import io.appium.java_client.android.AndroidDriver;

public class Profile {
	AndroidDriver driver;
	
	public Profile(AndroidDriver driver){
		this.driver = driver;
	}
	
	//BUTTON
	
	public WebElement getBtnEditProfile(){
		return driver.findElementById("com.bahaso:id/iv_edit_profile");
	}
	
	//TEXTVIEW
	
	public WebElement getProfileImage(){
		return driver.findElementById("com.bahaso:id/iv_profile_image");
	}
	
	
	public WebElement getFullName(){
		return driver.findElementById("com.bahaso:id/tv_name");
	}
	
	public WebElement getUsername(){
		return driver.findElementById("com.bahaso:id/tv_username");
	}
	
	public WebElement getPremiumStatus(){
		return driver.findElementById("com.bahaso:id/tv_premium_status");
	}
	
	public WebElement getPoints(){
		return driver.findElementById("com.bahaso:id/tv_points");
	}
	
	public WebElement getBirthDate(){
		return driver.findElementById("com.bahaso:id/tv_birthdate");
	}
	
	public WebElement getEmail(){
		return driver.findElementById("com.bahaso:id/tv_email");
	}
	
	public WebElement getJob(){
		return driver.findElementById("com.bahaso:id/tv_job");
	}
	
	public WebElement getCountry(){
		return driver.findElementById("com.bahaso:id/tv_country");
	}
	
	public WebElement getAboutMe(){
		return driver.findElementById("com.bahaso:id/tv_about");
	}
}	

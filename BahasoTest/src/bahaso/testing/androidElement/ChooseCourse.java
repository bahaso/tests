package bahaso.testing.androidElement;

import java.util.ArrayList;

import org.openqa.selenium.WebElement;

import io.appium.java_client.android.AndroidDriver;

public class ChooseCourse {
	AndroidDriver driver;
	
	public ChooseCourse(AndroidDriver driver){
		this.driver = driver;
	}
	
	public ArrayList<WebElement> getTabCourse(){
		return (ArrayList<WebElement>) driver.findElementsById("com.bahaso:id/appCompatImageView2");
	}
}

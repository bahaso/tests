package bahaso.testing.androidElement;

import java.util.ArrayList;

import org.openqa.selenium.WebElement;

import io.appium.java_client.android.AndroidDriver;

public class ChooseCourse {
	AndroidDriver driver;
	
	public ChooseCourse(AndroidDriver driver){
		this.driver = driver;
	}
	
	public WebElement getTabCourse(){
		//String DESTINATION_ELEMENT_TEXT= "CINA";
		return driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().resourceId('com.bahaso:id/txtLessonItem')).scrollIntoView(new UiSelector().text('Cina'));");
		//return (ArrayList<WebElement>) driver.findElementsById("com.bahaso:id/txtLessonItem");
	}
	
	public WebElement getBtnPlacement(){
		return driver.findElementById("com.bahaso:id/btnPlacement");
	}
}
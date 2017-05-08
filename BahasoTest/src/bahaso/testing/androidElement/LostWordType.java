package bahaso.testing.androidElement;

import java.util.ArrayList;

import org.openqa.selenium.WebElement;

import io.appium.java_client.android.AndroidDriver;

public class LostWordType {
	AndroidDriver driver;
	
	public LostWordType(AndroidDriver driver){
		this.driver = driver;
	}
	
	public ArrayList<WebElement> getLayout(){
		return (ArrayList<WebElement>) driver.findElementsById("com.bahaso:id/layoutCaseLostWordTypeItem");
	}
	
	public ArrayList<WebElement> getAnswerBoxes(){
		return (ArrayList<WebElement>) driver.findElementsById("com.bahaso:id/editTextLostWordType");
	}
	
	public void answerRight(){
		
	}
	
	public void answerWrong(){
		
	}
}

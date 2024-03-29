package bahaso.testing.androidElement;

import java.util.ArrayList;

import org.openqa.selenium.WebElement;

import io.appium.java_client.android.AndroidDriver;

public class LittleBoxMultipleChoice {
	AndroidDriver driver;
	
	public LittleBoxMultipleChoice(AndroidDriver driver){
		this.driver = driver;
	}
	
	public ArrayList<WebElement> getLayout(){
		return (ArrayList<WebElement>) driver.findElementsById("com.bahaso:id/layoutCaseLittleBoxSelectionItem");
	}
	
	public ArrayList<WebElement> getBtnSelection(Integer i){
		return (ArrayList<WebElement>) driver.findElementsByXPath("//*[@id='com.bahaso:id/layoutCaseLittleBoxSelectionItem']["+ i +"]//*[@id='com.bahaso:id/btnSelectionLittleBox']");
	}
	
	public void answerRight(){
		
	}
	
	public void answerWrong(){
		
	}
	
}

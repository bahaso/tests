package bahaso.testing.androidElement;

import java.util.ArrayList;

import org.openqa.selenium.WebElement;

import io.appium.java_client.android.AndroidDriver;

public class BoxMatchParagraph {
	AndroidDriver driver;
	
	public BoxMatchParagraph(AndroidDriver driver){
		this.driver = driver;
	}
	public ArrayList<WebElement> getDraggable(){
		return (ArrayList<WebElement>) driver.findElementsById("com.bahaso:id/buttonBoxMatchParagraphChoiceItemFront");
	}
	
	public ArrayList<WebElement> getDroppable(){
		return (ArrayList<WebElement>) driver.findElementsById("com.bahaso:id/relativeLayoutCaseContainer");
	}
	
	public void answerRight(){
		
	}
	
	public void answerWrong(){
		
	}
}

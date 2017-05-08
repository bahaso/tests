package bahaso.testing.androidElement;

import java.util.ArrayList;

import org.openqa.selenium.WebElement;

import io.appium.java_client.android.AndroidDriver;

public class ExercisePage {
	AndroidDriver driver;
	
	public ExercisePage(AndroidDriver driver){
		this.driver = driver;
	}
	
	public ArrayList<WebElement> getBtnNumber(){
		return (ArrayList<WebElement>) driver.findElementsById("com.bahaso:id/imageViewBoxMatchDisappearAnimateTranslate");
	}
	
	public WebElement getBtnCheck(){
		return driver.findElementById("com.bahaso:id/btnCaseCheck");
	}
	
}

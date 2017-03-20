package bahaso.testing.androidElement;

import java.util.ArrayList;

import org.openqa.selenium.WebElement;

import io.appium.java_client.android.AndroidDriver;

public class Home {
	AndroidDriver driver;
	
	public Home(AndroidDriver driver){
		this.driver = driver;
	}
	public ArrayList<WebElement> getTab(){
		return (ArrayList<WebElement>) driver.findElementsById("com.bahaso:id/tab");
	}
}

package bahaso.testing.androidElement;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;

import io.appium.java_client.android.AndroidDriver;

public class ExercisePage {
	AndroidDriver driver;
	
	public void scrollTo(String number){
		ArrayList<WebElement> btnNumbers = this.getBtnNumber();
		Boolean notfound = true;
		
		while(notfound){
			btnNumbers = this.getBtnNumber();
			for(WebElement btn : btnNumbers){
				if(btn.getText().equals(number)){
					btn.click();
					notfound = false;
					break;
				}
			}
			
			if(notfound){
				WebElement firstElement = btnNumbers.get(0);
				WebElement lastElement = btnNumbers.get(btnNumbers.size()-2);
				
				int xFrom = lastElement.getLocation().getX()+ lastElement.getSize().getWidth()/2;
				int yFrom = lastElement.getLocation().getY()+ lastElement.getSize().getHeight()/2;
				
				int xTo = firstElement.getLocation().getX() + firstElement.getSize().getWidth()/2;
				int yTo = firstElement.getLocation().getY() + firstElement.getSize().getHeight()/2;
				driver.swipe(xFrom, yFrom, xTo, yTo, 1000);
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			}
		}
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public ArrayList<WebElement> getBtnNumber(){
		return (ArrayList<WebElement>) driver.findElementsById("com.bahaso:id/btnCaseNumber");
	}
	
	public WebElement getBtnCheck(){
		return driver.findElementById("com.bahaso:id/btnCaseCheck");
	}
	
	public WebElement getLessonStatus(){
		return driver.findElementById("com.bahaso:id/textView2");
	}
	
}
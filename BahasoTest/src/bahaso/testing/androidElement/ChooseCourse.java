package bahaso.testing.androidElement;

import java.util.ArrayList;

import org.openqa.selenium.WebElement;

import io.appium.java_client.android.AndroidDriver;

public class ChooseCourse {
	AndroidDriver driver;
	
	public ChooseCourse(AndroidDriver driver){
		this.driver = driver;
	}
	
	public void getTabCourse(String lang){
		boolean flag = true;
		
		while(flag){
			ArrayList<WebElement> courses = (ArrayList<WebElement>) driver.findElementsById("com.bahaso:id/txtLessonItem");
			for(WebElement element : courses){
				if(element.getText().equals(lang)){
					element.click();
					flag = false;
					break;
				}
			}
			
			if(flag == true){
				WebElement first = courses.get(0);
				WebElement last = courses.get(courses.size()-1);
				
				int xStart = last.getLocation().getX() + last.getSize().width/2;
				int yStart = last.getLocation().getY() + last.getSize().height/2;
				
				int xEnd = first.getLocation().getX() + first.getSize().width/2;
				int yEnd = first.getLocation().getY() + first.getSize().height/2;
				driver.swipe(xStart, yStart, xEnd, yEnd, 3000);
			}
		}
		
		//return (ArrayList<WebElement>) driver.findElementsById("com.bahaso:id/txtLessonItem");
	}
	
	public WebElement getBtnPlacement(){
		return driver.findElementById("com.bahaso:id/btnPlacement");
	}
}

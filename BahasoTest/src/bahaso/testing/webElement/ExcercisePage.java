package bahaso.testing.webElement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ExcercisePage {
	public WebElement lessonStatus = null;
	public WebElement buttonNext = null;
	public WebElement buttonCheck = null;
	public WebElement buttonFinish = null;
	
	public WebElement getLessonStatus(WebDriver driver){
		lessonStatus = driver.findElement(By.className("lesson-status"));
		return lessonStatus;
	}
	
	public WebElement getButtonNext(WebDriver driver){
		buttonNext = driver.findElement(By.className("btn-next"));
		return buttonNext;
	}
	
	public WebElement getButtonCheck(WebDriver driver){
		buttonCheck = driver.findElement(By.className("btn-check"));
		return buttonCheck;
	}
	
	public WebElement getButtonFinish(WebDriver driver){
		buttonFinish = driver.findElement(By.className("btn-finish"));
		return buttonFinish;
	}
	
}

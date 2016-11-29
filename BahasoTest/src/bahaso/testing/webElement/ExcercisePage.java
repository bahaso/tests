package bahaso.testing.webElement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import bahaso.testing.general.WaitElement;

public class ExcercisePage {
	WebDriver driver = null;
	WaitElement wt = new WaitElement();
	public WebElement lessonStatus = null;
	public WebElement buttonNext = null;
	public WebElement buttonCheck = null;
	public WebElement buttonFinish = null;
	
	public WebElement getLessonStatus(){
		lessonStatus = driver.findElement(By.className("lesson-status"));
		return lessonStatus;
	}
	
	public WebElement getButtonNext(){
		buttonNext = driver.findElement(By.className("btn-next"));
		return buttonNext;
	}
	
	public WebElement getButtonCheck(){
		buttonCheck = driver.findElement(By.className("btn-check"));
		return buttonCheck;
	}
	
	public WebElement getButtonFinish(){
		buttonFinish = driver.findElement(By.className("btn-finish"));
		return buttonFinish;
	}
	
}
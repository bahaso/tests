package bahaso.testing.webElement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import bahaso.testing.web.answerLesson;

public class ListenRecordPicture extends ExcercisePage implements answerLesson{
	public WebElement boxAnswer;
	public WebElement microphoneButton;
	
	public ListenRecordPicture(WebDriver driver){
		this.driver = driver;
	}
	
	public WebElement getBoxAnswer(){
		boxAnswer = wt.waitForElement(driver, By.xpath("//input[@class='lesson']"));
		return boxAnswer;
	}
	
	public WebElement getMicrophoneButton(){
		microphoneButton = wt.waitForElement(driver, By.xpath("//button[@class='btn btn-toggle-microphone']"));
		return microphoneButton;
	}
	//operation
	public void answerRight(Object ans){
		try {
			Thread.sleep(3000);
			String answer = (String)ans;
			getMicrophoneButton().click();
			Thread.sleep(2000);
			getBoxAnswer().sendKeys(answer);
			getButtonCheck().click();
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void answerWrong(Object ans){
		try {
			Thread.sleep(3000);
			String answer = (String)ans;
			getMicrophoneButton().click();
			Thread.sleep(2000);
			getBoxAnswer().sendKeys("aaa");
			getButtonCheck().click();
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

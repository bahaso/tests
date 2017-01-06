package bahaso.testing.webElement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RecordASentence extends ExcercisePage{
	public WebElement boxAnswer;
	public WebElement microphoneButton;
	
	public RecordASentence(WebDriver driver){
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
	public void answerRight(String answer) throws InterruptedException{
		Thread.sleep(3000);
		getMicrophoneButton().click();
		Thread.sleep(2000);
		getBoxAnswer().sendKeys(answer);
		getButtonCheck().click();
		Thread.sleep(3000);
	}
	
	public void answerWrong(String answer) throws InterruptedException{
		Thread.sleep(3000);
		getMicrophoneButton().click();
		Thread.sleep(2000);
		getBoxAnswer().sendKeys("aaa");
		getButtonCheck().click();
		Thread.sleep(3000);
	}
}

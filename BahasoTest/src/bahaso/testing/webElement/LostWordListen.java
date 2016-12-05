package bahaso.testing.webElement;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LostWordListen extends ExcercisePage{
	public WebElement audioButton = null;
	public ArrayList<WebElement> boxAnswer = new ArrayList<WebElement>();
	
	public LostWordListen(WebDriver driver){
		this.driver = driver;
	}
	
	public ArrayList<WebElement> getBoxAnswer(){
		boxAnswer = (ArrayList<WebElement>) driver.findElements(By.xpath(".//*[@id='lesson-content']/div/div[2]/div/div/span[2]/span/input"));
		return boxAnswer;
	}
	
	public WebElement getAudioButton(){
		audioButton = wt.waitForElement(driver, By.xpath(".//*[@id='audiojs_wrapper0']"));
		return audioButton;
	}
	
	//operation
	public void answerRight(String[] answer) throws InterruptedException{
		Thread.sleep(3000);
		for(int i=0;i<answer.length;i++){
			getBoxAnswer().get(i).sendKeys(answer[i]);
			Thread.sleep(3000);
		}
		getButtonCheck().click();
		Thread.sleep(3000);
	}
	
	public void answerWrong(String[] answer) throws InterruptedException{
		Thread.sleep(3000);
		for(int i=0;i<answer.length;i++){
			getBoxAnswer().get(i).sendKeys("aaa");
			Thread.sleep(3000);
		}
		getButtonCheck().click();
		Thread.sleep(3000);
	}
	
	
}

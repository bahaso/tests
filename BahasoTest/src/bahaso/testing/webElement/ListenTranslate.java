package bahaso.testing.webElement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ListenTranslate extends ExcercisePage{
	public WebElement audioButton = null;
	public WebElement boxAnswer = null;
	
	public ListenTranslate(WebDriver driver){
		this.driver = driver;
	}
	
	public WebElement getAudioButton(){
		audioButton = wt.waitForElement(driver, By.xpath(".//*[@id='audiojs_wrapper0']"));
		return audioButton;
	}
	
	public WebElement getBoxAnswer(){
		boxAnswer = wt.waitForElement(driver, By.xpath(".//*[@id='lesson-content']/div/div[2]/div/textarea"));
		return boxAnswer;
	}
	
	//operation
	public void answerRight(String answer) throws InterruptedException{
		getBoxAnswer().sendKeys(answer);
		Thread.sleep(2000);
		getButtonCheck().click();
		Thread.sleep(3000);
	}
	
	public void answerWrong(String answer) throws InterruptedException{
		getBoxAnswer().sendKeys("aaa");
		Thread.sleep(2000);
		getButtonCheck().click();
		Thread.sleep(3000);
	}
}
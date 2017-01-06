package bahaso.testing.webElement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import bahaso.testing.web.answerLesson;

public class ListenTranslate extends ExcercisePage implements answerLesson{
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
	@Override
	public void answerRight(Object ans){
		try {
			String answer = (String)ans;
			getBoxAnswer().sendKeys(answer);
			Thread.sleep(2000);
			getButtonCheck().click();
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//operation
	@Override
	public void answerWrong(Object ans){
		try {
			String answer = (String)ans;
			getBoxAnswer().sendKeys("aaa");
			Thread.sleep(2000);
			getButtonCheck().click();
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

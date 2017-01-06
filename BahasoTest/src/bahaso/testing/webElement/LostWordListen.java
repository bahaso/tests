package bahaso.testing.webElement;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import bahaso.testing.web.answerLesson;

public class LostWordListen extends ExcercisePage implements answerLesson{
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
	@Override
	public void answerRight(Object ans){
		try {
			Thread.sleep(3000);
			String[] answer = (String[])ans;
			for(int i=0;i<answer.length;i++){
				getBoxAnswer().get(i).sendKeys(answer[i]);
				Thread.sleep(3000);
			}
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
			Thread.sleep(3000);
			String[] answer = (String[])ans;
			for(int i=0;i<answer.length;i++){
				getBoxAnswer().get(i).sendKeys("aaa");
				Thread.sleep(3000);
			}
			getButtonCheck().click();
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
}

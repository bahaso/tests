package bahaso.testing.webElement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import bahaso.testing.web.answerLesson;

public class TrueFalseListen extends ExcercisePage implements answerLesson{
	public WebElement instruction = null;
	public WebElement question = null;
	public WebElement audioButton = null;
	public WebElement description = null;
	public WebElement trueButton = null;
	public WebElement falseButton = null;
	
	public TrueFalseListen(WebDriver driver){
		this.driver = driver;
	}
	
	public WebElement getInstruction(){
		instruction = wt.waitForElement(driver, By.xpath(".//*[@id='lesson-instruction']"));
		return instruction;
	}
	
	public WebElement getQuestion(){
		question = wt.waitForElement(driver, By.className("question-container"));
		return question;
	}
	
	public WebElement getAudioButton(){
		audioButton = wt.waitForElement(driver, By.xpath(".//*[@id='audiojs_wrapper0']"));
		return audioButton;
	}
	
	public WebElement getDescription(){
		description = wt.waitForElement(driver, By.className("description-container"));
		return description;
	}
	
	public WebElement getTrueButton(){
		trueButton = wt.waitForElement(driver, By.xpath(".//*[@id='true']"));
		return trueButton;
	}
	
	public WebElement getFalseButton(){
		falseButton = wt.waitForElement(driver, By.xpath(".//*[@id='false']"));
		return falseButton;
	}

	@Override
	public void answerRight(Object ans) {
		try {
			boolean answer = (boolean)ans;
			if(answer){
				getTrueButton().click();
			}else{
				getFalseButton().click();
			}
			getButtonCheck().click();
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void answerWrong(Object ans) {
		try {
			boolean answer = (boolean)ans;
			if(answer==false){
				getTrueButton().click();
			}else{
				getFalseButton().click();
			}
			getButtonCheck().click();
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}

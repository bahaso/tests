package bahaso.testing.webElement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TrueFalseListen extends ExcercisePage{
	public WebElement instruction = null;
	public WebElement question = null;
	public WebElement audioButton = null;
	public WebElement description = null;
	public WebElement trueButton = null;
	public WebElement falseButton = null;
	
	public WebElement getInstruction(WebDriver driver){
		instruction = driver.findElement(By.xpath(".//*[@id='lesson-instruction']"));
		return instruction;
	}
	
	public WebElement getQuestion(WebDriver driver){
		question = driver.findElement(By.className("question-container"));
		return question;
	}
	
	public WebElement getAudioButton(WebDriver driver){
		audioButton = driver.findElement(By.xpath(".//*[@id='audiojs_wrapper0']"));
		return audioButton;
	}
	
	public WebElement getDescription(WebDriver driver){
		question = driver.findElement(By.className("description-container"));
		return question;
	}
	
	public WebElement getTrueButton(WebDriver driver){
		trueButton = driver.findElement(By.xpath(".//*[@id='true']"));
		return trueButton;
	}
	
	public WebElement getFalseButton(WebDriver driver){
		falseButton = driver.findElement(By.xpath(".//*[@id='false']"));
		return falseButton;
	}
}

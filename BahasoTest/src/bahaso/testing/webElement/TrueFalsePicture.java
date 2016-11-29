package bahaso.testing.webElement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TrueFalsePicture extends ExcercisePage{
	public WebElement instruction = null;
	public WebElement question = null;
	public WebElement description = null;
	public WebElement trueButton = null;
	public WebElement falseButton = null;
	
	public TrueFalsePicture(WebDriver driver){
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
}
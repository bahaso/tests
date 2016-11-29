package bahaso.testing.webElement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TrueFalseSentence extends ExcercisePage{
	public WebElement instruction = null;
	public WebElement description = null;
	public WebElement trueButton = null;
	public WebElement falseButton = null;
	
	public WebElement getInstruction(WebDriver driver){
		instruction = driver.findElement(By.xpath(".//*[@id='lesson-instruction']"));
		return instruction;
	}
	
	public WebElement getDescription(WebDriver driver){
		description = driver.findElement(By.className("description-container"));
		return description;
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

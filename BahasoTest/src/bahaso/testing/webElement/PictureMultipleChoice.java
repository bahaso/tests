package bahaso.testing.webElement;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PictureMultipleChoice extends ExcercisePage{
	public ArrayList<WebElement> allChoices = new ArrayList<WebElement>();
	public WebElement choice;
	
	public PictureMultipleChoice(WebDriver driver){
		this.driver = driver;
	}
	
	public ArrayList<WebElement> getAllAnswer(){
		return (ArrayList<WebElement>) driver.findElements(By.xpath("//input[@name='answer']"));
	}
	
	public WebElement getAnswerLabel(String kelas){
		return wt.waitForElement(driver, By.xpath("//label[@for='"+kelas+"']"));
	}
	
	//operation
	public void answerRight(String answer) throws InterruptedException{
		Thread.sleep(3000);
		for(int i=0;i<getAllAnswer().size();i++){
			if(answer.equals(getAllAnswer().get(i).getAttribute("value"))){
				getAnswerLabel(getAllAnswer().get(i).getAttribute("id")).click();
				Thread.sleep(3000);
				break;
			}
		}
		getButtonCheck().click();
		Thread.sleep(3000);
	}
	
	public void answerWrong(String answer) throws InterruptedException{
		Thread.sleep(3000);
		for(int i=0;i<getAllAnswer().size();i++){
			if(!answer.equals(getAllAnswer().get(i).getAttribute("value"))){
				getAnswerLabel(getAllAnswer().get(i).getAttribute("id")).click();
				Thread.sleep(3000);
				break;
			}
		}
		getButtonCheck().click();
		Thread.sleep(3000);
	}	
	
	
}
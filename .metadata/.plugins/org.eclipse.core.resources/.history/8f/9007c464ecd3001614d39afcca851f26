package bahaso.testing.webElement;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ListenSelectSingleBox extends ExcercisePage{
	public ArrayList<WebElement> choices = new ArrayList<WebElement>();
	public WebElement choice = null;
	
	public ListenSelectSingleBox(WebDriver driver){
		this.driver = driver;
	}
	
	public ArrayList<WebElement> getChoices(){
		choices = (ArrayList<WebElement>) driver.findElements(By.xpath("//input[@class='lesson']"));
		return choices;
	}
	
	public WebElement getChoice(String kelas){
		return wt.waitForElement(driver, By.xpath("//label[@for='"+kelas+"']"));
	}
	
	//operation
	public void answerRight(String[] answer) throws InterruptedException{
		Thread.sleep(3000);
		for(int i=0;i<answer.length;i++){
			for(int j=0;j<getChoices().size();j++){
				if(answer[i].equals(getChoices().get(j).getAttribute("value"))){
					getChoice(getChoices().get(j).getAttribute("id")).click();
					Thread.sleep(2000);
				}
			}
			
		}
		getButtonCheck().click();
		Thread.sleep(3000);
	}
	
	public void answerWrong(String[] answer) throws InterruptedException{
		Thread.sleep(3000);
		int wrong = 1;
		for(int i=0;i<answer.length;i++){
			for(int j=0;j<getChoices().size();j++){
				if(wrong>0){
					if(!answer[i].equals(getChoices().get(j).getAttribute("value"))){
						getChoice(getChoices().get(j).getAttribute("id")).click();
						wrong = 0;
						Thread.sleep(2000);
						break;
					}
				}
				else if(answer[i].equals(getChoices().get(j).getAttribute("value"))){
					getChoice(getChoices().get(j).getAttribute("id")).click();
					Thread.sleep(2000);
					break;
				}
			}
			
		}
		getButtonCheck().click();
		Thread.sleep(3000);
	}
}

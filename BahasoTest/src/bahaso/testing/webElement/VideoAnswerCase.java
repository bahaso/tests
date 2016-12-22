package bahaso.testing.webElement;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class VideoAnswerCase extends ExcercisePage{
	public ArrayList<WebElement> choices;
	public WebElement microphoneButton;
	
	public VideoAnswerCase(WebDriver driver){
		this.driver = driver;
	}
	
	public ArrayList<WebElement> getChoices(){
		choices = (ArrayList<WebElement>) driver.findElements(By.xpath("//input[@class='lesson']"));
		return choices;
	}
	
	public WebElement getChoice(String kelas){
		return wt.waitForElement(driver, By.xpath("//label[@for='"+kelas+"']"));
	}
	
	public WebElement getMicrophoneButton(){
		microphoneButton = wt.waitForElement(driver, By.xpath("//button[@class='btn btn-toggle-microphone']"));
		return microphoneButton;
	}
	//operation
		public void answerRight(String[] answer) throws InterruptedException{
			Thread.sleep(3000);
			getMicrophoneButton().click();
			Thread.sleep(2000);
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
			getMicrophoneButton().click();
			Thread.sleep(2000);
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

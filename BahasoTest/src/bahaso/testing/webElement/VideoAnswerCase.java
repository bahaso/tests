package bahaso.testing.webElement;

import java.util.ArrayList;

import org.bson.Document;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class VideoAnswerCase extends ExcercisePage implements answerLesson{
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
	
	@Override
	public Object getAnswerData(Document data) {
		ArrayList<ArrayList<String>> ans = (ArrayList<ArrayList<String>>) data.get("answers");
		ArrayList<String> answer = new ArrayList<String>();
		for(int i=0;i<ans.size();i++){
			answer.add(ans.get(i).get(0));
		}
		return answer;
	}
	
	//operation
	@Override
	public void answerRight(Object ans){
		try {
			Thread.sleep(3000);
			ArrayList<String> answer = (ArrayList<String>) ans;
			getMicrophoneButton().click();
			Thread.sleep(2000);
			for(int i=0;i<answer.size();i++){
				for(int j=0;j<getChoices().size();j++){
					if(answer.get(i).trim().equals(getChoices().get(j).getAttribute("value"))){
						getChoice(getChoices().get(j).getAttribute("id")).click();
						Thread.sleep(2000);
					}
				}
				
			}
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
			ArrayList<String> answer = (ArrayList<String>) ans;
			getMicrophoneButton().click();
			Thread.sleep(2000);
			int wrong = 1;
			for(int i=0;i<answer.size();i++){
				for(int j=0;j<getChoices().size();j++){
					if(wrong>0){
						if(!answer.get(i).trim().equals(getChoices().get(j).getAttribute("value"))){
							getChoice(getChoices().get(j).getAttribute("id")).click();
							wrong = 0;
							Thread.sleep(2000);
							break;
						}
					}
					else if(answer.get(i).equals(getChoices().get(j).getAttribute("value"))){
						getChoice(getChoices().get(j).getAttribute("id")).click();
						Thread.sleep(2000);
						break;
					}
				}
				
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

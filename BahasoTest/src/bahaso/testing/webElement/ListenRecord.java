package bahaso.testing.webElement;

import java.util.ArrayList;

import org.bson.Document;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ListenRecord extends ExcercisePage implements answerLesson{
	public WebElement boxAnswer;
	public WebElement microphoneButton;
	
	public ListenRecord(WebDriver driver){
		this.driver = driver;
	}
	
	public WebElement getBoxAnswer(){
		boxAnswer = wt.waitForElement(driver, By.xpath("//input[@class='lesson']"));
		return boxAnswer;
	}
	
	public WebElement getMicrophoneButton(){
		microphoneButton = wt.waitForElement(driver, By.xpath("//button[@class='btn btn-toggle-microphone']"));
		return microphoneButton;
	}
	
	@Override
	public Object getAnswerData(Document data) {
		ArrayList<Document> answer = (ArrayList<Document>) data.get("answers");
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
			getBoxAnswer().sendKeys(answer.get(0).trim());
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
			getBoxAnswer().sendKeys("aaa");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

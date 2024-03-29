package bahaso.testing.webElement;

import java.util.ArrayList;

import org.bson.Document;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ListenTranslate extends ExcercisePage implements answerLesson{
	public WebElement audioButton = null;
	public WebElement boxAnswer = null;
	
	public ListenTranslate(WebDriver driver){
		this.driver = driver;
	}
	
	public WebElement getAudioButton(){
		audioButton = wt.waitForElement(driver, By.xpath(".//*[@id='audiojs_wrapper0']"));
		return audioButton;
	}
	
	public WebElement getBoxAnswer(){
		boxAnswer = wt.waitForElement(driver, By.xpath(".//*[@id='lesson-content']/div/div[2]/div/textarea"));
		return boxAnswer;
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
			ArrayList<String> answer = (ArrayList<String>) ans;
			getBoxAnswer().sendKeys(answer.get(0).trim());
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//operation
	@Override
	public void answerWrong(Object ans){
		try {
			ArrayList<String> answer = (ArrayList<String>) ans;
			getBoxAnswer().sendKeys("aaa");
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

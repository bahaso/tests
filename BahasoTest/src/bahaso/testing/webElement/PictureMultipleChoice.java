package bahaso.testing.webElement;

import java.util.ArrayList;

import org.bson.Document;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PictureMultipleChoice extends ExcercisePage implements answerLesson{
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
	
	@Override
	public Object getAnswerData(Document data) {
		String answer = (String) data.get("answer");
		return answer;
	}	
	
	//operation
	@Override
	public void answerRight(Object ans){
		try {
			Thread.sleep(3000);
			String answer = (String)ans;
			for(int i=0;i<getAllAnswer().size();i++){
				if(answer.trim().equals(getAllAnswer().get(i).getAttribute("value"))){
					getAnswerLabel(getAllAnswer().get(i).getAttribute("id")).click();
					Thread.sleep(3000);
					break;
				}
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void answerWrong(Object ans){
		try {
			Thread.sleep(3000);
			String answer = (String)ans;
			for(int i=0;i<getAllAnswer().size();i++){
				if(!answer.trim().equals(getAllAnswer().get(i).getAttribute("value"))){
					getAnswerLabel(getAllAnswer().get(i).getAttribute("id")).click();
					Thread.sleep(3000);
					break;
				}
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

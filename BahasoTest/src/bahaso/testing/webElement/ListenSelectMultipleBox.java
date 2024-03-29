package bahaso.testing.webElement;

import java.util.ArrayList;

import org.bson.Document;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ListenSelectMultipleBox extends ExcercisePage implements answerLesson{
	public ArrayList<WebElement> choices = new ArrayList<WebElement>();
	public WebElement choice = null;
	
	public ListenSelectMultipleBox(WebDriver driver){
		this.driver = driver;
	}
	
	public ArrayList<WebElement> getChoices(){
		choices = (ArrayList<WebElement>) driver.findElements(By.xpath("//input[@class='lesson']"));
		return choices;
	}
	
	public WebElement getChoice(String kelas){
		return wt.waitForElement(driver, By.xpath("//label[@for='"+kelas+"']"));
	}
	
	@Override
	public Object getAnswerData(Document data) {
		ArrayList<Document> answer = (ArrayList<Document>) data.get("answer");
		return answer;
	}
	
	//operation
	@Override
	public void answerRight(Object ans){
		try {
			Thread.sleep(3000);
			ArrayList<String> answer = (ArrayList<String>) ans;
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
	
	public void answerWrong(Object ans){
		try {
			Thread.sleep(3000);
			int wrong = 1;
			ArrayList<String> answer = (ArrayList<String>) ans;
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
					else if(answer.get(i).trim().equals(getChoices().get(j).getAttribute("value"))){
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

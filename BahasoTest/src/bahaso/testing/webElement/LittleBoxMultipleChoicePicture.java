package bahaso.testing.webElement;

import java.util.ArrayList;

import org.bson.Document;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LittleBoxMultipleChoicePicture extends ExcercisePage implements answerLesson{
	public ArrayList<WebElement> question = new ArrayList<WebElement>();
	public ArrayList<WebElement> AnswerPerQuestion;
	public ArrayList<ArrayList<WebElement>> allAnswer = new ArrayList<ArrayList<WebElement>>();
	public WebElement answerLabel;
	
	public LittleBoxMultipleChoicePicture(WebDriver driver){
		this.driver = driver;
	}
	
	public ArrayList<WebElement> getQuestion(){
		question = (ArrayList<WebElement>) driver.findElements(By.xpath("//*[@id='lesson-content']/div/div/ol/li"));
		return question;
	}
	
	public ArrayList<ArrayList<WebElement>> getAllAnswer(){
		if(allAnswer.size()==0){
			for(int i=0;i<getQuestion().size();i++){
				AnswerPerQuestion = new ArrayList<WebElement>();
				AnswerPerQuestion = (ArrayList<WebElement>) driver.findElements(By.xpath("//input[@name='sentence"+i+"']"));
				allAnswer.add(AnswerPerQuestion);
			}
		}
		return allAnswer;
	}
	
	public WebElement getAnswerLabel(String kelas){
		return driver.findElement(By.xpath("//label[@for='"+kelas+"']"));
	}
	
	@Override
	public Object getAnswerData(Document data) {
		ArrayList<Document> ans = (ArrayList<Document>) data.get("questions");
		ArrayList<String> answer = new ArrayList<String>();
		for(int i=0;i<ans.size();i++){
			answer.add((String) ans.get(i).get("answer"));
		}
		return answer;
	}
	
	//operation
	@Override
	public void answerRight(Object ans){
		try {
			Thread.sleep(3000);
			ArrayList<String> answer= (ArrayList<String>) ans;
			for(int i=0;i<getAllAnswer().size();i++){
				for(int j=0;j<getAllAnswer().get(i).size();j++){
					if(answer.get(i).trim().equals(getAllAnswer().get(i).get(j).getAttribute("value"))){
						getAnswerLabel(getAllAnswer().get(i).get(j).getAttribute("id")).click();
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
			ArrayList<String> answer= (ArrayList<String>) ans;
			for(int i=0;i<getAllAnswer().size();i++){
				for(int j=0;j<getAllAnswer().get(i).size();j++){
					if(!answer.get(i).trim().equals(getAllAnswer().get(i).get(j).getAttribute("value"))){
						getAnswerLabel(getAllAnswer().get(i).get(j).getAttribute("id")).click();
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

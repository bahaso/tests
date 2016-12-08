package bahaso.testing.webElement;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LittleBoxMultipleChoice extends ExcercisePage{
	public ArrayList<WebElement> question = new ArrayList<WebElement>();
	public ArrayList<WebElement> AnswerPerQuestion;
	public ArrayList<ArrayList<WebElement>> allAnswer = new ArrayList<ArrayList<WebElement>>();
	public WebElement answerLabel;
	
	public LittleBoxMultipleChoice(WebDriver driver){
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
	
	//operation
	public void answerRight(String[] answer) throws InterruptedException{
		Thread.sleep(3000);
		
		for(int i=0;i<getAllAnswer().size();i++){
			for(int j=0;j<getAllAnswer().get(i).size();j++){
				if(answer[i].equals(getAllAnswer().get(i).get(j).getAttribute("value"))){
					getAnswerLabel(getAllAnswer().get(i).get(j).getAttribute("id")).click();
					Thread.sleep(2000);
				}
			}
		}
		getButtonCheck().click();
		Thread.sleep(3000);
	}
	
	public void answerWrong(String[] answer) throws InterruptedException{
		Thread.sleep(3000);
		
		for(int i=0;i<getAllAnswer().size();i++){
			for(int j=0;j<getAllAnswer().get(i).size();j++){
				if(!answer[i].equals(getAllAnswer().get(i).get(j).getAttribute("value"))){
					getAnswerLabel(getAllAnswer().get(i).get(j).getAttribute("id")).click();
					Thread.sleep(2000);
					break;
				}
			}
		}
		getButtonCheck().click();
		Thread.sleep(3000);
	}
	
}

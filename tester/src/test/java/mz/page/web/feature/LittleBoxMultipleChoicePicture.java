package mz.page.web.feature;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import mz.page.general.AbstractWeb;

public class LittleBoxMultipleChoicePicture extends AbstractWeb {
	WebDriver driver = webApplication.getDriver();
	
	public WebElement instruction = driver.findElement(By.id("lesson-instruction"));
	
	public WebElement image = driver.findElement(By.className("lesson-image"));
	
	public ArrayList<WebElement> question = new ArrayList<WebElement>();
	
	public WebElement status = null;
	
	public WebElement boxAnswer = null;
	
	public ArrayList<ArrayList<WebElement>> Answer = new ArrayList<ArrayList<WebElement>>();
	
	public ArrayList<WebElement> AnswerPerQuestion;
	
	public WebElement BoxAnswer;
	
	public ArrayList<WebElement> getQuestion(){
		question = (ArrayList<WebElement>) driver.findElements(By.xpath("//*[@id='lesson-content']/div/div/ol/li"));
		return question;
	}
	
	public ArrayList<ArrayList<WebElement>> getAllAnswer(){
		if(Answer.size()==0){
			for(int i=0;i<getQuestion().size();i++){
				AnswerPerQuestion = new ArrayList<WebElement>();
				AnswerPerQuestion = (ArrayList<WebElement>) driver.findElements(By.xpath("//input[@name='sentence"+i+"']"));
				
				Answer.add(AnswerPerQuestion);
			}
		}
		
		
		return Answer;
	}
	
	public WebElement getboxAnswer(String id){
		boxAnswer = driver.findElement(By.xpath("//input[@id='"+id+"']"));
		return boxAnswer;
	}
	
	public void answerClick(String kelas){
		driver.findElement(By.xpath("//label[@for='"+kelas+"']")).click();
	}
	
	public WebElement getStatus(){
		status = driver.findElement(By.className("lesson-status"));
		return status;
	}
}

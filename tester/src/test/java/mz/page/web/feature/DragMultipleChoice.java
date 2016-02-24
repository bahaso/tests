package mz.page.web.feature;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import mz.page.general.AbstractWeb;

public class DragMultipleChoice extends AbstractWeb{
	WebDriver driver = webApplication.getDriver();
	
	public WebElement instruction = driver.findElement(By.id("lesson-instruction"));
	public WebElement question = driver.findElement(By.xpath("//*[@id='lesson-content']/div/div[1]/div[1]"));
	public WebElement questionInfo = driver.findElement(By.xpath("//*[@id='lesson-content']/div/div[3]/div[1]"));
	public WebElement answerInfo = driver.findElement(By.xpath("//*[@id='lesson-content']/div/div[3]/div[2]"));
	
	public ArrayList<WebElement> DropBox = new ArrayList<WebElement>();
	public ArrayList<WebElement> BoxAnswer = new ArrayList<WebElement>();
	
	public ArrayList<WebElement> getDropBox(){
		if(DropBox.size()==0)DropBox = (ArrayList<WebElement>) driver.findElements(By.className("droppable"));
		return DropBox;
	}
	
	public ArrayList<WebElement> getBoxAnswer(){
		if(BoxAnswer.size()==0)BoxAnswer = (ArrayList<WebElement>) driver.findElements(By.className("tile-question"));
		return BoxAnswer;
	}
}

package mz.page.web.feature;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import mz.page.general.AbstractWeb;

public class BoxMatchListPicture extends AbstractWeb{
	WebDriver driver = webApplication.getDriver();
	
	public WebElement instruction = driver.findElement(By.id("lesson-instruction"));
	
	public WebElement image = driver.findElement(By.className("lesson-image"));
	
	public WebElement status = null;
	
	public ArrayList<WebElement> question = new ArrayList<WebElement>();
	
	public ArrayList<WebElement> DropBox = new ArrayList<WebElement>();
	
	public ArrayList<WebElement> BoxAnswer = new ArrayList<WebElement>();
	
	public ArrayList<WebElement> getQuestion(){
		question = (ArrayList<WebElement>) driver.findElements(By.xpath("//*[@id='lesson-content']/div/div[2]/ol/li"));
		return question;
	}
	
	public ArrayList<WebElement> getDropBox(){
		DropBox = (ArrayList<WebElement>) driver.findElements(By.className("droppable"));
		return DropBox;
	}
	
	public ArrayList<WebElement> getBoxAnswer(){
		BoxAnswer = (ArrayList<WebElement>) driver.findElements(By.className("tile-question"));
		return BoxAnswer;
	}
	
	public WebElement getStatus(){
		status = driver.findElement(By.className("lesson-status"));
		return status;
	}
}

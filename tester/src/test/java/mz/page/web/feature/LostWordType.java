package mz.page.web.feature;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import mz.page.general.AbstractWeb;

public class LostWordType extends AbstractWeb{
	WebDriver driver = webApplication.getDriver();
	
	public WebElement instruction = driver.findElement(By.id("lesson-instruction"));
	
	ArrayList<WebElement> question = new ArrayList<WebElement>();
	
	ArrayList<WebElement> boxAnswer = new ArrayList<WebElement>();
	
	public ArrayList<WebElement> getQuestion(){
		question = (ArrayList<WebElement>) driver.findElements(By.xpath("//*[@id='lesson-content']/div/div/ol/li"));
		return question;
	}
	
	public ArrayList<WebElement> getBoxAnswer(){
		if(boxAnswer.size()==0)boxAnswer = (ArrayList<WebElement>) driver.findElements(By.xpath("//input[@class='lesson']"));
		return boxAnswer;
	}
	
	
}

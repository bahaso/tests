package mz.page.web.feature;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import mz.page.general.AbstractWeb;

public class LostWordListen extends AbstractWeb {
	WebDriver driver = webApplication.getDriver();
	
	public WebElement instruction = driver.findElement(By.id("lesson-instruction"));
	
	public WebElement audio = driver.findElement(By.className("audiojs"));
	
	public WebElement audioButton;
	
	ArrayList<WebElement> question = new ArrayList<WebElement>();
	
	ArrayList<WebElement> boxAnswer = new ArrayList<WebElement>();
	
	public WebElement getAudioPlay(){
		audioButton = driver.findElement(By.className("audio-play"));
		return audioButton;
	}
	
	public WebElement getAudioPause(){
		audioButton = driver.findElement(By.className("audio-pause"));
		return audioButton;
	}
	
	public ArrayList<WebElement> getQuestion(){
		question = (ArrayList<WebElement>) driver.findElements(By.className("dialog-content"));
		return question;
	}
	
	public ArrayList<WebElement> getBoxAnswer(){
		if(boxAnswer.size()==0)boxAnswer = (ArrayList<WebElement>) driver.findElements(By.xpath("//input[@class='lesson']"));
		return boxAnswer;
	}
}

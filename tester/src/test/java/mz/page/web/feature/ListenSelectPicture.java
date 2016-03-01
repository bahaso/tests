package mz.page.web.feature;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import mz.page.general.AbstractWeb;

public class ListenSelectPicture extends AbstractWeb{
	WebDriver driver = webApplication.getDriver();
	
	public WebElement instruction = driver.findElement(By.id("lesson-instruction"));
	
	public WebElement audio = driver.findElement(By.className("audiojs"));
	
	public WebElement audioButton;
	
	public ArrayList<WebElement> BoxAnswer =  new ArrayList<WebElement>();
	
	public ArrayList<WebElement> AnswerImageSource =  new ArrayList<WebElement>();
	
	public ArrayList<WebElement> tampilanJawaban =  new ArrayList<WebElement>();
	
	public WebElement getAudioPlay(){
		audioButton = driver.findElement(By.className("audio-play"));
		return audioButton;
	}
	
	public WebElement getAudioPause(){
		audioButton = driver.findElement(By.className("audio-pause"));
		return audioButton;
	}
	
	public ArrayList<WebElement> getAnswerImageSource(){
		AnswerImageSource = (ArrayList<WebElement>) driver.findElements(By.xpath("//img[@class='lesson-image']"));
		return AnswerImageSource;
	}
	
	public ArrayList<WebElement> getBoxAnswer(){
		BoxAnswer = (ArrayList<WebElement>) driver.findElements(By.xpath("//img[@class='lesson-image']"));
		tampilanJawaban = (ArrayList<WebElement>) driver.findElements(By.xpath("//input[@class='lesson']"));
		return BoxAnswer;
	}
}

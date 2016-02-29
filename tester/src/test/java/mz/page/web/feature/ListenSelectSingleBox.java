package mz.page.web.feature;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import mz.page.general.AbstractWeb;

public class ListenSelectSingleBox extends AbstractWeb{
	WebDriver driver = webApplication.getDriver();
	
	public WebElement instruction = driver.findElement(By.id("lesson-instruction"));
	
	public WebElement audio = driver.findElement(By.className("audiojs"));
	
	public WebElement audioButton;
	
	public WebElement question = driver.findElement(By.xpath("//*[@id='lesson-content']/div/div[2]/div/div"));
	
	public ArrayList<WebElement> BoxAnswer =  new ArrayList<WebElement>();
	
	public ArrayList<WebElement> tampilanJawaban =  new ArrayList<WebElement>();
	
	public WebElement getAudioPlay(){
		audioButton = driver.findElement(By.className("audio-play"));
		return audioButton;
	}
	
	public WebElement getAudioPause(){
		audioButton = driver.findElement(By.className("audio-pause"));
		return audioButton;
	}
	
	public ArrayList<WebElement> getBoxAnswer(){
		BoxAnswer = (ArrayList<WebElement>) driver.findElements(By.xpath("//*[@id='lesson-content']/div/div[2]/div/label"));
		tampilanJawaban = (ArrayList<WebElement>) driver.findElements(By.xpath("//input[@class='lesson']"));
		return BoxAnswer;
	}
}

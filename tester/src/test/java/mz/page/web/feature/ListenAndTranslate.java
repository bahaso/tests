package mz.page.web.feature;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import mz.page.general.AbstractWeb;

public class ListenAndTranslate extends AbstractWeb{
	WebDriver driver = webApplication.getDriver();
	
	public WebElement instruction = driver.findElement(By.id("lesson-instruction"));
	
	public WebElement audio = driver.findElement(By.className("audiojs"));
	
	public WebElement audioButton;
	
	public WebElement BoxAnswer = driver.findElement(By.xpath("//textarea[@class='lesson']"));
	
	public WebElement getAudioPlay(){
		audioButton = driver.findElement(By.className("audio-play"));
		return audioButton;
	}
	
	public WebElement getAudioPause(){
		audioButton = driver.findElement(By.className("audio-pause"));
		return audioButton;
	}
}

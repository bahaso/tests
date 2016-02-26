package mz.page.web.feature;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import mz.page.general.AbstractWeb;

public class BoxMatchListen extends AbstractWeb{
	WebDriver driver = webApplication.getDriver();
	
	public WebElement instruction = driver.findElement(By.id("lesson-instruction"));
	
	ArrayList<WebElement> audio = new ArrayList<WebElement>();
	
	ArrayList<WebElement> audioButtonPlay = new ArrayList<WebElement>();
	
	ArrayList<WebElement> audioButtonPause = new ArrayList<WebElement>();
	
	public ArrayList<WebElement> DropBox = new ArrayList<WebElement>();
	
	public ArrayList<WebElement> BoxAnswer = new ArrayList<WebElement>();
	
	public ArrayList<WebElement> getAudio(){
		if(audio.size()==0) audio  = (ArrayList<WebElement>) driver.findElements(By.className("audiojs"));
		return audio;
	}
	
	public ArrayList<WebElement> getAudioButtonPlay(){
		if(audioButtonPlay.size()==0) audioButtonPlay  = (ArrayList<WebElement>) driver.findElements(By.className("audio-play"));
		return audioButtonPlay;
	}
	
	public ArrayList<WebElement> getAudioButtonPause(){
		if(audioButtonPause.size()==0) audioButtonPause  = (ArrayList<WebElement>) driver.findElements(By.className("audio-pause"));
		return audioButtonPause;
	}
	
	public ArrayList<WebElement> getDropBox(){
		if(DropBox.size()==0)DropBox = (ArrayList<WebElement>) driver.findElements(By.className("droppable"));
		return DropBox;
	}
	
	public ArrayList<WebElement> getBoxAnswer(){
		if(BoxAnswer.size()==0)BoxAnswer = (ArrayList<WebElement>) driver.findElements(By.className("tile-question"));
		return BoxAnswer;
	}
}

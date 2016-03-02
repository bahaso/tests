package mz.page.web.feature;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import mz.page.general.AbstractWeb;

public class TrueFalseListen extends AbstractWeb{
	WebDriver driver = webApplication.getDriver();
	
	public WebElement instruction = driver.findElement(By.id("lesson-instruction"));
	
	public WebElement question = driver.findElement(By.className("question-container"));
	
	public WebElement description = driver.findElement(By.className("description-container"));
	
	public WebElement audio = driver.findElement(By.className("audiojs"));
	
	public WebElement audioButton;
	
	public ArrayList<WebElement> boxAnswer = new ArrayList<WebElement>();
	
	public ArrayList<WebElement> TampilanJawaban = new ArrayList<WebElement>();
	
	public WebElement getAudioPlay(){
		audioButton = driver.findElement(By.className("audio-play"));
		return audioButton;
	}
	
	public WebElement getAudioPause(){
		audioButton = driver.findElement(By.className("audio-pause"));
		return audioButton;
	}
	
	public ArrayList<WebElement> getBoxAnswer(){
		if(boxAnswer.size()==0) boxAnswer = (ArrayList<WebElement>) driver.findElements(By.xpath("//label[@class='lesson']"));
		return boxAnswer;
	}
	
	public ArrayList<WebElement> getTampilanJawaban(){
		if(TampilanJawaban.size()==0) TampilanJawaban = (ArrayList<WebElement>) driver.findElements(By.xpath("//*[@type='radio']"));
		return TampilanJawaban;
	}
}

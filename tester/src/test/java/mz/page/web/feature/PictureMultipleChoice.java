package mz.page.web.feature;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import mz.page.general.AbstractWeb;

public class PictureMultipleChoice extends AbstractWeb{
	WebDriver driver = webApplication.getDriver();
	
	public WebElement instruction = driver.findElement(By.id("lesson-instruction"));
	
	public WebElement image = driver.findElement(By.className("lesson-image"));
	
	public WebElement status = null;
	
	public WebElement question = driver.findElement(By.xpath("//*[@id='lesson-content']/div/div[2]/div/div"));
	
	public ArrayList<WebElement> BoxAnswer =  new ArrayList<WebElement>();
	
	public ArrayList<WebElement> tampilanJawaban =  new ArrayList<WebElement>();
	
	
	
	public ArrayList<WebElement> getBoxAnswer(){
		BoxAnswer = (ArrayList<WebElement>) driver.findElements(By.xpath("//*[@id='lesson-content']/div/div[2]/div/label"));
		tampilanJawaban = (ArrayList<WebElement>) driver.findElements(By.xpath("//input[@class='lesson']"));
		return BoxAnswer;
	}
	
	public WebElement getStatus(){
		status = driver.findElement(By.className("lesson-status"));
		return status;
	}
	
	
}

package mz.page.web.feature;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import mz.page.general.AbstractWeb;

public class TrueFalsePicture extends AbstractWeb{
	WebDriver driver = webApplication.getDriver();
	
	public WebElement instruction = driver.findElement(By.id("lesson-instruction"));
	
	public WebElement image = driver.findElement(By.className("lesson-image"));
	
	public WebElement question = driver.findElement(By.className("question-container"));
	
	public ArrayList<WebElement> boxAnswer = new ArrayList<WebElement>();
	
	public ArrayList<WebElement> TampilanJawaban = new ArrayList<WebElement>();
	
	public ArrayList<WebElement> getBoxAnswer(){
		if(boxAnswer.size()==0) boxAnswer = (ArrayList<WebElement>) driver.findElements(By.xpath("//label[@class='lesson']"));
		return boxAnswer;
	}
	
	public ArrayList<WebElement> getTampilanJawaban(){
		if(TampilanJawaban.size()==0) TampilanJawaban = (ArrayList<WebElement>) driver.findElements(By.xpath("//*[@type='radio']"));
		return TampilanJawaban;
	}
}

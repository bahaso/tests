package mz.page.web.feature;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import mz.page.general.AbstractWeb;

public class BoxMatchDissapearPicture extends AbstractWeb{
	WebDriver driver = webApplication.getDriver();
	
	public WebElement instruction = driver.findElement(By.id("lesson-instruction"));
	
	public WebElement status = null;
	
	public ArrayList<WebElement> Categories = new ArrayList<WebElement>();
	
	public ArrayList<WebElement> DropBox = new ArrayList<WebElement>();
	
	public ArrayList<WebElement> BoxAnswer = new ArrayList<WebElement>();
	
	public ArrayList<WebElement> getCategories(){
		if(Categories.size()==0)Categories = (ArrayList<WebElement>) driver.findElements(By.className("hint"));
		return Categories;
	}
	
	public ArrayList<WebElement> getDropBox(){
		if(DropBox.size()==0)DropBox = (ArrayList<WebElement>) driver.findElements(By.className("droppable"));
		return DropBox;
	}
	
	public ArrayList<WebElement> getBoxAnswer(){
		if(BoxAnswer.size()==0)BoxAnswer = (ArrayList<WebElement>) driver.findElements(By.className("tile-question"));
		return BoxAnswer;
	}
	
	public WebElement getStatus(){
		status = driver.findElement(By.className("lesson-status"));
		return status;
	}

}

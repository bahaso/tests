package bahaso.testing.webElement;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import bahaso.testing.general.WaitElement;

public class LoginPage {
	WebDriver driver = null;
	WaitElement wt = new WaitElement();
	public WebElement usernameButton = null;
	public ArrayList<WebElement> levelButton = new ArrayList<WebElement>();
	public ArrayList<WebElement> lessonList = new ArrayList<WebElement>();
	public ArrayList<WebElement> subLesson = new ArrayList<WebElement>();
	
	public LoginPage(WebDriver driver){
		this.driver = driver;
	}
	
	public WebElement getUsernameButton(){
		usernameButton = wt.waitForElement(driver, By.xpath(".//*[@id='nav-main']/ul[2]/li[1]/a"));
		return usernameButton;
	}
	public ArrayList<WebElement> getLevelButton(){
		levelButton = (ArrayList<WebElement>) driver.findElements(By.xpath("html/body/div[4]/div[2]/div[2]/div/div[2]/ul/li/a"));
		return levelButton;
	}
	
	public ArrayList<WebElement> getLessonListA1(int level){
		String[] lvl = {"A1","A2","B1","B2"};
		lessonList = (ArrayList<WebElement>) driver.findElements(By.xpath("//*[@id='" + lvl[level] + "']//div//div[@class='lesson col-xs-4']/a"));
		return lessonList;
	}
	
	public ArrayList<WebElement> getLessonListA2(){
		lessonList = (ArrayList<WebElement>) driver.findElements(By.xpath("//*[@id='A2']//div//div[@class='lesson col-xs-4']/a"));
		return lessonList;
	}
	
	public ArrayList<WebElement> getLessonListB1(){
		lessonList = (ArrayList<WebElement>) driver.findElements(By.xpath("//*[@id='B1']//div//div[@class='lesson col-xs-4']/a"));
		return lessonList;
	}
	
	public ArrayList<WebElement> getLessonListB2(){
		lessonList = (ArrayList<WebElement>) driver.findElements(By.xpath("//*[@id='B2']//div//div[@class='lesson col-xs-4']/a"));
		return lessonList;
	}
	
	public ArrayList<WebElement> getSubLesson(int level, int n){
		String[] lvl = {"A1","A2","B1","B2"};
		subLesson = (ArrayList<WebElement>) driver.findElements(By.xpath("//*[@id='"+ lvl[level] +"']//div//div["+ n +"]//div//div/a"));
		return subLesson;
	}
	
	
}

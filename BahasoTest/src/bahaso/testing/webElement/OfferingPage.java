package bahaso.testing.webElement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OfferingPage {
	public WebElement inputRegisterNama1 = null;
	public WebElement inputRegisterEmail1 = null;
	public WebElement RegisterButton1 = null;
	
	public WebElement inputRegisterNama2 = null;
	public WebElement inputRegisterEmail2 = null;
	public WebElement RegisterButton2 = null;
	
	public WebElement inputRegisterNama3 = null;
	public WebElement inputRegisterEmail3 = null;
	public WebElement RegisterButton3 = null;
	
	public WebElement getInputRegisterNama1(WebDriver driver){
		inputRegisterNama1 = driver.findElement(By.xpath(".//*[@id='nama-1']"));
		return inputRegisterNama1;
	}
	
	public WebElement getInputRegisterEmail1(WebDriver driver){
		inputRegisterEmail1 = driver.findElement(By.xpath(".//*[@id='email-1']"));
		return inputRegisterEmail1;
	}
	
	public WebElement getRegisterButton1(WebDriver driver){
		RegisterButton1 = driver.findElement(By.xpath(".//*[@id='section-1']/div/div/div[2]/form/button"));
		return RegisterButton1;
	}
	
	public WebElement getInputRegisterNama2(WebDriver driver){
		inputRegisterNama2 = driver.findElement(By.xpath(".//*[@id='nama-2']"));
		return inputRegisterNama2;
	}
	
	public WebElement getInputRegisterEmail2(WebDriver driver){
		inputRegisterEmail1 = driver.findElement(By.xpath(".//*[@id='email-2']"));
		return inputRegisterEmail1;
	}
	
	public WebElement getRegisterButton2(WebDriver driver){
		RegisterButton1 = driver.findElement(By.xpath(".//*[@id='section-6']/div/div/form/div[3]/button"));
		return RegisterButton1;
	}
	
	public WebElement getInputRegisterNama3(WebDriver driver){
		inputRegisterNama3 = driver.findElement(By.xpath(".//*[@id='nama-3']"));
		return inputRegisterNama3;
	}
	
	public WebElement getInputRegisterEmail3(WebDriver driver){
		inputRegisterEmail3 = driver.findElement(By.xpath(".//*[@id='email-3']"));
		return inputRegisterEmail3;
	}
	
	public WebElement getRegisterButton3(WebDriver driver){
		RegisterButton3 = driver.findElement(By.xpath(".//*[@id='section-10']/div/div/form/div[3]/button"));
		return RegisterButton3;
	}
}

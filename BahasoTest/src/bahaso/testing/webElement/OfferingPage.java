package bahaso.testing.webElement;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import bahaso.testing.general.WaitElement;

public class OfferingPage {
	WebDriver driver = null;
	WaitElement wt = new WaitElement();
	public WebElement inputRegisterNama1 = null;
	public WebElement inputRegisterEmail1 = null;
	public WebElement RegisterButton1 = null;
	
	public WebElement inputRegisterNama2 = null;
	public WebElement inputRegisterEmail2 = null;
	public WebElement RegisterButton2 = null;
	
	public WebElement inputRegisterNama3 = null;
	public WebElement inputRegisterEmail3 = null;
	public WebElement RegisterButton3 = null;
	
	public OfferingPage(WebDriver driver){
		this.driver = driver;
	}
	
	public WebElement getInputRegisterNama1(){
		inputRegisterNama1 = wt.waitForElement(driver, By.xpath(".//*[@id='nama-1']"));
		return inputRegisterNama1;
	}
	
	public WebElement getInputRegisterEmail1(){
		inputRegisterEmail1 = wt.waitForElement(driver, By.xpath(".//*[@id='email-1']"));
		return inputRegisterEmail1;
	}
	
	public WebElement getRegisterButton1(){
		RegisterButton1 = wt.waitForElement(driver, By.xpath(".//*[@id='section-1']/div/div/div[2]/form/button"));
		return RegisterButton1;
	}
	
	public WebElement getInputRegisterNama2(){
		inputRegisterNama2 = wt.waitForElement(driver, By.xpath(".//*[@id='nama-2']"));
		return inputRegisterNama2;
	}
	
	public WebElement getInputRegisterEmail2(){
		inputRegisterEmail2 = wt.waitForElement(driver, By.xpath(".//*[@id='email-2']"));
		return inputRegisterEmail2;
	}
	
	public WebElement getRegisterButton2(){
		RegisterButton2 = wt.waitForElement(driver, By.xpath(".//*[@id='section-6']/div/div/form/div[3]/button"));
		return RegisterButton2;
	}
	
	public WebElement getInputRegisterNama3(){
		inputRegisterNama3 = wt.waitForElement(driver, By.xpath(".//*[@id='nama-3']"));
		return inputRegisterNama3;
	}
	
	public WebElement getInputRegisterEmail3(){
		inputRegisterEmail3 = wt.waitForElement(driver, By.xpath(".//*[@id='email-3']"));
		return inputRegisterEmail3;
	}
	
	public WebElement getRegisterButton3(){
		RegisterButton3 = wt.waitForElement(driver, By.xpath(".//*[@id='section-10']/div/div/form/div[3]/button"));
		return RegisterButton3;
	}
	
	//Operation
	
	public void doRegister1(HashMap<String, String> RegisterData){
		getInputRegisterNama1().sendKeys(RegisterData.get("name"));;
		getInputRegisterEmail1().sendKeys(RegisterData.get("email"));
	}
	
	public void doRegister2(HashMap<String, String> RegisterData){
		getInputRegisterNama2().sendKeys(RegisterData.get("name"));;
		getInputRegisterEmail2().sendKeys(RegisterData.get("email"));
	}
	
	public void doRegister3(HashMap<String, String> RegisterData){
		getInputRegisterNama3().sendKeys(RegisterData.get("name"));;
		getInputRegisterEmail3().sendKeys(RegisterData.get("email"));
	}
}

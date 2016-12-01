package bahaso.testing.general;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitElement {
	
	public WebElement waitForElement(WebDriver driver,By locator){
		WebElement element = null;
		try {
			WebDriverWait wait = new WebDriverWait(driver, 3);
			element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		} catch (Exception e) {
			System.out.println("Element not found");
		}
		return element;
	}
	
	public WebElement waitForElements(WebDriver driver, ArrayList<WebElement> elements){
		WebElement element = null;
		try {
			WebDriverWait wait = new WebDriverWait(driver, 3);
			element = (WebElement) wait.until(ExpectedConditions.visibilityOfAllElements(elements));
		} catch (Exception e) {
			System.out.println("Element not found");
		}
		return element;
	}
}

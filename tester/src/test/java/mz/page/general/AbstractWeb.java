package mz.page.general;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import com.google.common.base.Function;

public abstract class AbstractWeb {
		
	protected WebApplication webApplication = WebApplication.getInstance();

	protected WebElement FindElementWithWait(final By by )
	{
		Wait<WebDriver> wait = new FluentWait<WebDriver>(webApplication.getDriver())
				.withTimeout(15, TimeUnit.SECONDS).pollingEvery(5, TimeUnit.SECONDS).ignoring(NoSuchElementException.class);
		return wait.until(new Function<WebDriver,WebElement>() {
			public WebElement apply(WebDriver driver)
			{
				return driver.findElement(by);
			}
		});
	}
	
	protected WebElement FindElement(By by)
	{
		try{
			return webApplication.getDriver().findElement(by);
		}catch(NoSuchElementException ex)
		{
			return null;
		}
	}
}

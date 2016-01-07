package mz.component.behavior;

import org.openqa.selenium.WebElement;

public interface ITextbox {
	public WebElement LoginUsername();
	public WebElement LoginPassword();
	public WebElement RegisterFirstName();
	public WebElement RegisterLastName();
	public WebElement RegisterUsername();
	public WebElement RegisterEmail();
	public WebElement RegisterPassword();
	public WebElement RegisterPasswordConfirmation();
}

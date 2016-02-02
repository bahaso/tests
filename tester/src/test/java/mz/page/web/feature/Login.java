package mz.page.web.feature;

import org.openqa.selenium.By;

import mz.page.web.WebApplication;

public class Login{
	WebApplication webApplication = WebApplication.getInstance();
	public Login(){
	}
	public void SetTextUsername(String username)
	{
		webApplication.getDriver().findElement(By.xpath("html/body/div[2]/div[2]/form/div[1]/div/input")).clear();
		webApplication.getDriver().findElement(By.xpath("html/body/div[2]/div[2]/form/div[1]/div/input")).sendKeys(username);
	}
	public void SetTextPassword(String password)
	{
		webApplication.getDriver().findElement(By.xpath("html/body/div[2]/div[2]/form/div[2]/div/input")).clear();
		webApplication.getDriver().findElement(By.xpath("html/body/div[2]/div[2]/form/div[2]/div/input")).sendKeys(password);
	}
	public void ClickButtonLogin()
	{
		webApplication.getDriver().findElement(By.xpath("html/body/div[2]/div[2]/form/div[3]/button")).click();
	}
	public void ClickLinkForgetPassword(){}
}

package mz.page.web.feature;

import org.openqa.selenium.By;

import mz.page.general.AbstractWeb;

public class Login extends AbstractWeb {
	
	private String txtUsername = "html/body/div[2]/div[2]/form/div[1]/div/input";
	
	private String txtPassword = "html/body/div[2]/div[2]/form/div[2]/div/input";
	
	private String btnLogin = "html/body/div[2]/div[2]/form/div[3]/button";
	
	public Login(){
	}
	
	public void SetTextUsername(String username)
	{
		webApplication.getDriver().findElement(By.xpath(txtUsername)).clear();
		webApplication.getDriver().findElement(By.xpath(txtUsername)).sendKeys(username);
	}
	
	public void SetTextPassword(String password)
	{
		webApplication.getDriver().findElement(By.xpath(txtPassword)).clear();
		webApplication.getDriver().findElement(By.xpath(txtPassword)).sendKeys(password);
	}
	
	public void ClickButtonLogin()
	{
		webApplication.getDriver().findElement(By.xpath(btnLogin)).click();
	}
	
	public void ClickLinkForgetPassword(){}
	
}

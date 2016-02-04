package mz.page.android;

import mz.page.general.AbstractAndroid;

public class LoginPage extends AbstractAndroid {
	
	private String txtEmailOrUsername = "com.bahaso:id/et_username";
	
	private String txtPassword = "com.bahaso:id/et_password";
	
	private String btnMasuk = "com.bahaso:id/btn_login";
	
	private String linkForgetPassword = "com.bahaso:id/forgotPass";
	
	public void SetTextEmailOrUsername(String emailOrUsername){
		mobileApplication.getDriver().findElementById(txtEmailOrUsername).sendKeys(emailOrUsername);
	}
	
	public void SetTextPassword(String password){
		mobileApplication.getDriver().findElementById(txtPassword).sendKeys(password);
	}
	
	public void ClickButtonMasuk(){
		mobileApplication.getDriver().findElementById(btnMasuk).click();
	}
	
	public void ClickLinkForgetPassword(){
		mobileApplication.getDriver().findElementById(linkForgetPassword).click();
	}
	
}

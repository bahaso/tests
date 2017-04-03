package bahaso.testing.android;

import java.util.ArrayList;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import bahaso.testing.androidElement.Home;
import bahaso.testing.androidElement.Profile;
import bahaso.testing.general.mobileGeneral;

public class Profile_test extends mobileGeneral{
	Home home;
	Profile profile;
	
	@BeforeMethod
	public void beforeMethod(){
		try {
		startEngine();
		home = new Home(driver);
		profile = new Profile(driver);
		Thread.sleep(4000);
		action.press(home.getTab().get(2), 0, 0).release().perform();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
//	@Test
//	public void check_premium_status(){
//		try {
//			for(int i=0;i<home.getTab().size();i++){
//				action.press(home.getTab().get(i), 0, 0).release().perform();
//				Thread.sleep(4000);
//			}
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
	
	@Test
	public void check_name(){
		try {
			Assert.assertEquals(profile.getFullName().getText(), "hendra lubis", "FullName tidak sama");
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void check_username(){
		try {
			Assert.assertEquals(profile.getUsername().getText(), "reddeva", "Username tidak sama");
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void check_points(){
		try {
			Assert.assertEquals(profile.getPoints().getText(), "0 pts", "Point tidak sama");
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void check_birthdate(){
		try {
			Assert.assertEquals(profile.getBirthDate().getText(), "07/01/1990", "Tanggal lahir tidak sama");
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void check_email(){
		try {
			Assert.assertEquals(profile.getEmail().getText(), "ademahendra@bahaso.com", "email tidak sama");
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void check_job(){
		try {
			Assert.assertEquals(profile.getJob().getText(), "aaaaa", "email tidak sama");
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void check_country(){
		try {
			Assert.assertEquals(profile.getCountry().getText(), "ID", "negara tidak sama");
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void check_about_me(){
		try {
			boolean notfind=true;
			while(notfind){
				ArrayList<WebElement> tv = (ArrayList<WebElement>) driver.findElementsByClassName("android.widget.TextView");
				for(WebElement element : tv){
					if(element.getText().equals("saya")){
						notfind = false;
						break;
					}
				}
				int xStart = tv.get(tv.size()-1).getLocation().getX() + tv.get(tv.size()-1).getSize().width/2;
				int yStart = tv.get(tv.size()-1).getLocation().getY() + tv.get(tv.size()-1).getSize().height/2;
				driver.swipe(xStart, yStart, xStart, yStart-500, 3000);
			}
			//WebElement about = driver.findElementById("com.bahaso:id/tv_about");
			Assert.assertEquals(profile.getAboutMe().getText(), "saya", "About Me tidak sama");
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@AfterMethod
	public void afterMethod(){	
		driver.quit();
	}
}

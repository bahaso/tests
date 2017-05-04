package bahaso.testing.android;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import bahaso.testing.androidElement.EditProfile;
import bahaso.testing.androidElement.Home;
import bahaso.testing.androidElement.Profile;
import bahaso.testing.general.mobileGeneral;

public class Profile_test extends mobileGeneral{
	Home home;
	Profile profile;
	EditProfile editprofile;
	
	@BeforeMethod
	public void beforeMethod(){
		try {
		startEngine();
		home = new Home(driver);
		profile = new Profile(driver);
		editprofile = new EditProfile(driver);
		Thread.sleep(4000);
		home.getMenuOverflow().click();
		home.searchMenu("Profil").click();
		Thread.sleep(2000);
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
	public void validate_data_to_edit_profile(){
		
		String profile_fullname = profile.getFullName().getText();
		String profile_birthdate = profile.getBirthDate().getText();
		String profile_job = profile.getJob().getText();
		String profile_country = profile.getCountry().getText();
		String profile_aboutme = profile.getAboutMe().getText();
		
		profile.getBtnEditProfile().click();
		
		String editprofile_fullname = editprofile.getInputFirstname().getText() + " " + editprofile.getInputLastname().getText();
		String editprofile_birthdate = editprofile.getInputBirthdate().getText();
		String editprofile_job = editprofile.getInputJob().getText();
		String editprofile_country = editprofile.getInputCountry().getText();
		String editprofile_aboutme = editprofile.getInputAboutMe().getText();
		
		Assert.assertEquals(profile_fullname, editprofile_fullname, "FullName tidak sama");
		Assert.assertEquals(profile_birthdate, editprofile_birthdate, "Birth Date tidak sama");
		Assert.assertEquals(profile_job, editprofile_job, "Job tidak sama");
		//Assert.assertEquals(profile_country, editprofile_country, "Country tidak sama");
		Assert.assertEquals(profile_aboutme, editprofile_aboutme, "About Me tidak sama");
	}
	
	@AfterMethod
	public void afterMethod(){	
		driver.quit();
	}
}
package bahaso.testing.android;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import bahaso.testing.androidElement.EditProfile;
import bahaso.testing.androidElement.Home;
import bahaso.testing.androidElement.Profile;
import bahaso.testing.general.mobileGeneral;

public class EditProfile_test extends mobileGeneral{
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
		action.press(home.getTab().get(2), 0, 0).release().perform();
		Thread.sleep(3000);
		profile.getBtnEditProfile().click();
		Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//Firstname is empty
	@Test
	public void firstname_fail_1(){
		try {
			editprofile.getInputFirstname().clear();
			driver.hideKeyboard();
			Thread.sleep(100);
			editprofile.getButtonSave().click();
			Thread.sleep(2000);
			Assert.assertEquals(editprofile.getMessageError().getText(), "Nama depan harus diisi" , "Message Error tidak sama");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//firstname contain illegal character
	@Test
	public void firstname_fail_2(){
		try {
			editprofile.getInputFirstname().clear();
			editprofile.getInputFirstname().sendKeys("aaa111");
			driver.hideKeyboard();
			Thread.sleep(100);
			editprofile.getButtonSave().click();
			Assert.assertEquals(editprofile.getMessageError().getText(), "Isian nama depan hanya boleh diisi huruf, spasi dan apostrof (')" , "Message Error tidak sama");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//firstname less then 3 character
	@Test
	public void firstname_fail_3(){
		try {
			editprofile.getInputFirstname().clear();
			editprofile.getInputFirstname().sendKeys("a");
			driver.hideKeyboard();
			Thread.sleep(100);
			editprofile.getButtonSave().click();
			Assert.assertEquals(editprofile.getMessageError().getText(), "Nama depan minimum 3 karakter" , "Message Error tidak sama");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//lastname is empty
	@Test
	public void lastname_fail_1(){
		try {
			editprofile.getInputLastname().clear();
			driver.hideKeyboard();
			Thread.sleep(100);
			editprofile.getButtonSave().click();
			Assert.assertEquals(editprofile.getMessageError().getText(), "Nama belakang harus diisi" , "Message Error tidak sama");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//lastname contain illegal character
	@Test
	public void lastname_fail_2(){
		try {
			editprofile.getInputLastname().clear();
			editprofile.getInputLastname().sendKeys("a11111");
			driver.hideKeyboard();
			Thread.sleep(100);
			editprofile.getButtonSave().click();
			Assert.assertEquals(editprofile.getMessageError().getText(), "Nama belakang hanya boleh diisi huruf, spasi, titik, apostrof (') dan tanda hubung (-)" , "Message Error tidak sama");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//lastname less than 2 character
	@Test
	public void lastname_fail_3(){
		try {
			editprofile.getInputLastname().clear();
			editprofile.getInputLastname().sendKeys("a");
			driver.hideKeyboard();
			Thread.sleep(100);
			editprofile.getButtonSave().click();
			Assert.assertEquals(editprofile.getMessageError().getText(), "Nama belakang minimum 2 karakter" , "Message Error tidak sama");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//gender not selected
	@Test
	public void gender_fail_1(){
		try {
			Thread.sleep(100);
			editprofile.getButtonSave().click();
			Assert.assertEquals(editprofile.getMessageError().getText(), "Mohon pilih jenis kelamin anda" , "Message Error tidak sama");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//birthdate not filled
	@Test
	public void birthdate_fail_1(){
		try {
			editprofile.getRadioButtonMale().click();
			Thread.sleep(100);
			editprofile.getButtonSave().click();
			Assert.assertEquals(editprofile.getMessageError().getText(), "Mohon isi tanggal lahir anda" , "Message Error tidak sama");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//country not selected
	@Test
	public void country_fail_1(){
		try {
			editprofile.getRadioButtonMale().click();
			editprofile.getInputBirthdate().sendKeys("17/1/1990");
			Thread.sleep(100);
			editprofile.getButtonSave().click();
			Assert.assertEquals(editprofile.getMessagesError().get(1).getText(), "Mohon untuk pilih negara anda" , "Message Error tidak sama");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//phone number not selected
	@Test
	public void phone_number_fail_1(){
		try {
			editprofile.getRadioButtonMale().click();
			editprofile.getInputBirthdate().sendKeys("17/1/1990");
			Thread.sleep(100);
			editprofile.getButtonSave().click();
			Assert.assertEquals(editprofile.getMessagesError().get(2).getText(), "Nomor telepon tidak benar" , "Message Error tidak sama");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void validate_data_to_edit_profile(){
		String editprofile_fullname = editprofile.getInputFirstname().getText() + " " + editprofile.getInputLastname().getText();
		String editprofile_birthdate = editprofile.getInputBirthdate().getText();
		String editprofile_job = editprofile.getInputJob().getText();
		String editprofile_country = editprofile.getInputCountry().getText();
		String editprofile_aboutme = editprofile.getInputAboutMe().getText();
		
		editprofile.getButtonSave().click();
		
		String profile_fullname = profile.getFullName().getText();
		String profile_birthdate = profile.getBirthDate().getText();
		String profile_job = profile.getJob().getText();
		String profile_country = profile.getCountry().getText();
		String profile_aboutme = profile.getAboutMe().getText();
		
		
		
		Assert.assertEquals(editprofile_fullname, profile_fullname, "FullName tidak sama");
		Assert.assertEquals(editprofile_birthdate, profile_birthdate, "Birth Date tidak sama");
		Assert.assertEquals(editprofile_job, profile_job, "Job tidak sama");
		//Assert.assertEquals(profile_country, editprofile_country, "Country tidak sama");
		Assert.assertEquals(editprofile_aboutme,profile_aboutme, "About Me tidak sama");
	}
	
	
	
	@AfterMethod
	public void afterMethod(){	
		driver.quit();
	}
}

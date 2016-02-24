package mz.bahaso.testing.web;

import java.util.ArrayList;

import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

import mz.page.web.SubLessonPage;

public class LittleBoxMultipleChoicePicture_TestCase {
	Actions action = null;
	
	SubLessonPage subLessonPage = new SubLessonPage();
	
	private Assertion hardAssert = new Assertion();
	
	String url = "http://10.10.24.10/ngeadmin/previewCaseNewTab/56839072938e8ec0348b4570";
	String instruksi = "Pillih preposisi yang sesuai dengan gambar";
	String imageSource = "http://cdn.bahaso.com/original/b4bcabff84fe8463812009fd3c79b7c48c5f093b77b1ed324631576dc47c7008/cases/pictures/2015/12/30/884529b4babafc4320c449fe63eb501780dfc1436afcdcddf3ca2c6963ef18f3.png";
	
	ArrayList<String> pertanyaan = new ArrayList<String>(); 
	ArrayList<String> jawabanBenar = new ArrayList<String>();
	ArrayList<String> jawabanSalah = new ArrayList<String>();
	ArrayList<String> tampilanJawaban = new ArrayList<String>();
	ArrayList<String> tampilanJawabanID = new ArrayList<String>();
	
	ArrayList<ArrayList<String>> pilihanJawaban = new ArrayList<ArrayList<String>>();
	
	@BeforeClass
	public void BeforeClass() throws InterruptedException{
		pertanyaan.add("The painting is in on above the wall.");
		
		jawabanBenar.add("on");
		
		jawabanSalah.add("in");
		
		ArrayList<String> JawabanPerQuestion;
		
		for(int i=0;i<1;i++){
			JawabanPerQuestion  = new ArrayList<String>();
			JawabanPerQuestion.add("in");
			JawabanPerQuestion.add("on");
			JawabanPerQuestion.add("above");
			
			pilihanJawaban.add(JawabanPerQuestion);
			
		}
		//subLessonPage.login();
	}
	
	@BeforeMethod
	public void BeforeMethod() throws InterruptedException{
		subLessonPage.getUrl(url);
	}
	
	@Test
	public void test1() throws InterruptedException{
		Thread.sleep(1000);
		if(subLessonPage.getLittleBoxMultipleChoicePicture().instruction.getText().equals(instruksi)==false){
			hardAssert.fail("Instruksi tidak sama");
		}
	}
	
	@Test
	public void test2() throws InterruptedException{
		Thread.sleep(1000);
		if(subLessonPage.getLittleBoxMultipleChoicePicture().image.getAttribute("src").equals(imageSource)==false){
			hardAssert.fail("foto sumber tidak sama dengan database");
		}
	}
	
	@Test
	public void test3() throws InterruptedException{
		Thread.sleep(1000);
		for(int i=0;i<subLessonPage.getLittleBoxMultipleChoicePicture().getQuestion().size();i++){
			if(pertanyaan.get(i).equals(subLessonPage.getLittleBoxMultipleChoicePicture().getQuestion().get(i).getText())==false){
				hardAssert.fail(i + ". " + subLessonPage.getLittleBoxMultipleChoicePicture().getQuestion().get(i).getText() + " tidak ada dalam database");
			}
		}
	}
	
	@Test
	public void test4() throws InterruptedException{
		Thread.sleep(1000);
		for(int i=0;i<pilihanJawaban.size();i++){
			for(int j=0;j<pilihanJawaban.get(i).size();j++){
				if(subLessonPage.getLittleBoxMultipleChoicePicture().getAllAnswer().get(i).get(j).getAttribute("value").equals(pilihanJawaban.get(i).get(j))==false){
					hardAssert.fail("pertanyaan "+(i+1)+" pilihan jawaban ke "+(j+1)+". "+subLessonPage.getLittleBoxMultipleChoicePicture().getAllAnswer().get(i).get(j).getAttribute("value") + " tidak cocok dengan yang di database");
				}
			}
		}
	}
	
	@Test
	public void test5() throws InterruptedException{
		Thread.sleep(1000);
		if(subLessonPage.getBtnPeriksa().getAttribute("disabled")==null){
			hardAssert.fail("Tombol periksa bisa diklik sebelum semua pertanyaan dijawab");
		}
		
		for(int i=0;i<pilihanJawaban.size()-1;i++){
			for(int j=0;j<pilihanJawaban.get(i).size();j++){
				subLessonPage.getLittleBoxMultipleChoicePicture().answerClick(subLessonPage.getLittleBoxMultipleChoicePicture().getAllAnswer().get(i).get(j).getAttribute("id"));
				Thread.sleep(2000);
			}
			
			
		}
	}
	
	@Test
	public void test6() throws InterruptedException{
		Thread.sleep(1000);
		if(subLessonPage.getBtnPeriksa().getAttribute("disabled")==null){
			hardAssert.fail("Tombol periksa bisa diklik sebelum semua pertanyaan dijawab");
		}
		
		for(int i=0;i<pilihanJawaban.size();i++){
			for(int j=0;j<pilihanJawaban.get(i).size();j++){
				subLessonPage.getLittleBoxMultipleChoicePicture().answerClick(subLessonPage.getLittleBoxMultipleChoicePicture().getAllAnswer().get(i).get(j).getAttribute("id"));
				Thread.sleep(2000);
			}
		}
		
		if(subLessonPage.getBtnPeriksa().getAttribute("disabled")!=null){
			hardAssert.fail("Tombol periksa tikda bisa diklik sesudah semua jawaban diisi");
		}
	}
	
	@Test
	public void test7() throws InterruptedException{
		Thread.sleep(1000);
		for(int i=0;i<pilihanJawaban.size();i++){
			for(int j=0;j<pilihanJawaban.get(i).size();j++){
				if(subLessonPage.getLittleBoxMultipleChoicePicture().getAllAnswer().get(i).get(j).getAttribute("value").equals(jawabanBenar.get(i))){
					subLessonPage.getLittleBoxMultipleChoicePicture().answerClick(subLessonPage.getLittleBoxMultipleChoicePicture().getAllAnswer().get(i).get(j).getAttribute("id"));
					Thread.sleep(2000);
				}
			}
		}
		
		subLessonPage.getBtnPeriksa().click();
		Thread.sleep(2000);
		String status[] = subLessonPage.getLittleBoxMultipleChoicePicture().getStatus().getAttribute("class").split(" ");
		if(status[status.length-1].equals("true")==false)hardAssert.fail("Hasil akhir seharusnya benar");
	}
	
	@Test
	public void test8() throws InterruptedException{
		Thread.sleep(1000);
		for(int i=0;i<pilihanJawaban.size();i++){
			for(int j=0;j<pilihanJawaban.get(i).size();j++){
				if(subLessonPage.getLittleBoxMultipleChoicePicture().getAllAnswer().get(i).get(j).getAttribute("value").equals(jawabanSalah.get(i))){
					subLessonPage.getLittleBoxMultipleChoicePicture().answerClick(subLessonPage.getLittleBoxMultipleChoicePicture().getAllAnswer().get(i).get(j).getAttribute("id"));
					Thread.sleep(2000);
				}
			}
		}
		
		subLessonPage.getBtnPeriksa().click();
		Thread.sleep(2000);
		String status[] = subLessonPage.getLittleBoxMultipleChoicePicture().getStatus().getAttribute("class").split(" ");
		if(status[status.length-1].equals("false")==false)hardAssert.fail("Hasil akhir seharusnya benar");
	}
	
	@Test
	public void test9and10() throws InterruptedException{
		Thread.sleep(1000);
		for(int i=0;i<pilihanJawaban.size();i++){
			for(int j=0;j<pilihanJawaban.get(i).size();j++){
				if(subLessonPage.getLittleBoxMultipleChoicePicture().getAllAnswer().get(i).get(j).getAttribute("value").equals(jawabanSalah.get(i))){
					subLessonPage.getLittleBoxMultipleChoicePicture().answerClick(subLessonPage.getLittleBoxMultipleChoicePicture().getAllAnswer().get(i).get(j).getAttribute("id"));
					if(subLessonPage.getLittleBoxMultipleChoicePicture().getAllAnswer().get(i).get(j).getAttribute("value").equals(jawabanBenar.get(i))){
						tampilanJawaban.add("true");
					}else{
						tampilanJawaban.add("false");
					}
					tampilanJawabanID.add(subLessonPage.getLittleBoxMultipleChoicePicture().getAllAnswer().get(i).get(j).getAttribute("id"));
					Thread.sleep(2000);
				}
			}
		}
		
		subLessonPage.getBtnPeriksa().click();
		Thread.sleep(2000);
		for(int i=0;i<pilihanJawaban.size();i++){
			String status[] = subLessonPage.getLittleBoxMultipleChoicePicture().getboxAnswer(tampilanJawabanID.get(i)).getAttribute("class").split(" ");
			if(tampilanJawaban.get(i).equals(status[status.length-1])==false){
				hardAssert.fail("Tampilan jawaban yang benar dan salah tidak sesuai");
			}
		}
	}
	
	@AfterMethod
	public void destroy(){
		subLessonPage.destroy("LittleBoxMultipleChoicePicture");
	}
	
	@AfterSuite
	public void afterSuite(){
		subLessonPage.closeBrowser();
	}
}

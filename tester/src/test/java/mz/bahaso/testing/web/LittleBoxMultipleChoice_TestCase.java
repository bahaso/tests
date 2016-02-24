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

public class LittleBoxMultipleChoice_TestCase {
	Actions action = null;
	
	SubLessonPage subLessonPage = new SubLessonPage();
	
	private Assertion hardAssert = new Assertion();
	
	String url = "http://10.10.24.10/ngeadmin/previewCaseNewTab/5681033b938e8e7b148b4570";
	String instruksi = "Pilih verb be yang tepat untuk kalimat di bawah ini";
	
	ArrayList<String> pertanyaan = new ArrayList<String>(); 
	ArrayList<String> jawabanBenar = new ArrayList<String>();
	ArrayList<String> jawabanSalah = new ArrayList<String>();
	ArrayList<String> tampilanJawaban = new ArrayList<String>();
	ArrayList<String> tampilanJawabanID = new ArrayList<String>();
	
	ArrayList<ArrayList<String>> pilihanJawaban = new ArrayList<ArrayList<String>>();
	
	@BeforeClass
	public void BeforeClass() throws InterruptedException{
		pertanyaan.add("He is am are Toni.");
		pertanyaan.add("They is am are Sonny, Doni, and Tina.");
		pertanyaan.add("Her name is am are Maya.");
		pertanyaan.add("My name is am are Dara.");
		pertanyaan.add("I is am are John.");
		pertanyaan.add("Their names is am are Brandon and Billy.");
		
		jawabanBenar.add("is");
		jawabanBenar.add("are");
		jawabanBenar.add("is");
		jawabanBenar.add("is");
		jawabanBenar.add("am");
		jawabanBenar.add("are");
		
		jawabanSalah.add("is");
		jawabanSalah.add("are");
		jawabanSalah.add("is");
		jawabanSalah.add("are");
		jawabanSalah.add("am");
		jawabanSalah.add("are");
		
		ArrayList<String> JawabanPerQuestion;
		
		for(int i=0;i<6;i++){
			JawabanPerQuestion  = new ArrayList<String>();
			JawabanPerQuestion.add("is");
			JawabanPerQuestion.add("am");
			JawabanPerQuestion.add("are");
			
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
		if(subLessonPage.getLittleBoxMultipleChoice().instruction.getText().equals(instruksi)==false){
			hardAssert.fail("Instruksi tidak sama");
		}
	}
	
	@Test
	public void test2() throws InterruptedException{
		Thread.sleep(1000);
		for(int i=0;i<subLessonPage.getLittleBoxMultipleChoice().getQuestion().size();i++){
			if(pertanyaan.get(i).equals(subLessonPage.getLittleBoxMultipleChoice().getQuestion().get(i).getText())==false){
				hardAssert.fail(i + ". " + subLessonPage.getLittleBoxMultipleChoice().getQuestion().get(i).getText() + " tidak ada dalam database");
			}
		}
	}
	
	@Test
	public void test3() throws InterruptedException{
		Thread.sleep(1000);
		for(int i=0;i<pilihanJawaban.size();i++){
			for(int j=0;j<pilihanJawaban.get(i).size();j++){
				if(subLessonPage.getLittleBoxMultipleChoice().getAllAnswer().get(i).get(j).getAttribute("value").equals(pilihanJawaban.get(i).get(j))==false){
					hardAssert.fail("pertanyaan "+(i+1)+" pilihan jawaban ke "+(j+1)+". "+subLessonPage.getLittleBoxMultipleChoice().getAllAnswer().get(i).get(j).getAttribute("value") + " tidak cocok dengan yang di database");
				}
			}
		}
	}
	
	@Test
	public void test4() throws InterruptedException{
		Thread.sleep(1000);
		if(subLessonPage.getBtnPeriksa().getAttribute("disabled")==null){
			hardAssert.fail("Tombol periksa bisa diklik sebelum semua pertanyaan dijawab");
		}
		
		for(int i=0;i<pilihanJawaban.size()-1;i++){
			for(int j=0;j<pilihanJawaban.get(i).size();j++){
				subLessonPage.getLittleBoxMultipleChoice().answerClick(subLessonPage.getLittleBoxMultipleChoice().getAllAnswer().get(i).get(j).getAttribute("id"));
				Thread.sleep(2000);
			}
			
			
		}
	}
	
	@Test
	public void test5() throws InterruptedException{
		Thread.sleep(1000);
		if(subLessonPage.getBtnPeriksa().getAttribute("disabled")==null){
			hardAssert.fail("Tombol periksa bisa diklik sebelum semua pertanyaan dijawab");
		}
		
		for(int i=0;i<pilihanJawaban.size();i++){
			for(int j=0;j<pilihanJawaban.get(i).size();j++){
				subLessonPage.getLittleBoxMultipleChoice().answerClick(subLessonPage.getLittleBoxMultipleChoice().getAllAnswer().get(i).get(j).getAttribute("id"));
				Thread.sleep(2000);
			}
		}
		
		if(subLessonPage.getBtnPeriksa().getAttribute("disabled")!=null){
			hardAssert.fail("Tombol periksa tikda bisa diklik sesudah semua jawaban diisi");
		}
	}
	
	@Test
	public void test6() throws InterruptedException{
		Thread.sleep(1000);
		for(int i=0;i<pilihanJawaban.size();i++){
			for(int j=0;j<pilihanJawaban.get(i).size();j++){
				if(subLessonPage.getLittleBoxMultipleChoice().getAllAnswer().get(i).get(j).getAttribute("value").equals(jawabanBenar.get(i))){
					subLessonPage.getLittleBoxMultipleChoice().answerClick(subLessonPage.getLittleBoxMultipleChoice().getAllAnswer().get(i).get(j).getAttribute("id"));
					Thread.sleep(2000);
				}
			}
		}
		
		subLessonPage.getBtnPeriksa().click();
		Thread.sleep(2000);
		String status[] = subLessonPage.getLittleBoxMultipleChoice().getStatus().getAttribute("class").split(" ");
		if(status[status.length-1].equals("true")==false)hardAssert.fail("Hasil akhir seharusnya benar");
	}
	
	@Test
	public void test7() throws InterruptedException{
		Thread.sleep(1000);
		for(int i=0;i<pilihanJawaban.size();i++){
			for(int j=0;j<pilihanJawaban.get(i).size();j++){
				if(subLessonPage.getLittleBoxMultipleChoice().getAllAnswer().get(i).get(j).getAttribute("value").equals(jawabanSalah.get(i))){
					subLessonPage.getLittleBoxMultipleChoice().answerClick(subLessonPage.getLittleBoxMultipleChoice().getAllAnswer().get(i).get(j).getAttribute("id"));
					Thread.sleep(2000);
				}
			}
		}
		
		subLessonPage.getBtnPeriksa().click();
		Thread.sleep(2000);
		String status[] = subLessonPage.getLittleBoxMultipleChoice().getStatus().getAttribute("class").split(" ");
		if(status[status.length-1].equals("false")==false)hardAssert.fail("Hasil akhir seharusnya benar");
	}
	
	@Test
	public void test8and9() throws InterruptedException{
		Thread.sleep(1000);
		for(int i=0;i<pilihanJawaban.size();i++){
			for(int j=0;j<pilihanJawaban.get(i).size();j++){
				if(subLessonPage.getLittleBoxMultipleChoice().getAllAnswer().get(i).get(j).getAttribute("value").equals(jawabanSalah.get(i))){
					subLessonPage.getLittleBoxMultipleChoice().answerClick(subLessonPage.getLittleBoxMultipleChoice().getAllAnswer().get(i).get(j).getAttribute("id"));
					if(subLessonPage.getLittleBoxMultipleChoice().getAllAnswer().get(i).get(j).getAttribute("value").equals(jawabanBenar.get(i))){
						tampilanJawaban.add("true");
					}else{
						tampilanJawaban.add("false");
					}
					tampilanJawabanID.add(subLessonPage.getLittleBoxMultipleChoice().getAllAnswer().get(i).get(j).getAttribute("id"));
					Thread.sleep(2000);
				}
			}
		}
		
		subLessonPage.getBtnPeriksa().click();
		Thread.sleep(2000);
		for(int i=0;i<pilihanJawaban.size();i++){
			String status[] = subLessonPage.getLittleBoxMultipleChoice().getboxAnswer(tampilanJawabanID.get(i)).getAttribute("class").split(" ");
			if(tampilanJawaban.get(i).equals(status[status.length-1])==false){
				hardAssert.fail("Tampilan jawaban yang benar dan salah tidak sesuai");
			}
		}
	}
	
	@AfterMethod
	public void destroy(){
		subLessonPage.destroy("LittleBoxMultipleChoice");
	}
	
	@AfterSuite
	public void afterSuite(){
		subLessonPage.closeBrowser();
	}
}

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

public class BoxMatchSentence_TestCase {
	Actions action = null;
	
	SubLessonPage subLessonPage = new SubLessonPage();
	
	private Assertion hardAssert = new Assertion();
	
	String url = "http://10.10.24.10/ngeadmin/previewCaseNewTab/5680e70a938e8e173c8b456d";
	String instruksi = "Pasangkan dengan respon yang tepat";
	
	ArrayList<String> pertanyaan = new ArrayList<String>();
	
	ArrayList<String> pilihanJawaban = new ArrayList<String>();
	ArrayList<String> jawabanBenar = new ArrayList<String>();
	ArrayList<String> jawabanSalah = new ArrayList<String>();
	ArrayList<String> jawabanSalah2 = new ArrayList<String>();
	
	ArrayList<String> tampilanJawaban = new ArrayList<String>();
	ArrayList<Integer> urutan = new ArrayList<Integer>();
	
	@BeforeClass
	public void BeforeClass() throws InterruptedException{
		pertanyaan.add("Good afternoon, Julia.");
		pertanyaan.add("I'm fine, thank you.");
		pertanyaan.add("Nice to see you too, Tony");
		
		pilihanJawaban.add("Good afternoon, Sadie.");
		pilihanJawaban.add("How are you doing?");
		pilihanJawaban.add("Nice to see you, Britanny.");
		
		jawabanBenar.add("Good afternoon, Sadie.");
		jawabanBenar.add("How are you doing?");
		jawabanBenar.add("Nice to see you, Britanny.");
		
		jawabanSalah.add("Good afternoon, Sadie.");
		jawabanSalah.add("Nice to see you, Britanny.");
		jawabanSalah.add("How are you doing?");
		
		jawabanSalah2.add("Nice to see you, Britanny.");
		jawabanSalah2.add("Good afternoon, Sadie.");
		jawabanSalah2.add("How are you doing?");
		
		action = new Actions(subLessonPage.getDriver());
		
		///subLessonPage.login();
	}
	
	@BeforeMethod
	public void BeforeMethod() throws InterruptedException{
		subLessonPage.getUrl(url);
	}
	
	@Test
	public void test1() throws InterruptedException{
		Thread.sleep(1000);
		if(subLessonPage.getBoxMatchSentence().instruction.getText().equals(instruksi)==false){
			hardAssert.fail("Instruksi tidak sama");
		}
	}
	
	@Test
	public void test2() throws InterruptedException{
		Thread.sleep(1000);
		if(pertanyaan.size()!=subLessonPage.getBoxMatchSentence().getQuestion().size()){
			hardAssert.fail("Jumlah pertanyaan tidak sama dengan database");
		}
		for(int i=0;i<subLessonPage.getBoxMatchSentence().getQuestion().size();i++){
			if(subLessonPage.getBoxMatchSentence().getQuestion().get(i).getText().equals(pertanyaan.get(i))==false){
				hardAssert.fail("Pertanyaan " + subLessonPage.getBoxMatchSentence().getQuestion().get(i).getText()+ " tidak sama dengan yang di database");
			}
		}
	}
	
	@Test
	public void test3() throws InterruptedException{
		Thread.sleep(1000);
		if(pilihanJawaban.size()!=subLessonPage.getBoxMatchSentence().getBoxAnswer().size()){
			hardAssert.fail("Jumlah pertanyaan tidak sama dengan database");
		}
		for(int i=0;i<subLessonPage.getBoxMatchSentence().getBoxAnswer().size();i++){
			if(pilihanJawaban.contains(subLessonPage.getBoxMatchSentence().getBoxAnswer().get(i).getText())==false){
				hardAssert.fail("pilihan jawaban " + subLessonPage.getBoxMatchSentence().getBoxAnswer().get(i).getText()+ " tidak sama dengan yang di database");
			}
		}
	}
	
	@Test
	public void test4() throws InterruptedException{
		if(subLessonPage.getBtnPeriksa().getAttribute("disabled")==null){
			hardAssert.fail("Tombol periksa bisa diklik sebelum semua jawaban di drag");
		}
		
		for(int i=0;i<subLessonPage.getBoxMatchSentence().getBoxAnswer().size()-1;i++){
			action.dragAndDrop(subLessonPage.getBoxMatchSentence().getBoxAnswer().get(i), subLessonPage.getBoxMatchSentence().getDropBox().get(i)).perform();
			Thread.sleep(3000);
			if(i==subLessonPage.getBoxMatchSentence().getBoxAnswer().size()-1 && subLessonPage.getBtnPeriksa().getAttribute("disabled")!=null){
				hardAssert.fail("Tombol periksa tidak bisa diklik sesudah semua jawaban di drag");
			}
		}
	}
	
	@Test
	public void test5() throws InterruptedException{
		if(subLessonPage.getBtnPeriksa().getAttribute("disabled")==null){
			hardAssert.fail("Tombol periksa bisa diklik sebelum semua jawaban di drag");
		}
		
		for(int i=0;i<subLessonPage.getBoxMatchSentence().getBoxAnswer().size();i++){
			action.dragAndDrop(subLessonPage.getBoxMatchSentence().getBoxAnswer().get(i), subLessonPage.getBoxMatchSentence().getDropBox().get(i)).perform();
			Thread.sleep(3000);
		}
		
		if(subLessonPage.getBtnPeriksa().getAttribute("disabled")!=null){
			hardAssert.fail("Tombol periksa tidak bisa diklik sesudah semua jawaban di drag");
		}
	}
	
	@Test
	public void test6() throws InterruptedException{
		Thread.sleep(1000);
		for(int i=0;i<subLessonPage.getBoxMatchSentence().getBoxAnswer().size();i++){
			Integer index = jawabanBenar.indexOf(subLessonPage.getBoxMatchSentence().getBoxAnswer().get(i).getText());
			if(index!=-1){
				action.dragAndDrop(subLessonPage.getBoxMatchSentence().getBoxAnswer().get(i), subLessonPage.getBoxMatchSentence().getDropBox().get(index)).perform();
				Thread.sleep(3000);
			}
		}
		
		subLessonPage.getBtnPeriksa().click();
		Thread.sleep(2000);
		String status[] = subLessonPage.getStatus().getAttribute("class").split(" ");
		if(status[status.length-1].equals("true")==false)hardAssert.fail("Hasil akhir seharusnya benar");
	}
	
	@Test
	public void test7() throws InterruptedException{
		Thread.sleep(1000);
		for(int i=0;i<subLessonPage.getBoxMatchSentence().getBoxAnswer().size();i++){
			Integer index = jawabanSalah.indexOf(subLessonPage.getBoxMatchSentence().getBoxAnswer().get(i).getText());
			if(index!=-1){
				action.dragAndDrop(subLessonPage.getBoxMatchSentence().getBoxAnswer().get(i), subLessonPage.getBoxMatchSentence().getDropBox().get(index)).perform();
				Thread.sleep(3000);
			}
		}
		
		subLessonPage.getBtnPeriksa().click();
		Thread.sleep(2000);
		String status[] = subLessonPage.getStatus().getAttribute("class").split(" ");
		if(status[status.length-1].equals("false")==false)hardAssert.fail("Hasil akhir seharusnya salah");
	}
	
	@Test
	public void test8() throws InterruptedException{
		Thread.sleep(1000);
		for(int i=0;i<subLessonPage.getBoxMatchSentence().getBoxAnswer().size();i++){
			Integer index = jawabanSalah2.indexOf(subLessonPage.getBoxMatchSentence().getBoxAnswer().get(i).getText());
			if(index!=-1){
				action.dragAndDrop(subLessonPage.getBoxMatchSentence().getBoxAnswer().get(i), subLessonPage.getBoxMatchSentence().getDropBox().get(index)).perform();
				Thread.sleep(3000);
			}
		}
		
		subLessonPage.getBtnPeriksa().click();
		Thread.sleep(2000);
		String status[] = subLessonPage.getStatus().getAttribute("class").split(" ");
		if(status[status.length-1].equals("false")==false)hardAssert.fail("Hasil akhir seharusnya salah");
	}
	
	@Test
	public void test9and10() throws InterruptedException{
		Thread.sleep(1000);
		for(int i=0;i<subLessonPage.getBoxMatchSentence().getBoxAnswer().size();i++){
			Integer index = jawabanSalah.indexOf(subLessonPage.getBoxMatchSentence().getBoxAnswer().get(i).getText());
			if(index!=-1){
				action.dragAndDrop(subLessonPage.getBoxMatchSentence().getBoxAnswer().get(i), subLessonPage.getBoxMatchSentence().getDropBox().get(index)).perform();
				Thread.sleep(3000);
				if(jawabanBenar.indexOf(subLessonPage.getBoxMatchSentence().getBoxAnswer().get(i).getText())== jawabanSalah.indexOf(subLessonPage.getBoxMatchSentence().getBoxAnswer().get(i).getText())){
					tampilanJawaban.add("true");
					urutan.add(i);
				}else{
					tampilanJawaban.add("false");
					urutan.add(i);
				}
			}
		}
		
		subLessonPage.getBtnPeriksa().click();
		Thread.sleep(3000);
		
		for(int i=0;i<tampilanJawaban.size();i++){
			String status[] = subLessonPage.getBoxMatchSentence().getBoxAnswer().get(urutan.get(i)).getAttribute("class").split(" ");
			if(tampilanJawaban.get(i).equals(status[status.length-1])==false){
				hardAssert.fail("Tampilan jawaban yang benar dan salah tidak sesuai");
			}
		}
	}
	
	@AfterMethod
	public void destroy(){
		subLessonPage.destroy("BoxMatchSentence");
	}
	
	@AfterSuite
	public void afterSuite(){
		subLessonPage.closeBrowser();
	}
}

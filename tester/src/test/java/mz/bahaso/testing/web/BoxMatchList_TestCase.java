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

public class BoxMatchList_TestCase {
	Actions action = null;
	
	SubLessonPage subLessonPage = new SubLessonPage();
	
	private Assertion hardAssert = new Assertion();
	
	
	String url = "http://10.10.24.10/ngeadmin/previewCaseNewTab/5680dd7d938e8e7f2c8b4569";
	String instruksi = "Lengkapi bagian yang kosong di setiap kalimat";
	
	ArrayList<String> pertanyaan = new ArrayList<String>();
	ArrayList<String> pilihanjawaban = new ArrayList<String>();
	
	ArrayList<String> jawabanBenar = new ArrayList<String>();
	ArrayList<String> jawabanSalah = new ArrayList<String>();
	ArrayList<String> jawabanSalah2 = new ArrayList<String>();
	
	ArrayList<String> tampilanJawaban = new ArrayList<String>();
	ArrayList<Integer> urutan = new ArrayList<Integer>();
	
	@BeforeClass
	public void BeforeClass() throws InterruptedException{
		pertanyaan.add("Don: Good , April.");
		pertanyaan.add("April: morning, Don.");
		pertanyaan.add("Don: you, April.");
		pertanyaan.add("April: Nice to see you , Don.");
		
		pilihanjawaban.add("morning");
		pilihanjawaban.add("Good");
		pilihanjawaban.add("Nice to see");
		pilihanjawaban.add("too");
		
		jawabanBenar.add("morning");
		jawabanBenar.add("Good");
		jawabanBenar.add("Nice to see");
		jawabanBenar.add("too");
		
		jawabanSalah.add("morning");
		jawabanSalah.add("too");
		jawabanSalah.add("Nice to see");
		jawabanSalah.add("Good");
		
		jawabanSalah2.add("Nice to see");
		jawabanSalah2.add("morning");
		jawabanSalah2.add("too");
		jawabanSalah2.add("Good");
		
		action = new Actions(subLessonPage.getDriver());
	}
	
	@BeforeMethod
	public void BeforeMethod() throws InterruptedException{
		subLessonPage.getUrl(url);
	}
	
	@Test
	public void test1() throws InterruptedException{
		Thread.sleep(1000);
		if(subLessonPage.getBoxMatchList().instruction.getText().equals(instruksi)==false){
			hardAssert.fail("Instruksi tidak sama");
		}
	}
	
	@Test
	public void test2() throws InterruptedException{
		Thread.sleep(1000);
		if(pertanyaan.size()!=subLessonPage.getBoxMatchList().getQuestion().size()){
			hardAssert.fail("Jumlah pertanyaan tidak sama dengan database");
		}
		for(int i=0;i<subLessonPage.getBoxMatchList().getQuestion().size();i++){
			if(subLessonPage.getBoxMatchList().getQuestion().get(i).getText().equals(pertanyaan.get(i))==false){
				hardAssert.fail("Pertanyaan " + subLessonPage.getBoxMatchList().getQuestion().get(i).getText()+ " tidak sama dengan yang di database");
			}
		}
	}
	
	@Test
	public void test3() throws InterruptedException{
		Thread.sleep(1000);
		if(pilihanjawaban.size()!=subLessonPage.getBoxMatchList().getBoxAnswer().size()){
			hardAssert.fail("Jumlah pertanyaan tidak sama dengan database");
		}
		for(int i=0;i<subLessonPage.getBoxMatchList().getBoxAnswer().size();i++){
			if(pilihanjawaban.contains(subLessonPage.getBoxMatchList().getBoxAnswer().get(i).getText())==false){
				hardAssert.fail("pilihan jawaban " + subLessonPage.getBoxMatchList().getBoxAnswer().get(i).getText()+ " tidak sama dengan yang di database");
			}
		}
	}
	
	@Test
	public void test4() throws InterruptedException{
		if(subLessonPage.getBtnPeriksa().getAttribute("disabled")==null){
			hardAssert.fail("Tombol periksa bisa diklik sebelum semua jawaban di drag");
		}
		
		for(int i=0;i<subLessonPage.getBoxMatchList().getBoxAnswer().size()-1;i++){
			action.dragAndDrop(subLessonPage.getBoxMatchList().getBoxAnswer().get(i), subLessonPage.getBoxMatchList().getDropBox().get(i)).perform();
			Thread.sleep(3000);
			if(i==subLessonPage.getBoxMatchList().getBoxAnswer().size()-1 && subLessonPage.getBtnPeriksa().getAttribute("disabled")!=null){
				hardAssert.fail("Tombol periksa tidak bisa diklik sesudah semua jawaban di drag");
			}
		}
	}
	
	@Test
	public void test5() throws InterruptedException{
		if(subLessonPage.getBtnPeriksa().getAttribute("disabled")==null){
			hardAssert.fail("Tombol periksa bisa diklik sebelum semua jawaban di drag");
		}
		
		for(int i=0;i<subLessonPage.getBoxMatchList().getBoxAnswer().size();i++){
			action.dragAndDrop(subLessonPage.getBoxMatchList().getBoxAnswer().get(i), subLessonPage.getBoxMatchList().getDropBox().get(i)).perform();
			Thread.sleep(3000);
			if(i==subLessonPage.getBoxMatchList().getBoxAnswer().size()-1 && subLessonPage.getBtnPeriksa().getAttribute("disabled")!=null){
				hardAssert.fail("Tombol periksa tidak bisa diklik sesudah semua jawaban di drag");
			}
		}
	}
	
	@Test
	public void test6() throws InterruptedException{
		Thread.sleep(1000);
		for(int i=0;i<subLessonPage.getBoxMatchList().getBoxAnswer().size();i++){
			Integer index = jawabanBenar.indexOf(subLessonPage.getBoxMatchList().getBoxAnswer().get(i).getText());
			if(index!=-1){
				action.dragAndDrop(subLessonPage.getBoxMatchList().getBoxAnswer().get(i), subLessonPage.getBoxMatchList().getDropBox().get(index)).perform();
				Thread.sleep(3000);
			}
		}
		
		subLessonPage.getBtnPeriksa().click();
		Thread.sleep(2000);
		String status[] = subLessonPage.getBoxMatchList().getStatus().getAttribute("class").split(" ");
		if(status[status.length-1].equals("true")==false)hardAssert.fail("Hasil akhir seharusnya salah");
	}
	
	@Test
	public void test7() throws InterruptedException{
		Thread.sleep(1000);
		for(int i=0;i<subLessonPage.getBoxMatchList().getBoxAnswer().size();i++){
			Integer index = jawabanSalah.indexOf(subLessonPage.getBoxMatchList().getBoxAnswer().get(i).getText());
			if(index!=-1){
				action.dragAndDrop(subLessonPage.getBoxMatchList().getBoxAnswer().get(i), subLessonPage.getBoxMatchList().getDropBox().get(index)).perform();
				Thread.sleep(3000);
			}
		}
		
		subLessonPage.getBtnPeriksa().click();
		Thread.sleep(2000);
		String status[] = subLessonPage.getBoxMatchList().getStatus().getAttribute("class").split(" ");
		if(status[status.length-1].equals("false")==false)hardAssert.fail("Hasil akhir seharusnya salah");
	}
	
	@Test
	public void test8() throws InterruptedException{
		Thread.sleep(1000);
		for(int i=0;i<subLessonPage.getBoxMatchList().getBoxAnswer().size();i++){
			Integer index = jawabanSalah2.indexOf(subLessonPage.getBoxMatchList().getBoxAnswer().get(i).getText());
			if(index!=-1){
				action.dragAndDrop(subLessonPage.getBoxMatchList().getBoxAnswer().get(i), subLessonPage.getBoxMatchList().getDropBox().get(index)).perform();
				Thread.sleep(3000);
			}
		}
		
		subLessonPage.getBtnPeriksa().click();
		Thread.sleep(2000);
		String status[] = subLessonPage.getBoxMatchList().getStatus().getAttribute("class").split(" ");
		if(status[status.length-1].equals("false")==false)hardAssert.fail("Hasil akhir seharusnya salah");
	}
	
	@Test
	public void test9and10() throws InterruptedException{
		Thread.sleep(1000);
		for(int i=0;i<subLessonPage.getBoxMatchList().getBoxAnswer().size();i++){
			Integer index = jawabanSalah.indexOf(subLessonPage.getBoxMatchList().getBoxAnswer().get(i).getText());
			if(index!=-1){
				action.dragAndDrop(subLessonPage.getBoxMatchList().getBoxAnswer().get(i), subLessonPage.getBoxMatchList().getDropBox().get(index)).perform();
				Thread.sleep(3000);
				if(jawabanBenar.indexOf(subLessonPage.getBoxMatchList().getBoxAnswer().get(i).getText())== jawabanSalah.indexOf(subLessonPage.getBoxMatchList().getBoxAnswer().get(i).getText())){
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
			String status[] = subLessonPage.getBoxMatchList().getBoxAnswer().get(urutan.get(i)).getAttribute("class").split(" ");
			if(tampilanJawaban.get(i).equals(status[status.length-1])==false){
				hardAssert.fail("Tampilan jawaban yang benar dan salah tidak sesuai");
			}
		}
	}
	
	@AfterMethod
	public void destroy(){
		subLessonPage.destroy("BoxMatchList");
	}
	
	@AfterSuite
	public void afterSuite(){
		subLessonPage.closeBrowser();
	}
}

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

public class DragMultipleChoice_TestCase {
	Actions action = null;
	
	SubLessonPage subLessonPage = new SubLessonPage();
	
	private Assertion hardAssert = new Assertion();
	
	String url = "http://10.10.24.10/ngeadmin/previewCaseNewTab/568b3969938e8e4d3d8b4656";
	String instruksi = "Pilihlah bentuk kata ganti objek yang tepat";
	String pertanyaan = "I bought John a new sweater.";
	String pertanyaanInfo = "sentence";
	String jawabanInfo = "object pronoun";
	
	ArrayList<String> pilihanjawaban = new ArrayList<String>();
	ArrayList<String> jawabanBenar = new ArrayList<String>();
	ArrayList<String> jawabanSalah = new ArrayList<String>();
	
	ArrayList<String> tampilanJawaban;
	ArrayList<Integer> urutan;
	
	@BeforeClass
	public void BeforeClass() throws InterruptedException{
		action = new Actions(subLessonPage.getDriver());
		
		pilihanjawaban.add("her");
		pilihanjawaban.add("his");
		pilihanjawaban.add("him");
		
		jawabanBenar.add("him");
		jawabanSalah.add("her");
		
	}
	
	@BeforeMethod
	public void BeforeMethod() throws InterruptedException{
		subLessonPage.getUrl(url);
	}
	
	@Test
	public void test1() throws InterruptedException{
		Thread.sleep(1000);
		if(subLessonPage.getDragMultipleChoice().instruction.getText().equals(instruksi)==false){
			hardAssert.fail("Instruksi tidak sama");
		}
	}
	
	@Test
	public void test2() throws InterruptedException{
		Thread.sleep(1000);
		if(subLessonPage.getDragMultipleChoice().question.getText().equals(pertanyaan)==false){
			hardAssert.fail("Pertanyaan tidak sama");
		}
	}
	
	@Test
	public void test3() throws InterruptedException{
		Thread.sleep(1000);
		if(subLessonPage.getDragMultipleChoice().questionInfo.getText().equals(pertanyaanInfo)==false){
			hardAssert.fail("Pertanyaan info tidak sama");
		}
	}
	
	@Test
	public void test4() throws InterruptedException{
		Thread.sleep(1000);
		if(pilihanjawaban.size()!=subLessonPage.getDragMultipleChoice().getBoxAnswer().size()){
			hardAssert.fail("Jumlah pertanyaan tidak sama dengan database");
		}
		for(int i=0;i<subLessonPage.getDragMultipleChoice().getBoxAnswer().size();i++){
			if(pilihanjawaban.contains(subLessonPage.getDragMultipleChoice().getBoxAnswer().get(i).getText())==false){
				hardAssert.fail("pilihan jawaban " + subLessonPage.getDragMultipleChoice().getBoxAnswer().get(i).getText()+ " tidak sama dengan yang di database");
			}
		}
	}
	
	@Test
	public void test5() throws InterruptedException{
		Thread.sleep(1000);
		if(subLessonPage.getDragMultipleChoice().answerInfo.getText().equals(jawabanInfo)==false){
			hardAssert.fail("jawaban info tidak sama");
		}
	}
	
	@Test
	public void test6() throws InterruptedException{
		Thread.sleep(1000);
		if(subLessonPage.getBtnPeriksa().getAttribute("disabled")==null){
			hardAssert.fail("Tombol periksa bisa diklik sebelum semua jawaban di drag");
		}
		
		for(int i=0;i<subLessonPage.getDragMultipleChoice().getDropBox().size()-1;i++){
			action.dragAndDrop(subLessonPage.getDragMultipleChoice().getBoxAnswer().get(i), subLessonPage.getDragMultipleChoice().getDropBox().get(i)).perform();
			Thread.sleep(3000);
			if(i==subLessonPage.getDragMultipleChoice().getBoxAnswer().size()-1 && subLessonPage.getBtnPeriksa().getAttribute("disabled")!=null){
				hardAssert.fail("Tombol periksa tidak bisa diklik sesudah semua jawaban di drag");
			}
		}
	}
	
	@Test
	public void test7() throws InterruptedException{
		Thread.sleep(1000);
		if(subLessonPage.getBtnPeriksa().getAttribute("disabled")==null){
			hardAssert.fail("Tombol periksa bisa diklik sebelum semua jawaban di drag");
		}
		
		for(int i=0;i<subLessonPage.getDragMultipleChoice().getDropBox().size();i++){
			action.dragAndDrop(subLessonPage.getDragMultipleChoice().getBoxAnswer().get(i), subLessonPage.getDragMultipleChoice().getDropBox().get(i)).perform();
			Thread.sleep(3000);
			if(i==subLessonPage.getDragMultipleChoice().getBoxAnswer().size()-1 && subLessonPage.getBtnPeriksa().getAttribute("disabled")!=null){
				hardAssert.fail("Tombol periksa tidak bisa diklik sesudah semua jawaban di drag");
			}
		}
	}
	
	@Test
	public void test8() throws InterruptedException{
		Thread.sleep(1000);
		for(int i=0;i<subLessonPage.getDragMultipleChoice().getBoxAnswer().size();i++){
			Integer index = jawabanBenar.indexOf(subLessonPage.getDragMultipleChoice().getBoxAnswer().get(i).getText());
			if(index!=-1){
				action.dragAndDrop(subLessonPage.getDragMultipleChoice().getBoxAnswer().get(i), subLessonPage.getDragMultipleChoice().getDropBox().get(index)).perform();
				Thread.sleep(3000);
			}
		}
		
		subLessonPage.getBtnPeriksa().click();
		Thread.sleep(2000);
		String status[] = subLessonPage.getStatus().getAttribute("class").split(" ");
		if(status[status.length-1].equals("true")==false)hardAssert.fail("Hasil akhir seharusnya benar");
	}
	
	@Test
	public void test9() throws InterruptedException{
		Thread.sleep(1000);
		for(int i=0;i<subLessonPage.getDragMultipleChoice().getBoxAnswer().size();i++){
			Integer index = jawabanSalah.indexOf(subLessonPage.getDragMultipleChoice().getBoxAnswer().get(i).getText());
			if(index!=-1){
				action.dragAndDrop(subLessonPage.getDragMultipleChoice().getBoxAnswer().get(i), subLessonPage.getDragMultipleChoice().getDropBox().get(index)).perform();
				Thread.sleep(3000);
			}
		}
		
		subLessonPage.getBtnPeriksa().click();
		Thread.sleep(2000);
		String status[] = subLessonPage.getStatus().getAttribute("class").split(" ");
		if(status[status.length-1].equals("false")==false)hardAssert.fail("Hasil akhir seharusnya salah");
	}
	
	@Test
	public void test10() throws InterruptedException{
		urutan = new ArrayList<Integer>();
		tampilanJawaban = new ArrayList<String>();
		Thread.sleep(1000);
		for(int i=0;i<subLessonPage.getDragMultipleChoice().getBoxAnswer().size();i++){
			Integer index = jawabanSalah.indexOf(subLessonPage.getDragMultipleChoice().getBoxAnswer().get(i).getText());
			if(index!=-1){
				action.dragAndDrop(subLessonPage.getDragMultipleChoice().getBoxAnswer().get(i), subLessonPage.getDragMultipleChoice().getDropBox().get(index)).perform();
				Thread.sleep(3000);
				if(jawabanBenar.indexOf(subLessonPage.getDragMultipleChoice().getBoxAnswer().get(i).getText())== jawabanSalah.indexOf(subLessonPage.getDragMultipleChoice().getBoxAnswer().get(i).getText())){
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
			String status[] = subLessonPage.getDragMultipleChoice().getBoxAnswer().get(urutan.get(i)).getAttribute("class").split(" ");
			if(tampilanJawaban.get(i).equals(status[status.length-1])==false){
				hardAssert.fail("Tampilan jawaban yang benar dan salah tidak sesuai");
			}
		}
		tampilanJawaban.clear();
	}
	
	@Test
	public void test11() throws InterruptedException{
		urutan = new ArrayList<Integer>();
		tampilanJawaban = new ArrayList<String>();
		Thread.sleep(1000);
		for(int i=0;i<subLessonPage.getDragMultipleChoice().getBoxAnswer().size();i++){
			Integer index = jawabanBenar.indexOf(subLessonPage.getDragMultipleChoice().getBoxAnswer().get(i).getText());
			if(index!=-1){
				action.dragAndDrop(subLessonPage.getDragMultipleChoice().getBoxAnswer().get(i), subLessonPage.getDragMultipleChoice().getDropBox().get(index)).perform();
				Thread.sleep(3000);
				if(jawabanBenar.indexOf(subLessonPage.getDragMultipleChoice().getBoxAnswer().get(i).getText())== jawabanBenar.indexOf(subLessonPage.getDragMultipleChoice().getBoxAnswer().get(i).getText())){
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
			String status[] = subLessonPage.getDragMultipleChoice().getBoxAnswer().get(urutan.get(i)).getAttribute("class").split(" ");
			if(tampilanJawaban.get(i).equals(status[status.length-1])==false){
				hardAssert.fail("Tampilan jawaban yang benar dan salah tidak sesuai " + status[status.length-1] + " == " +tampilanJawaban.get(i));
			}
		}
	}
	
	@AfterMethod
	public void destroy(){
		subLessonPage.destroy("DragMultipleChoice");
	}
	
	@AfterSuite
	public void afterSuite(){
		subLessonPage.closeBrowser();
	}
}

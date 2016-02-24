package mz.bahaso.testing.web;

import java.util.ArrayList;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

import mz.page.web.SubLessonPage;

public class LostWordType_TestCase {
	SubLessonPage subLessonPage = new SubLessonPage();
	
	private Assertion hardAssert = new Assertion();
	
	String url = "http://10.10.24.10/ngeadmin/previewCaseNewTab/56826370938e8eed498b4568";
	String instruksi = "Tulis jawaban yang tepat di kotak yang tersedia";
	
	ArrayList<String> pertanyaan = new ArrayList<String>();
	ArrayList<String> jawabanBenar = new ArrayList<String>();
	ArrayList<String> jawabanSalah = new ArrayList<String>();
	
	ArrayList<String> tampilanJawaban = new ArrayList<String>();
	
	@BeforeClass
	public void BeforeClass() throws InterruptedException{
		pertanyaan.add("They are armchairs = armchairs? Yes, .");
		pertanyaan.add("It is an orange = an apple? No, .");
		pertanyaan.add("It is an aquarium = an aquarium? Yes, .");
		pertanyaan.add("They are earphones = televisions?No, .");
		
		jawabanBenar.add("Are they");
		jawabanBenar.add("they are");
		jawabanBenar.add("Is it");
		jawabanBenar.add("it isn't");
		jawabanBenar.add("Is it");
		jawabanBenar.add("it is");
		jawabanBenar.add("Are they");
		jawabanBenar.add("they aren't");
		
		jawabanSalah.add("they are");
		jawabanSalah.add("Are they");
		jawabanSalah.add("Is it");
		jawabanSalah.add("it isn't");
		jawabanSalah.add("Is it");
		jawabanSalah.add("it is");
		jawabanSalah.add("they aren't");
		jawabanSalah.add("Are they");
		
		//subLessonPage.login();
	}
	
	@BeforeMethod
	public void BeforeMethod() throws InterruptedException{
		subLessonPage.getUrl(url);
	}
	
	@Test
	public void test1() throws InterruptedException{
		Thread.sleep(1000);
		if(subLessonPage.getLostWordType().instruction.getText().equals(instruksi)==false){
			hardAssert.fail("Instruksi tidak sama");
		}
	}
	
	@Test
	public void test2() throws InterruptedException{
		Thread.sleep(1000);
		for(int i=0;i<subLessonPage.getLostWordType().getQuestion().size();i++){
			//System.out.println(subLessonPage.getLostWordType().getQuestion().get(i).getText());
			if(subLessonPage.getLostWordType().getQuestion().get(i).getText().equals(pertanyaan.get(i))==false){
				hardAssert.fail("pertanyaan ke " + (i+1) + " tidak sama dengan yang di database");
			}
		}
	}
	
	@Test
	public void test3() throws InterruptedException{
		Thread.sleep(1000);
		if(subLessonPage.getBtnPeriksa().getAttribute("disabled")==null){
			hardAssert.fail("Tombol periksa bisa diklik sebelum semua pertanyaan dijawab");
		}
		
		for(int i=0;i<subLessonPage.getLostWordType().getBoxAnswer().size()-1;i++){
			subLessonPage.getLostWordType().getBoxAnswer().get(i).sendKeys("asd");
			Thread.sleep(1000);
			if(subLessonPage.getBtnPeriksa().getAttribute("disabled")==null){
				hardAssert.fail("Tombol periksa bisa diklik sebelum semua pertanyaan dijawab");
			}
		}
	}
	
	@Test
	public void test4() throws InterruptedException{
		Thread.sleep(1000);
		for(int i=0;i<subLessonPage.getLostWordType().getBoxAnswer().size();i++){
			subLessonPage.getLostWordType().getBoxAnswer().get(i).sendKeys("asd");
			Thread.sleep(1000);
		}
		
		if(subLessonPage.getBtnPeriksa().getAttribute("disabled")!=null){
			hardAssert.fail("Tombol periksa tidak bisa diklik sesudah semua pertanyaan dijawab");
		}
	}
	
	@Test
	public void test5() throws InterruptedException{
		Thread.sleep(1000);
		for(int i=0;i<subLessonPage.getLostWordType().getBoxAnswer().size();i++){
			subLessonPage.getLostWordType().getBoxAnswer().get(i).sendKeys(jawabanBenar.get(i));
			Thread.sleep(1000);
		}
		
		subLessonPage.getBtnPeriksa().click();
		Thread.sleep(2000);
		String status[] = subLessonPage.getStatus().getAttribute("class").split(" ");
		if(status[status.length-1].equals("true")==false)hardAssert.fail("Hasil akhir seharusnya benar");
	}
	
	@Test
	public void test6() throws InterruptedException{
		Thread.sleep(1000);
		for(int i=0;i<subLessonPage.getLostWordType().getBoxAnswer().size();i++){
			subLessonPage.getLostWordType().getBoxAnswer().get(i).sendKeys(jawabanSalah.get(i));
			Thread.sleep(1000);
		}
		
		subLessonPage.getBtnPeriksa().click();
		Thread.sleep(2000);
		String status[] = subLessonPage.getStatus().getAttribute("class").split(" ");
		if(status[status.length-1].equals("false")==false)hardAssert.fail("Hasil akhir seharusnya salah");
	}
	
	@Test
	public void test7and8() throws InterruptedException{
		Thread.sleep(1000);
		for(int i=0;i<subLessonPage.getLostWordType().getBoxAnswer().size();i++){
			subLessonPage.getLostWordType().getBoxAnswer().get(i).sendKeys(jawabanSalah.get(i));
			if(jawabanSalah.get(i).equals(jawabanBenar.get(i))){
				tampilanJawaban.add("true");
			}else{
				tampilanJawaban.add("false");
			}
			Thread.sleep(1000);
		}
		
		subLessonPage.getBtnPeriksa().click();
		Thread.sleep(2000);
		
		for(int i=0;i<subLessonPage.getLostWordType().getBoxAnswer().size();i++){
			String status[] = subLessonPage.getLostWordType().getBoxAnswer().get(i).getAttribute("class").split(" ");
			if(status[status.length-1].equals(tampilanJawaban.get(i))==false){
				if(tampilanJawaban.get(i)=="false"){
					hardAssert.fail("tampilan jawaban ke " + i + " seharusnya merah karena jawabannya salah");
				}else{
					hardAssert.fail("tampilan jawaban ke " + i + " seharusnya biru karena jawabannya benar");
				}
				
			}
		}
		
	}
	
	@AfterMethod
	public void destroy(){
		subLessonPage.destroy("LostWordType");
	}
	
	@AfterSuite
	public void afterSuite(){
		subLessonPage.closeBrowser();
	}
}

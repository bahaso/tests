package mz.bahaso.testing.web;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

import org.openqa.selenium.interactions.Actions;

import mz.page.web.SubLessonPage;

public class BoxMatchDissapear_TestCase{
	Actions action = null;
	
	SubLessonPage subLessonPage = new SubLessonPage();
	
	private Assertion hardAssert = new Assertion();
	private String kategori[] = {"greetings","leave taking"};
	
	Map<String,Integer> jawaban = new HashMap<String, Integer>();
	Map<String,Integer> jawabanSalah = new HashMap<String, Integer>();
	Map<String,Integer> jawabanSalah2 = new HashMap<String, Integer>();
	
	ArrayList<WebElement> Categories = new ArrayList<WebElement>();
	ArrayList<String> TampilanJawaban = new ArrayList<String>();
	
	String url = "http://10.10.24.10/ngeadmin/previewCaseNewTab/5680dfcb938e8e7f2c8b456a";
	String instruksi = "Letakkan ungkapan perpisahan dan sapaan berikut pada kategori yang tepat";
	
	@BeforeClass
	public void beforeClass() throws InterruptedException{
		jawaban.put("good morning",0);
		jawaban.put("good afternoon",0);
		jawaban.put("good evening",0);
		jawaban.put("good bye",1);
		jawaban.put("see you later",1);
		
		jawabanSalah.put("good morning",0);
		jawabanSalah.put("good afternoon",1);
		jawabanSalah.put("good evening",0);
		jawabanSalah.put("good bye",1);
		jawabanSalah.put("see you later",0);
		
		jawabanSalah2.put("good morning",0);
		jawabanSalah2.put("good afternoon",0);
		jawabanSalah2.put("good evening",0);
		jawabanSalah2.put("good bye",1);
		jawabanSalah2.put("see you later",0);
		action = new Actions(subLessonPage.getDriver());
		subLessonPage.login();
	}
	
	@BeforeMethod
	public void BeforeMethod() throws InterruptedException{
		subLessonPage.getUrl(url);
	}
	
	@Test
	public void test1() throws InterruptedException{
		Thread.sleep(1000);
		if(subLessonPage.getBoxMatchDisappear().instruction.getText().equals(instruksi)==false){
			hardAssert.fail("Instruksi tidak sama");
		}
	}
	
	@Test
	public void test2(){
		for(int i=0;i<subLessonPage.getBoxMatchDisappear().getCategories().size();i++){
			if(subLessonPage.getBoxMatchDisappear().getCategories().get(i).getText().equals(kategori[i])==false){
				hardAssert.fail("Kategori "+(i+1)+" yang berisi \""+subLessonPage.getBoxMatchDisappear().getCategories().get(i).getText()+"\" tidak sama dengan \""+kategori[i]+"\"");
			}
		}
	}
	
	@Test
	public void test3() throws InterruptedException{
		Thread.sleep(1000);
		if(jawaban.size()==subLessonPage.getBoxMatchDisappear().getBoxAnswer().size()){
			for(int i=0;i<jawaban.size();i++){
				if(jawaban.containsKey(subLessonPage.getBoxMatchDisappear().getBoxAnswer().get(i).getText())==false){
					hardAssert.fail(subLessonPage.getBoxMatchDisappear().getBoxAnswer().get(i).getText() + " tidak ada dalam admin panel");
				}
			}
		}else{
		   hardAssert.fail("Jumlah pilihan jawaban tidak sama dengan yang di admin panel");
		}
	}
	
	@Test
	public void test4() throws InterruptedException{
		Thread.sleep(1000);
		if(subLessonPage.getBtnPeriksa().getAttribute("disabled")==null){
			hardAssert.fail("Tombol periksa bisa diklik sebelum semua jawaban di drag");
		}
		for(int i=0;i<subLessonPage.getBoxMatchDisappear().getBoxAnswer().size()-1;i++){
			action.dragAndDrop(subLessonPage.getBoxMatchDisappear().getBoxAnswer().get(i), subLessonPage.getBoxMatchDisappear().getDropBox().get(0)).perform();
			Thread.sleep(3000);
			if(i<subLessonPage.getBoxMatchDisappear().getBoxAnswer().size()-1 && subLessonPage.getBtnPeriksa().getAttribute("disabled")==null){
				hardAssert.fail("Tombol periksa bisa diklik sebelum semua jawaban di drag");
			}
		}
	}
	
	@Test
	public void test5() throws InterruptedException{
		Thread.sleep(1000);
		if(subLessonPage.getBtnPeriksa().getAttribute("disabled")==null){
			hardAssert.fail("Tombol periksa bisa diklik sebelum semua jawaban di drag");
		}
		for(int i=0;i<subLessonPage.getBoxMatchDisappear().getBoxAnswer().size();i++){
			action.dragAndDrop(subLessonPage.getBoxMatchDisappear().BoxAnswer.get(i), subLessonPage.getBoxMatchDisappear().getDropBox().get(0)).perform();
			Thread.sleep(3000);
			if(i==subLessonPage.getBoxMatchDisappear().getBoxAnswer().size()-1 && subLessonPage.getBtnPeriksa().getAttribute("disabled")!=null){
				hardAssert.fail("Tombol periksa tidak bisa diklik sesudah semua jawaban di drag");
			}
		}
	}
	
	@Test
	public void test6() throws InterruptedException{
		Thread.sleep(2000);
		for(int i=0;i<subLessonPage.getBoxMatchDisappear().getBoxAnswer().size();i++){
			action.dragAndDrop(subLessonPage.getBoxMatchDisappear().BoxAnswer.get(i), subLessonPage.getBoxMatchDisappear().getDropBox().get(jawabanSalah.get(subLessonPage.getBoxMatchDisappear().getBoxAnswer().get(i).getText()))).perform();
			Thread.sleep(3000);
		}
		
		subLessonPage.getBtnPeriksa().click();
		Thread.sleep(2000);
		String status[] = subLessonPage.getBoxMatchDisappear().getStatus().getAttribute("class").split(" ");
		if(status[status.length-1].equals("false")==false)hardAssert.fail("Hasil akhir seharusnya salah");
	}
	
	@Test
	public void test7() throws InterruptedException{
		Thread.sleep(2000);
		for(int i=0;i<subLessonPage.getBoxMatchDisappear().getBoxAnswer().size();i++){
			action.dragAndDrop(subLessonPage.getBoxMatchDisappear().BoxAnswer.get(i), subLessonPage.getBoxMatchDisappear().getDropBox().get(jawaban.get(subLessonPage.getBoxMatchDisappear().getBoxAnswer().get(i).getText()))).perform();
			Thread.sleep(3000);
		}
		
		subLessonPage.getBtnPeriksa().click();
		Thread.sleep(2000);
		String status[] = subLessonPage.getBoxMatchDisappear().getStatus().getAttribute("class").split(" ");
		if(status[status.length-1].equals("true")==false)hardAssert.fail("Hasil akhir seharusnya benar");
	}
	
	@Test
	public void test8() throws InterruptedException{
		Thread.sleep(2000);
		for(int i=0;i<subLessonPage.getBoxMatchDisappear().getBoxAnswer().size();i++){
			action.dragAndDrop(subLessonPage.getBoxMatchDisappear().BoxAnswer.get(i), subLessonPage.getBoxMatchDisappear().getDropBox().get(jawabanSalah2.get(subLessonPage.getBoxMatchDisappear().getBoxAnswer().get(i).getText()))).perform();
			Thread.sleep(3000);
		}
		
		subLessonPage.getBtnPeriksa().click();
		Thread.sleep(2000);
		String status[] = subLessonPage.getBoxMatchDisappear().getStatus().getAttribute("class").split(" ");
		if(status[status.length-1].equals("false")==false)hardAssert.fail("Hasil akhir seharusnya salah");
	}
	
	@Test
	public void test9and10() throws InterruptedException{
		Thread.sleep(2000);
		for(int i=0;i<subLessonPage.getBoxMatchDisappear().getBoxAnswer().size();i++){
			action.dragAndDrop(subLessonPage.getBoxMatchDisappear().BoxAnswer.get(i), subLessonPage.getBoxMatchDisappear().getDropBox().get(jawabanSalah.get(subLessonPage.getBoxMatchDisappear().getBoxAnswer().get(i).getText()))).perform();
			if(jawaban.get(subLessonPage.getBoxMatchDisappear().getBoxAnswer().get(i).getText())==jawabanSalah.get(subLessonPage.getBoxMatchDisappear().getBoxAnswer().get(i).getText())){
				TampilanJawaban.add("true");
			}else{
				TampilanJawaban.add("false");
			}
			Thread.sleep(3000);
		}
		
		subLessonPage.getBtnPeriksa().click();
		Thread.sleep(2000);
		
		for(int i=0;i<TampilanJawaban.size();i++){
			String status[] = subLessonPage.getBoxMatchDisappear().getBoxAnswer().get(i).getAttribute("class").split(" ");
			if(TampilanJawaban.get(i).equals(status[status.length-1])==false){
				hardAssert.fail("Tampilan jawaban yang benar dan salah tidak sesuai");
			}
		}
	}
	
	@AfterMethod
	public void destroy(){
		subLessonPage.destroy("BoxMatchDissapear");
	}
	
	@AfterSuite
	public void afterSuite(){
		subLessonPage.closeBrowser();
	}
}

package com.selenium.tutorial;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class VerifyFiltertest {
	WebDriver driver;

	@Test
	public void test() {
	
	System.setProperty("webdriver.chrome.driver",".\\drivers\\chromedriver.exe");
	driver = new ChromeDriver();
	driver.get("https://www.olx.in/bangalore/cars/q-swift/");
	
	List<WebElement> alldata = driver.findElements(By.xpath("//*[@id=\"offers_table\"]/tbody/tr/td/table/tbody/tr/td[2]/h3/a/span"));
	
	Iterator<WebElement> itr = alldata.iterator();
	
	while(itr.hasNext()){
		String data = itr.next().getText();
		
		if(data.toLowerCase().contains("swift")) {
			System.out.println(data.toLowerCase());
		}else {
			Assert.assertTrue(false, data);
		}
		
	  }

	}
}

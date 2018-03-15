package com.selenium.tutorial;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class VerifyCollapsedAndExpandedObject {

	
	WebDriver driver;
	@Test
	public void test() throws Exception {
		
		System.setProperty("webdriver.chrome.driver",".\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.hdfcbank.com/nri_banking/payments/BillPay/BillPay.htm");
		
		String before = driver.findElement(By.xpath("//*[@id=\"nre_savings_acc\"]/ul/li[2]/h3")).getCssValue("background-image");
		System.out.println("before clicking"+before);
		if(before.contains("bg_collapsed_panel")) {
			Assert.assertTrue(true, before);
		}else{
			Assert.assertTrue(false, before);
		}
		
		driver.findElement(By.xpath("//*[@id=\"nre_savings_acc\"]/ul/li[2]/h3")).click();
		Thread.sleep(5000);
		String after = driver.findElement(By.xpath("//*[@id=\"nre_savings_acc\"]/ul/li[2]/h3")).getCssValue("background-image");
		System.out.println("after clicking"+after);
		if(after.contains("bg_expanded_panel")) {
			Assert.assertTrue(true, after);
		}else{
			Assert.assertTrue(false, before);
		}
	}
		
}

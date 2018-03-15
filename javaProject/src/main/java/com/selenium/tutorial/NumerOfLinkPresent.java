package com.selenium.tutorial;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class NumerOfLinkPresent {
	
	WebDriver driver;
	@Test
	public void test() throws Exception {
		
		System.setProperty("webdriver.chrome.driver",".\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");
		
		List<WebElement> tag = driver.findElements(By.tagName("a"));
		System.out.println("Totaltag link present on this page is:-"+""+tag.size());
		
	}
	@AfterTest
	public void endtest() {
		driver.quit();
	}
}	

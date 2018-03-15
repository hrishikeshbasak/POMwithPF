package com.selenium.tutorial;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Iframe {
	
WebDriver driver;
	
	@Test
	public void test() throws Exception {
		
		System.setProperty("webdriver.chrome.driver",".\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("file:///C:/Users/e1093784/Downloads/Desktop/NewFile.html");
		driver.manage().window().maximize();
		
		driver.switchTo().frame("goibibo");
		driver.findElement(By.xpath("//*[@id=\"gosuggest_inputSrc\"]")).sendKeys("bangalore");
		
		Thread.sleep(5000);
		
		driver.switchTo().defaultContent();
		driver.findElement(By.xpath("/html/body/a")).click();
	}
}
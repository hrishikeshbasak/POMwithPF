package com.selenium.tutorial;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class JavaScriptExecuter {
	
WebDriver driver;
	
	@Test
	public void setUp() {
		
		System.setProperty("webdriver.chrome.driver",".\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://jqueryui.com/droppable/");
		
		
		JavascriptExecutor exe = (JavascriptExecutor)driver;
		exe.executeScript("arguments[0].value=\"searching\"", driver.findElement(By.xpath("//*[@id=\"main\"]/form/label/input")));
		exe.executeScript("arguments[0].click()", driver.findElement(By.xpath("//*[@id=\"broadcast\"]/a/img")));
		
		driver.get("http://www.facebook.com");
		exe.executeScript("document.getElementById(\"email\").value=\"testing\"");
		
		
	}
}
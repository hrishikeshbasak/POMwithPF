package advance.selenium;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class DynamicCalendar {

	WebDriver driver;
	String selectData;
	Date d;

	@SuppressWarnings("deprecation")
	@Test
	public void selectDate() throws Exception {

		System.setProperty("webdriver.chrome.driver", ".\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		
		driver.get("https://www.goibibo.com/");
		driver.manage().window().maximize();
		driver.findElement(By.xpath(".//*[@id='gi_oneway_label']")).click();
		driver.findElement(By.xpath(".//*[@id='searchWidgetCommon']/div/div[3]/div[1]/div[1]/div/input")).click();

		selectData = "07/16/2018";
		d = new Date(selectData);

		SimpleDateFormat dt = new SimpleDateFormat("MMMM/dd/yyyy");
		String date = dt.format(d);
		String[] split = date.split("/");
		String month = split[0] + " " + split[2];
		System.out.println(month);

		while (true) {
			try {
				// *[contains(text(),'May 2018')]
				driver.findElement(By.xpath(".//*[contains(text(),'" + month + "')]")).isDisplayed();

				// *[@id='fare_20180529']
				Thread.sleep(2000);
				String firstPart = ".//*[@id='fare_";
				String secondPart = "']";

				SimpleDateFormat dt1 = new SimpleDateFormat("MM/dd/yyyy");
				String date1 = dt1.format(d);
				String[] splitdate = date1.split("/");
				String finalPart = firstPart + splitdate[2] + splitdate[0] + splitdate[1] + secondPart;
		      //System.out.println(finalPart);

				driver.findElement(By.xpath(finalPart)).click();
				break;

			} catch (Exception e) {
				driver.findElement(By.xpath("//span[@class='DayPicker-NavButton DayPicker-NavButton--next']")).click();
				Thread.sleep(2000);
			}
		}

	}

}

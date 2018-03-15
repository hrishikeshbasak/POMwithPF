package com.custom.listiner;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.config.TestBase;

public class ListenerInSelenium extends TestBase implements ITestListener {

	public void onTestStart(ITestResult result) {

	}

	public void onTestSuccess(ITestResult result) {

		if (result.isSuccess()) {

			Calendar calendar = Calendar.getInstance();
			SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yy_hh-mm-ss");

			String methodName = result.getName();

			File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			String fileLocation = new File(".\\screenShots").getAbsolutePath();
			File descFile = new File(fileLocation + "\\TestSuccess_Screenshots\\" + methodName + "_"
					+ formatter.format(calendar.getTime()) + ".png");
			try {
				FileUtils.copyFile(srcFile, descFile);

				Reporter.log("<a href='" + descFile.getAbsolutePath() + "'> <img src='" + descFile.getAbsolutePath()
						+ "' height='100' weidth='100'/> </a> ");

			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

	public void onTestFailure(ITestResult result) {

		if (!result.isSuccess()) {

			Calendar calendar = Calendar.getInstance();
			SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yy_hh-mm-ss");

			String methodName = result.getName();

			File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			String fileLocation = new File(".\\screenShots").getAbsolutePath();
			File descFile = new File(fileLocation + "\\failed_Screenshots\\" + methodName + "_"
					+ formatter.format(calendar.getTime()) + ".png");
			try {
				FileUtils.copyFile(srcFile, descFile);

				Reporter.log("<a href='" + descFile.getAbsolutePath() + "' <img src='" + descFile.getAbsolutePath()
						+ "' height=''100' weidth='100'/> </a> ");

			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public void onTestSkipped(ITestResult result) {

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

	}

	public void onStart(ITestContext context) {

	}

	public void onFinish(ITestContext context) {

	}

}

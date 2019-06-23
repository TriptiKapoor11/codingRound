package com.cleartrip.util;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Helper {

	private static String proDir = System.getProperty("user.dir");
	private static String screenFolders = proDir + "\\Screenshots\\";
	private static File src;
	
	static WebDriverWait wait;
	
	public static String captureScreenshot(WebDriver driver, String screenshotName){
		TakesScreenshot ts = (TakesScreenshot) driver;
		src = ts.getScreenshotAs(OutputType.FILE);
		String screenFolder = screenFolders +screenshotName + "_" + System.currentTimeMillis() + ".png";
		try {
			FileUtils.copyFile(src, new File(screenFolder));
		} catch (IOException e) {
			
		}
		return screenFolder;
	}
	
}

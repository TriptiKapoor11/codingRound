package com.cleartrip.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class TestBase {

	public static WebDriver driver;
	public static Properties prop;

	public TestBase() {
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream(
					System.getProperty("user.dir") + "/src/main/java/com/cleartrip" + "/config/config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static WebDriver initialization() {
		String browserName = prop.getProperty("browser");
		if (browserName.equals("chrome")) {
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--disable-notifications");
			System.setProperty("webdriver.chrome.driver", "C:\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver(options);
			driver.get(prop.getProperty("url"));
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		}
		return driver;
	}

	public static void teardown() {
		driver.close();
		driver.quit();
	}

	public static void checkIndate(String inputdate) throws Exception {
		boolean broke = false;
		String date, month, year;
		String caldt, calmonth, calyear;
		/*
		 * Split the String into String Array
		 */
		String dateArray[] = inputdate.split("/");
		date = dateArray[0];
		month = dateArray[1];
		year = dateArray[2];

		driver.findElement(By.id("CheckInDate")).click();

		WebElement cal;
		cal = driver.findElement(By.className("calendar"));
		calyear = driver.findElement(By.className("ui-datepicker-year")).getText();
		/**
		 * Select the year
		 */
		while (!calyear.equals(year)) {
			driver.findElement(By.className("nextMonth")).click();
			calyear = driver.findElement(By.className("ui-datepicker-year")).getText();
			System.out.println("Displayed Year::" + calyear);
		}

		calmonth = driver.findElement(By.className("ui-datepicker-month")).getText();
		/**
		 * Select the Month
		 */
		while (!calmonth.equalsIgnoreCase(month)) {
			driver.findElement(By.xpath("//a[contains(@class,'nextMonth')]")).click();

			calmonth = driver.findElement(By.className("ui-datepicker-month")).getText();
		}

		cal = driver.findElement(By.className("calendar"));
		/**
		 * Select the Date
		 */
		List<WebElement> rows, cols;
		rows = cal.findElements(By.tagName("tr"));
		for (int i = 1; i < rows.size(); i++) {
			cols = rows.get(i).findElements(By.tagName("td"));
			for (int j = 0; j < cols.size(); j++) {
				caldt = cols.get(j).getText();
				if (caldt.equals(date)) {
					broke = true;
					cols.get(j).click();
					break;
				}
			}
			if (broke) {
				break;
			}
		}

	}

	public static void checkoutdate(String checkout) {
		boolean broke = false;
		String date1, month1, year1;
		String caldt1, calmonth1, calyear1;
		/*
		 * Split the String into String Array
		 */
		String dateArray1[] = checkout.split("/");
		date1 = dateArray1[0];
		month1 = dateArray1[1];
		year1 = dateArray1[2];

		driver.findElement(By.id("CheckOutDate")).click();

		WebElement cal1;
		cal1 = driver.findElement(By.className("calendar"));
		calyear1 = driver.findElement(By.className("ui-datepicker-year")).getText();
		/**
		 * Select the year
		 */
		while (!calyear1.equals(year1)) {
			driver.findElement(By.className("nextMonth")).click();
			calyear1 = driver.findElement(By.className("ui-datepicker-year")).getText();
			System.out.println("Displayed Year::" + calyear1);
		}

		calmonth1 = driver.findElement(By.className("ui-datepicker-month")).getText();
		/**
		 * Select the Month
		 */
		while (!calmonth1.equalsIgnoreCase(month1)) {
			driver.findElement(By.xpath("//a[contains(@class,'nextMonth')]")).click();

			calmonth1 = driver.findElement(By.className("ui-datepicker-month")).getText();
		}

		cal1 = driver.findElement(By.className("calendar"));
		/**
		 * Select the Date
		 */
		List<WebElement> rows1, cols1;
		rows1 = cal1.findElements(By.tagName("tr"));
		for (int i = 1; i < rows1.size(); i++) {
			cols1 = rows1.get(i).findElements(By.tagName("td"));
			for (int j = 0; j < cols1.size(); j++) {
				caldt1 = cols1.get(j).getText();
				if (caldt1.equals(date1)) {
					cols1.get(j).click();
					broke = true;
					break;
				}
			}
			if (broke) {
				break;
			}
		}

	}

	public static void departOndate(String inputdate) throws Exception {
		boolean broke = false;
		String date, month, year;
		String caldt, calmonth, calyear;
		/*
		 * Split the String into String Array
		 */
		String dateArray[] = inputdate.split("/");
		date = dateArray[0];
		month = dateArray[1];
		year = dateArray[2];
		driver.findElement(By.id("DepartDate")).click();
		WebElement cal;
		cal = driver.findElement(By.className("calendar"));
		calyear = driver.findElement(By.className("ui-datepicker-year")).getText();
		/**
		 * Select the year
		 */
		while (!calyear.equals(year)) {
			driver.findElement(By.className("nextMonth")).click();
			calyear = driver.findElement(By.className("ui-datepicker-year")).getText();
			System.out.println("Displayed Year::" + calyear);
		}

		calmonth = driver.findElement(By.className("ui-datepicker-month")).getText();
		/**
		 * Select the Month
		 */
		while (!calmonth.equalsIgnoreCase(month)) {
			driver.findElement(By.xpath("//a[contains(@class,'nextMonth')]")).click();

			calmonth = driver.findElement(By.className("ui-datepicker-month")).getText();
		}

		cal = driver.findElement(By.className("calendar"));
		/**
		 * Select the Date
		 */
		List<WebElement> rows, cols;
		rows = cal.findElements(By.tagName("tr"));
		for (int i = 1; i < rows.size(); i++) {
			cols = rows.get(i).findElements(By.tagName("td"));
			for (int j = 0; j < cols.size(); j++) {
				caldt = cols.get(j).getText();
				if (caldt.equals(date)) {
					broke = true;
					cols.get(j).click();
					break;
				}
			}
			if (broke) {
				break;
			}
		}

	}

}
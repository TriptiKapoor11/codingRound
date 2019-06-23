package com.cleartrip.pages;

import com.cleartrip.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class FlightBookingPage extends TestBase {

	@FindBy(id = "OneWay")
	WebElement oneWayButton;

	@FindBy(id = "FromTag")
	WebElement fromTagButton; // actions to be performed

	@FindBy(id = "ToTag")
	WebElement toTagButton;

	@FindBy(id = "SearchBtn")
	WebElement searchFlightButton;

	@FindBy(xpath = "(//ul[@class='autoComplete'])[1]")
	WebElement dropdownList1;

	@FindBy(xpath = "(//ul[@class='autoComplete'])[2]")
	WebElement dropdownList2;

	@FindBy(xpath = "//*[@class='searchSummary']")
	WebElement searchSummary;

	@FindBy(xpath = "(//a[contains(.,'Bangalore, IN')])[1]")
	WebElement destFieldDropdown;

	@FindBy(xpath = "(//a[contains(.,'New Delhi, IN')])[1]")
	WebElement ToFieldDropdown;

	WebDriverWait wait;

	public FlightBookingPage(WebDriver driver) {
		driver = this.driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, 20);
	}

	public void clickOnOneWayButton() {
		oneWayButton.click();
	}

	public void sendValuesOfFromDestination() throws InterruptedException {
		wait.until(ExpectedConditions.visibilityOf(fromTagButton));
		fromTagButton.clear();
		fromTagButton.sendKeys("Bangalore");
		wait.until(ExpectedConditions.visibilityOf(dropdownList1));
		List<WebElement> dropdownListFromDest = driver.findElements(By.xpath("//ul[@class='autoComplete']//li/a"));
		for (int i = 0; i < dropdownListFromDest.size(); i++) {
			WebElement elementFromDest = dropdownListFromDest.get(i);
			String valueFromDest = elementFromDest.getAttribute("innerHTML");
			if (valueFromDest.contains("Bangalore, IN - Kempegowda International Airport (BLR)")) {
				wait.until(ExpectedConditions.elementToBeClickable(destFieldDropdown));
				destFieldDropdown.click();
				break;
			}
		}
	}

	public void sendValuesOfToDestination() throws InterruptedException {
		wait.until(ExpectedConditions.visibilityOf(toTagButton));
		toTagButton.clear();
		toTagButton.sendKeys("New Delhi");
		wait.until(ExpectedConditions.visibilityOf(dropdownList2));
		List<WebElement> dropdownListToDest = driver.findElements(By.xpath("//ul[@class='autoComplete']//li/a"));
		for (int i = 0; i < dropdownListToDest.size(); i++) {
			WebElement elementToDest = dropdownListToDest.get(i);
			String valueToDest = elementToDest.getAttribute("innerHTML");
			if (valueToDest.contains("New Delhi, IN - Indira Gandhi Airport (DEL)")) {
				wait.until(ExpectedConditions.elementToBeClickable(ToFieldDropdown));
				ToFieldDropdown.click();
				break;
			}
		}
	}

	public void clickOnSearchFlightButton() {
		searchFlightButton.click();
	}

	public String verifyPageTitle() {
		return driver.getTitle();
	}

	public boolean loadResultPage() throws Exception {
		wait.until(ExpectedConditions.visibilityOf(searchSummary));
		return true;
	}
}
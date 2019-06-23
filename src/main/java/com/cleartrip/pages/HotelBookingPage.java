package com.cleartrip.pages;

import com.cleartrip.base.TestBase;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
public class HotelBookingPage extends TestBase {

	@FindBy(linkText = "Hotels")
	WebElement hotelLink;

	@FindBy(id = "Tags")
	WebElement localityTextBox;

	@FindBy(id = "travellersOnhome")
	WebElement travellerSelection;
	
	@FindBy(id = "SearchHotelsButton")
	WebElement searchHotelButton;

	@FindBy(xpath = "//ul[@class='autoComplete']//li/a")
	WebElement dropdownList;

	@FindBy(xpath = "(//a[contains(.,'Indiranagar')])[1]")
	WebElement dropdownField;

	@FindBy(id = "srpHeaderLabel")
	WebElement searchSummary;

	WebDriverWait wait;

	    public HotelBookingPage(WebDriver driver) {
		driver = this.driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, 20);
	}

	public void clickOnHotelLink() throws Exception {
		hotelLink.click();
	}

	public String verifyPageTitle() {
		return driver.getTitle();
	}

	public void searchLocality() throws Exception {
		
		wait.until(ExpectedConditions.visibilityOf(localityTextBox));
		localityTextBox.sendKeys("/Indiranagar, Bangalore");
		wait.until(ExpectedConditions.visibilityOf(dropdownList));
		List<WebElement> dropdownlist = driver.findElements(By.xpath("//ul[@class='autoComplete']//li/a"));
		for (int k = 0; k < dropdownlist.size(); k++)
		{
			WebElement element = dropdownlist.get(k);
			String innerhtmlvalue = element.getAttribute("innerHTML");
			if (innerhtmlvalue.contains("Indiranagar, Bangalore, Karnataka, India")) {
				wait.until(ExpectedConditions.visibilityOf(dropdownField));
				dropdownField.click();
				break;
			}
		}		
	}

	public void selectTraveller() throws InterruptedException {
		Select select = new Select(travellerSelection);
		select.selectByVisibleText("1 room, 2 adults");
	}

	public boolean loadResultPage() throws Exception {
		wait.until(ExpectedConditions.visibilityOf(searchSummary));
		return true;
	}

	public void searchHotels() throws InterruptedException {
		searchHotelButton.click();
	}
}

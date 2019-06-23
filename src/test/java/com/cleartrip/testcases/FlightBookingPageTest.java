package com.cleartrip.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.cleartrip.base.TestBase;
import com.cleartrip.pages.FlightBookingPage;
import com.cleartrip.util.Helper;

public class FlightBookingPageTest extends TestBase {

	FlightBookingPage flightBookingPage;

	public FlightBookingPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		driver = TestBase.initialization();
		flightBookingPage = new FlightBookingPage(driver);
	}

	@Test
	public void verifyHomePageTitleTest() throws Exception {
		flightBookingPage.clickOnOneWayButton();
		flightBookingPage.sendValuesOfFromDestination();
		flightBookingPage.sendValuesOfToDestination();
		TestBase.departOndate("26/July/2019");
		Helper.captureScreenshot(driver, "flightBookingPageResult");
		flightBookingPage.clickOnSearchFlightButton();
		String flightBookingPageTitle = flightBookingPage.verifyPageTitle();
		Assert.assertEquals(flightBookingPageTitle,
				"#1 Site for Booking Flights, Hotels, Packages, Trains & Local activities.", "Page title matched");
		Assert.assertEquals(flightBookingPage.loadResultPage(),true);
	}
	
	@AfterMethod
	public void tearDown() {
		TestBase.teardown();
	}

}

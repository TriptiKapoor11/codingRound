package com.cleartrip.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.cleartrip.base.TestBase;
import com.cleartrip.pages.HotelBookingPage;
import com.cleartrip.util.Helper;

public class HotelBookingPageTest extends TestBase {

HotelBookingPage hotelBookingPage;

	public HotelBookingPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		
		driver = TestBase.initialization();	 	
		hotelBookingPage = new HotelBookingPage(driver);	
	}

	@Test
	public void verifyHomePageTitleTest() throws Exception {
		hotelBookingPage.clickOnHotelLink();
		hotelBookingPage.searchLocality();
		TestBase.checkIndate("4/July/2019");
		TestBase.checkoutdate("26/July/2019");
		hotelBookingPage.selectTraveller();
		Helper.captureScreenshot(driver, "hotelPageSearchResults");
		hotelBookingPage.searchHotels();
		hotelBookingPage.loadResultPage();
		Assert.assertEquals(hotelBookingPage.loadResultPage(),true);
	}
	
	@AfterMethod
	public void tearDown() {
		TestBase.teardown();
	}

}

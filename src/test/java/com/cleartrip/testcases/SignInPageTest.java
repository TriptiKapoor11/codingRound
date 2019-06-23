package com.cleartrip.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.cleartrip.base.TestBase;
import com.cleartrip.pages.HotelBookingPage;
import com.cleartrip.pages.SignInPage;
import com.cleartrip.util.Helper;

public class SignInPageTest extends TestBase {

	SignInPage signInPage;

	public SignInPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		driver = TestBase.initialization();
		signInPage = new SignInPage(driver);
	}

	@Test
	public void validateSignInErrorTest() {
		signInPage.loginApplication();
		String Expectedmessage = signInPage.getErrorMessage();
		Assert.assertTrue(Expectedmessage.contains("There were errors in your submission"));
		Helper.captureScreenshot(driver, "signInPageError");
	}

	@AfterMethod
	public void tearDown() {
		TestBase.teardown();
	}

}

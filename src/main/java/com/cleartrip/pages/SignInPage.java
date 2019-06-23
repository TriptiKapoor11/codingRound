package com.cleartrip.pages;

import com.cleartrip.base.TestBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignInPage extends TestBase {

	@FindBy(linkText = "Your trips")
	WebElement tripsDetails;

	@FindBy(id = "SignIn")
	WebElement signIn;

	@FindBy(id = "signInButton")
	WebElement signInButton;

	@FindBy(id = "errors1")
	WebElement error;
	
	WebDriverWait wait;

	public SignInPage(WebDriver driver) {
	    driver = this.driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, 10);
	}

	public void loginApplication(){
		tripsDetails.click();
		signIn.click();
		driver.switchTo().frame("modal_window");
		signInButton.click();
	}

	public String getErrorMessage() {
		String valueOfErrorMessage = error.getText();
		return valueOfErrorMessage;
	}
}

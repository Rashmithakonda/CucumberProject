package com.application.steps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.application.elements.RegistrationPageElements;

public class RegistrationPageSteps extends RegistrationPageElements{
	
	public RegistrationPageSteps(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void verifyRegistrationPageLaunched() {
		waitForElement(registrationPageHeader, 10);
	}
	
	public void updateRegistrationInfo(String user,String pass) {
		enterInfo(firstName, "Bharath");
		enterInfo(lastName, "Reddy");
		enterInfo(address, "Hyderabad");
		enterInfo(city, "Hyderabad");
		enterInfo(state, "TS");
		enterInfo(zipCode, "500081");
		enterInfo(phoneNumber, "9553220022");
		enterInfo(ssn, "989898989");
		enterInfo(username, user);
		enterInfo(password, pass);
		enterInfo(confirmPassword, pass);
	}
	
	public void clickOnRegisterButton() {
		click(registerButton);

	}
	
}

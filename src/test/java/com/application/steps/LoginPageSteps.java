package com.application.steps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.application.elements.LoginPageElements;

public class LoginPageSteps extends LoginPageElements{
	
	public LoginPageSteps(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}	
	
	public void launchApplication() {
		launchApplication(prop.getProperty("url"));
	}
	
	public void verifyTitle(String expValue) {
		Assert.assertEquals(getTitle(),expValue);
	}
	
	public void verifyLogo() {
		Assert.assertTrue(isElementDisplayed(logo));
	}
	
	public void verifyCaption(String expValue) {
		Assert.assertEquals(getElementText(caption),expValue);
	}
	
	public void verifyLoginPageHeader(String expValue) {
		Assert.assertEquals(getElementText(loginPageHeader),expValue );
	}
	
	public void enterCredentials(String user,String pass) {
		enterInfo(usernameTxtb, user);
		enterInfo(passwordTxtb, pass);
	}
	
	public void clickOnSignInButton() {
		click(loginBtn);
	}
	
	public void navigateToRegistrationPage() {
		click(registrationLink);
	}

}

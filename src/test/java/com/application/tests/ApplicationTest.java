package com.application.tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.application.steps.HomePageSteps;
import com.application.steps.LoginPageSteps;
import com.application.steps.RegistrationPageSteps;
import com.framework.base.BasePage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ApplicationTest{
	
	public LoginPageSteps loginpage = null;
	public HomePageSteps homepage = null;
	public RegistrationPageSteps registrationpage = null;
	
	@Given("Initialize all pages")
	public void initiatePageClasses() {
		WebDriver driver = new BasePage().getDriver();
		loginpage = new LoginPageSteps(driver);
		registrationpage = new RegistrationPageSteps(driver);
		homepage = new HomePageSteps(driver);	    
	}

	@Given("Launch the application using {string}")
	public void launch_the_application_using(String string) {
		loginpage.launchApplication(string);	    
	}

	@When("Application launched with the title {string}")
	public void application_launched_with_the_title(String string) {
		loginpage.verifyTitle(string);	    
	}

	@Then("application logo should be displayed in login page")
	public void application_logo_should_be_displayed_in_login_page() {
	    loginpage.verifyLogo();	    
	}
	
	@Then("application caption should be displayed as {string}")
	public void application_caption_should_be_displayed_as(String string) {
		loginpage.verifyCaption(string);
	}

	@Then("application login page header should be displayed as {string}")
	public void application_login_page_header_should_be_displayed_as(String string) {
		loginpage.verifyLoginPageHeader(string);
	    
	}

	@When("user navigates to registration page")
	public void user_navigates_to_registration_page() {
		loginpage.navigateToRegistrationPage();	    
	}

	@Then("registration page should be launched")
	public void registration_page_should_be_launched() {
		registrationpage.verifyRegistrationPageLaunched();	    
	}

	@When("user updates the registration details with {string} and {string}")
	public void user_updates_the_registration_details_with_and(String string, String string2) {
		registrationpage.updateRegistrationInfo(string, string2);	    
	}

	@When("click on register button")
	public void click_on_register_button() {
		registrationpage.clickOnRegisterButton();	    
	}

	@Then("registration should be successful")
	public void registration_should_be_successful() {
	    homepage.verifyLoginIsSuccessful();	    
	}

	@When("^User enters (.*) and (.*)$")
	public void userEntersCredentials(String username,String password) {
	    loginpage.enterCredentials(username, password);	    
	}

	@When("click on login button")
	public void click_on_login_button() {
		loginpage.clickOnSignInButton();
	    
	}

	@Then("login should be successful")
	public void login_should_be_successful() {
		 homepage.verifyLoginIsSuccessful();		    
	}

	
}

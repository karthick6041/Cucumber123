package org.stepdefinition;


import org.junit.Assert;
import org.openqa.selenium.By;
import org.runner.SampleBaseClass2;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class FBLogin  extends SampleBaseClass2{
	@Given("The should launch the chrome browser")
	public void the_should_launch_the_chrome_browser() {
		browserLaunch();
	}

	@When("User should type the url")
	public void user_should_type_the_url() {
		urlLaunch("http://www.facebook.com");
	}

	@When("The user should maxmize the window")
	public void the_user_should_maxmize_the_window() {
		maxWindow();
	}

	@When("The user should type invalid username and invalid password")
	public void the_user_should_type_invalid_username_and_invalid_password() {
    driver.findElement(By.id("email")).sendKeys("karthick");
    driver.findElement(By.id("pass")).sendKeys("1234566");
    
	}

	@When("The user should click the login button")
	public void the_user_should_click_the_login_button() {
		driver.findElement(By.name("login")).click();
	}

	@Then("The user should navigate to incorrect credential page")
	public void the_user_should_navigate_to_incorrect_credential_page() {

		String currentUrl = driver.getCurrentUrl();
		Assert.assertTrue("verify the page", currentUrl.contains("privacy"));
		System.out.println("Test case is pass");
	}


}

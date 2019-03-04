package com.spree.framework.steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class SpreeHomePageSteps extends StepBase {
	
	
	@Given("Not a validated user")
	public void not_a_validated_user() {
		//driver.manage().deleteAllCookies();
		spree.deleteAllCookies();
	}

	@When("User browse to the site")
	public void user_browse_to_the_site() {
	    //driver.navigate().to("http://spree.shiftedtech.com/");
		spree.navigateTo("http://spree.shiftedtech.com/");
	}

	@Then("Spree home page should display")
	public void spree_home_page_should_display() {
	    //String title = driver.getTitle();
	    //Assert.assertEquals("Spree Demo Site", title);
		spree.homePage().verifyPageTitle();
	}

	@When("User click login link")
	public void user_click_login_link() {
		//WebElement element = driver.findElement(By.xpath("//li[@id='link-to-login']/a"));
		//element.click();
		spree.homePage().goToLoginPage();
	}

	@Then("Home page should display")
	public void home_page_should_display() {
		 //String title = driver.getTitle();
		 //Assert.assertEquals("Spree Demo Site", title);
		spree.homePage().verifyPageTitle();
	}

	@Then("Login success message display")
	public void login_success_message_display() {
		//WebElement alertMsg = driver.findElement(By.cssSelector(".alert-success"));
		//String mString = alertMsg.getText();
		//Assert.assertEquals("Logged in successfully", mString);
		spree.homePage().verifySuccessMsg();
	}

}

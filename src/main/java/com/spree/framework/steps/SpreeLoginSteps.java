package com.spree.framework.steps;

import com.tjmax.framework.utils.TestDataManager;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class SpreeLoginSteps extends StepBase {
	

	@Then("Browser display Login page")
	public void browser_display_Login_page() {
		//String title = driver.getTitle();
	    //Assert.assertEquals("Login - Spree Demo Site", title);
		spree.loginPage().verifyPageTitle(null);
	}

	@When("User enter user email as {string}")
	public void user_enter_user_email_as(String email) {
		//WebElement emailTextBox = driver.findElement(By.id("spree_user_email"));
		//emailTextBox.sendKeys(email);

		email = TestDataManager.getInstance().getData(email);
		spree.loginPage().enterEmailAddress(email);
	}

	@When("User enter password as {string}")
	public void user_enter_password_as(String password) {
		//WebElement passwordTextBox = driver.findElement(By.id("spree_user_password"));
		//passwordTextBox.sendKeys(password);


		password = TestDataManager.getInstance().getData(password);
		spree.loginPage().enterPassword(password);
	}

	@When("User click login button")
	public void user_click_login_button() {
		//WebElement loginButton = driver.findElement(By.name("commit"));
		//loginButton.click();
		spree.loginPage().clickLoginButton();
	}


	@Then("Login not success message display")
	public void login_not_success_message_display() {
		//WebElement msg = driver.findElement(By.cssSelector(" div.alert.alert-error"));
		//String mString = msg.getText();
		//Assert.assertEquals("Invalid email or password.", mString);
		spree.loginPage().verifyErrorMsg("Invalid email or password.");
	}


}

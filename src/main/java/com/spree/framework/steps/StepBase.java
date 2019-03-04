package com.spree.framework.steps;

import org.openqa.selenium.WebDriver;

import com.spree.framework.pom.ApplicationController;

public class StepBase {

	protected WebDriver driver = DriverFactory.getInstance(System.getenv("chrome")).getDriver();
	protected ApplicationController spree = new ApplicationController(driver);
}

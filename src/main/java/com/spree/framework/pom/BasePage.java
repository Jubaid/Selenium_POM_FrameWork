package com.spree.framework.pom;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;


public class BasePage {

	protected WebDriver driver = null;
	
	public BasePage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}
	
	public void verifyTitlePage(String title) {
		String actualTitle = driver.getTitle();
		Assert.assertEquals(title, actualTitle);	
	}
	
	public void delayFor(int time) throws InterruptedException {
		Thread.sleep(time);
	}
	
	public void deleteCookies() {
		driver.manage().deleteAllCookies();
	}
	
	public void navigateTo(String url) {
		driver.navigate().to(url);
	}

}

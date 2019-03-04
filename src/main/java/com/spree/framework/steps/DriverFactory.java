package com.spree.framework.steps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.FirefoxDriverManager;

public class DriverFactory {

	private static DriverFactory instance = null;
	private ThreadLocal<WebDriver> driverCollection = new ThreadLocal<WebDriver>();
	
	private DriverFactory() {}
	
	public static DriverFactory getInstance() {
		return getInstance(null);
	}
	
	
	public static DriverFactory getInstance(String browser) {
		// TODO Auto-generated method stub
		
		if(instance.driverCollection.get() == null) {
			if(browser.equalsIgnoreCase("chrome")) {
				ChromeDriverManager.chromedriver().setup();
				WebDriver driver = new ChromeDriver();
		        instance.driverCollection.set(driver);
			}
		}
		
		else if (browser.equalsIgnoreCase("firefox")) {
			FirefoxDriverManager.firefoxdriver().setup();
			WebDriver driver = new FirefoxDriver();
			instance.driverCollection.set(driver);
		}
		
		return instance;
	}
	
	
	public WebDriver getDriver() {
		// TODO Auto-generated method stub
		return driverCollection.get();
	}
	
	public void removeDriver() {
		driverCollection.get().quit();
		driverCollection.remove();
	}
	
	
	

}

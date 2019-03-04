package com.spree.framework.steps;



import java.util.Collection;

import com.spree.framework.utils.TestDataManager;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class HookSteps extends StepBase{

	private String dataSource = null;
	
	@Before
	public void setUp(Scenario scenario) {
		Collection<String> tags = scenario.getSourceTagNames();
		for(String tag: tags) {
			System.out.println("Tag: " + tag);
			if(tag.startsWith("@DataSource")) {
				dataSource = tag.substring(tag.indexOf("file=") + 5, tag.lastIndexOf(")"));
				System.out.println("DataSource: " + dataSource);
				TestDataManager.getInstance().load(System.getProperty("user.dir") + dataSource);
			}
		}
		driver = DriverFactory.getInstance().getDriver();
		System.out.println(driver);
	}
	
	@After
	public void tearDown() {
		DriverFactory.getInstance().removeDriver();
	}
}

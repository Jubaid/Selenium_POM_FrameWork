package com.spree.Runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
        
        
		monochrome = true,
       
		features = "src/test/resources/features/SpreeLoginFunctionality.feature",
        
        glue = {"com.spree.framework.steps"},
        
        //dryRun = true,
        
        plugin={
                "pretty:target/cucumber-test-report/cucumber-pretty.txt",
                "html:target/cucumber-test-report",
                "json:target/cucumber-test-report/cucumber-report.json",
                "junit:target/cucumber-test-report/test-report.xml"
        }
	)
public class BDDRunner {
}

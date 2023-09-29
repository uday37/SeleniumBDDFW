package org.amazon.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;

import io.cucumber.testng.CucumberOptions;

import org.testng.annotations.DataProvider;

@CucumberOptions(features = "src/test/resources/features",
                    glue = {"org.amazon.stepdefs"},
                    dryRun = false,
        plugin = {"pretty", "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
        monochrome = true,
        publish = true
                   )
public class TestRunner extends AbstractTestNGCucumberTests {
//"html:target/cucumber-report.html", "json:target/cucumber.json",
//,  "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"

    @DataProvider(parallel = true)
    @Override
    public Object[][] scenarios() {
        return super.scenarios();
    }
}

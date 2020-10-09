package com;

import org.junit.runner.RunWith;
import cucumber.api.junit.Cucumber;
import cucumber.api.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = { "pretty", "json:target/cucumber.json", "html:target/cucumber.html" }, features = {
		"src/test/resources/com/features/" }, tags = { "@Run_Orders_POST_1" })
public class Ordertest {

}

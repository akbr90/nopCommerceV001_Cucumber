package testRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.*;

@RunWith(Cucumber.class)
@CucumberOptions(
		features= {".\\Features\\Customers.feature",
				".\\Features\\Login.feature"},
		glue= {"stepDefinitions"},
		monochrome=true,
		dryRun=false,
		plugin= {"pretty","html:target/HtmlReports",
				"json:target\\JSONReports\\report.json",
				"junit:target\\JUnitReports\\report.xml"},
		tags= {"@sanity"}
		
		)
public class TestRunner {

}

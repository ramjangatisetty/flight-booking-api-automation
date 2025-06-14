package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(
		features = "src/test/resources/features",
		glue = {"stepdefs", "hooks"},
		plugin = {
				"pretty",                         // Console output
				"html:reports/html_report.html",  // Basic HTML report
				"json:reports/cucumber.json"      // JSON report (optional)
		},
		tags = "@registerAndLogin",                      // Adjust tags as needed
		monochrome = true
)
public class TestRunner extends AbstractTestNGCucumberTests {

	@Override
	@DataProvider(parallel = true)
	public Object[][] scenarios() {
		return super.scenarios();
	}

}


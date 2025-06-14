package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

@CucumberOptions(
		features = "src/test/resources/features",
		glue = {"stepdefs", "hooks"},
		plugin = {
				"pretty",
				"io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"
		},
		tags = "@registerAndLogin"
)
public class TestRunner extends AbstractTestNGCucumberTests {

	static {
		System.out.println("✅ TestRunner loaded.");
	}

	@Override
	@DataProvider(parallel = true)
	public Object[][] scenarios() {
		return super.scenarios();
	}

}


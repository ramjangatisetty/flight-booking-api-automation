// hooks/Hooks.java
package hooks;

import com.aventstack.extentreports.*;
import io.cucumber.java.*;
import utils.ExtentReportManager;

public class Hooks {
	private static ExtentReports extent = ExtentReportManager.getInstance();
	private static ThreadLocal<ExtentTest> scenarioThread = new ThreadLocal<>();

	@Before
	public void beforeScenario(Scenario scenario) {
		ExtentTest test = extent.createTest(scenario.getName());
		scenarioThread.set(test);
	}

	@AfterStep
	public void afterStep(Scenario scenario) {
		if (scenario.isFailed()) {
			scenarioThread.get().fail("Step failed: " + scenario.getStatus());
		} else {
			scenarioThread.get().info("Step passed");
		}
	}

	@After
	public void afterScenario(Scenario scenario) {
		if (scenario.isFailed()) {
			scenarioThread.get().fail("Scenario failed");
		} else {
			scenarioThread.get().pass("Scenario passed");
		}
		scenarioThread.remove();
	}

	@AfterAll
	public static void tearDownReport() {
		extent.flush();
	}
}

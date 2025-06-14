package base;

import io.restassured.RestAssured;
import org.testng.annotations.BeforeSuite;
import utils.ConfigLoader;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class BaseTest {

	@BeforeSuite(alwaysRun = true)
	public void setupFramework() {
		String baseUri = ConfigLoader.get("base.uri");
		System.out.println("BASE URI: " + baseUri);
		RestAssured.baseURI = baseUri;
		log.info("Framework initialized. Base URI set to: {}", baseUri);
	}
}


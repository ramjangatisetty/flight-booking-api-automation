package stepdefs;

import clients.UserClient;
import io.cucumber.java.en.*;
import io.restassured.response.Response;
import lombok.extern.slf4j.Slf4j;
import models.UserRegisterRequest;
import models.UserLoginRequest;

import static org.testng.Assert.*;

@Slf4j
public class UserSteps {

	private final UserClient userClient = new UserClient();
	private Response response;

	@Given("I register a user with name {string}, email {string}, password {string}, phone {string}, and role {string}")
	public void registerUser(String name, String email, String password, String phone, String role) {
		UserRegisterRequest request = UserRegisterRequest.builder()
				.name(name)
				.email(email)
				.password(password)
				.phone(phone)
				.role(role)
				.build();

		response = userClient.registerUser(request);
		assertEquals(response.statusCode(), 201, "User registration failed");
		log.info("User registered successfully");
	}

	@When("I login with email {string} and password {string}")
	public void login(String email, String password) {
		UserLoginRequest request = UserLoginRequest.builder()
				.email(email)
				.password(password)
				.build();

		response = userClient.loginUser(request);
	}

	@Then("the response status code should be {int}")
	public void validateStatusCode(int expected) {
		assertEquals(response.statusCode(), expected);
	}

	@And("the response should contain a valid JWT token")
	public void validateJwtToken() {
		String token = response.jsonPath().getString("token");
		assertNotNull(token, "Token was not present in the login response");
		assertTrue(token.split("\\.").length == 3, "Token is not a valid JWT structure");
	}
}


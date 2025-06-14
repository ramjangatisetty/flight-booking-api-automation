package clients;

import io.restassured.response.Response;
import models.UserRegisterRequest;
import models.UserLoginRequest;

import static io.restassured.RestAssured.given;

public class UserClient {

	public Response registerUser(UserRegisterRequest request) {
		return given()
				.log().all()
				.contentType("application/json")
				.body(request)
				.when()
				.post("/api/users/register")
				.then()
				.log().all()
				.extract().response();
	}

	public Response loginUser(UserLoginRequest request) {
		return given()
				.log().all()
				.contentType("application/json")
				.body(request)
				.when()
				.post("/api/users/login")
				.then()
				.log().all()
				.extract().response();
	}
}


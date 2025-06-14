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
				.post("Http://localhost:3000/api/v1/users/register")
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
				.post("http://localhost:3000/api/v1/users/login")
				.then()
				.log().all()
				.extract().response();
	}
}


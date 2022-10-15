package api.endpoints;

import static io.restassured.RestAssured.given;

import api.payloads.User_Payload;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class User_endpoints {
// used for crud= create,read,update,delete operations requests to users apis

	public static Response createUser(User_Payload payload) // user class will have payloads body in payloadpackage
	{
		Response response = given().contentType(ContentType.JSON).accept(ContentType.JSON).body(payload)
// execute post req in swagger then check for response in that -h is mentioned which is header so
// we have to pass that header in given section
				.when().post(Routes.userpost_url); // here is implementation of routes

		return response;

	}

	public static Response readUser(String userName) // username we will get from testcase
	{
		Response response = given().pathParam("username", userName)

				.when().get(Routes.userget_url);

		return response;

	}

	public static Response updateUser(String userName, User_Payload payload) {
		Response response = given().contentType(ContentType.JSON).accept(ContentType.JSON)
				.pathParam("username", userName).body(payload).when().put(Routes.userput_url);

		return response;

	}

	public static Response deleteUser(String userName) {
		Response response = given().pathParam("username", userName)

				.when().delete(Routes.userdelete_url);

		return response;

	}

}

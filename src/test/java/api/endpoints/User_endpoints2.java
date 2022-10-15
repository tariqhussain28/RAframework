package api.endpoints;

import static io.restassured.RestAssured.given;

import java.util.ResourceBundle;

import api.payloads.User_Payload;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class User_endpoints2 {

	static ResourceBundle geturl()
	{// method created to get url from prop file
		ResourceBundle routes=ResourceBundle.getBundle("Routes");// load prop file
		return routes;
		
	}
	
	
	
	
	public static Response createUser(User_Payload payload) 
	{
		String post_url=geturl().getString("post_url");
		
		
		Response response = given().contentType(ContentType.JSON).accept(ContentType.JSON).body(payload).when()
				.post(post_url);

		return response;

	}
	
	public static Response readUser(String userName) {
		String get_url=geturl().getString("get_url");
		Response response = given().pathParam("username", userName)

				.when().get(get_url);

		return response;

	}

	public static Response updateUser(String userName, User_Payload payload) {
		String update_url=geturl().getString("update_url");
		Response response = given().contentType(ContentType.JSON).accept(ContentType.JSON)
				.pathParam("username", userName).body(payload).when().put(update_url);

		return response;

	}

	public static Response deleteUser(String userName) {
		String delete_url=geturl().getString("delete_url");
		Response response = given().pathParam("username", userName)

				.when().delete(delete_url);

		return response;

	}

}

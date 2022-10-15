package day1;	
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
// this import were showing errors because this class is in main but scope
// of dependencies in pom.xml was limited to test so we removed <scope> tag line
//and error was resolved
import static org.hamcrest.Matchers.*;

import java.util.HashMap;
public class Day1_requests
{
	int id;
	@Test(priority = 1)
	void getusers()
	{
		
		given()
		.when()
			.get("https://reqres.in/api/users?page=2")
		.then()
			.statusCode(200)
			.body("page",equalTo(2))
			.log().all()
		;
		
	}
	
	@Test(priority = 2)
	void postuser()
	{
		HashMap<String,String> data=new HashMap<String,String>();
		data.put("name","tariq");
		data.put("job","QA");
//		 given()
//				.contentType("application/json")
//				.body(data)
//		     .when()
//			     .post("https://reqres.in/api/users")
//			 .then()
//			 .statusCode(201)
//			 .log().all();
		id = given()
				.contentType("application/json")
				.body(data)
		     .when()
			     .post("https://reqres.in/api/users")
			     .jsonPath().getInt("id");
	}
	
	
	@Test(priority = 3,dependsOnMethods = {"postuser"})
	void putuser()
	{
		HashMap<String,String> data=new HashMap<String,String>();
		data.put("name","john");
		data.put("job","teacher");
		given()
			.contentType("application/json")
			.body(data)
		.when()
			.put("https://reqres.in/api/users/"+id)
		.then()
			.statusCode(200)
			.log().all();
		
	}
	
	@Test(priority = 4)
	void deleteuser()
	{
		given()
		
		.when()
			.delete("https://reqres.in/api/users/"+id)
		
		.then()
			.statusCode(204)
			.log().all();
	}
	
	
	
	
	
	
	
	
	

}

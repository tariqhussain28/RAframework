package day6;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;

import static org.hamcrest.Matchers.*;

import io.restassured.matcher.RestAssuredMatchers;
public class xmlschemavalidation {

	// postman odnt support xml schema validation
	// we can do it with rest assured
	// old tech used less
	void xmlshmev()
	{
		given()
		.when()
			.get(" ")
		.then()
			.assertThat().body(RestAssuredMatchers.matchesXsdInClasspath(" "))
		;
		
		
	}
	
}

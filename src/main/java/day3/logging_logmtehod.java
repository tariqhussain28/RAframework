package day3;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;

import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
public class logging_logmtehod {

	
	@Test(priority = 1)
	void getalog()
	{
		given()
		.when()
			.get("https://reqres.in/api/users")
		.then()
		.log().all()   // get all logs
	//	.log().cookies() // getting only cookies log
	//	.log().headers()   // print all headers
	//	.log().body()  // prit all body
		;
	}
	
	
	
}

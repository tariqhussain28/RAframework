package day8;

import org.testng.ITestContext;
import org.testng.annotations.Test;
import org.json.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
public class getuser 
{
	
	
	@Test
	void get(ITestContext context)
	{
		//int id =(Integer) context.getAttribute("userid") ; // getattribute will return object so conv to int
		// this we will get from created user id. only through xml file we will get it
		
		int id =(Integer) context.getSuite().getAttribute("userid") ; 
		
		String bearer= "Bearer "+"cbea08823a09a3378ec6c90c4419f0834b5e74c30604f98b5e54fb247be9d81e";
		
		given()
				.headers("Authorization",bearer)
				.contentType("application/json")
				.pathParam("id",id)
			.when()
				.get("https://gorest.co.in/public/v2/users/{id}")  // remember>> {id}
			.then()
				.statusCode(200)
				.log().all()
				;
			
			
			
		
		
		
	}

}

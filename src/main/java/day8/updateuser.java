package day8;

import static io.restassured.RestAssured.given;

import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import org.testng.annotations.Test;
import org.json.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
public class updateuser {

	
	@Test
	void update(ITestContext context)
	{
		JSONObject data=new JSONObject();
		data.put("gender", "female");
		data.put("status", "active");
		//int id= (Integer) context.getAttribute("userid");
		int id =(Integer) context.getSuite().getAttribute("userid") ; 
		String bearer= "Bearer "+"cbea08823a09a3378ec6c90c4419f0834b5e74c30604f98b5e54fb247be9d81e";
		
	given()
			.headers("Authorization",bearer)
			.contentType("application/json")
			.pathParam("id", id)
			.body(data.toString())
		.when()
			.put("https://gorest.co.in/public/v2/users/{id}")
		.then()
			.statusCode(200)
			.log().all()
			;
		
			
			
		
		
		
	}
	
	
}

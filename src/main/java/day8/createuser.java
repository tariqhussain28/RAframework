package day8;

import static io.restassured.RestAssured.given;

import org.json.JSONObject;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

public class createuser 
{
	@Test
	void create(ITestContext context)  // itestcontext interface is used to take value 
	                                   // from ne class and use it in other class
	{
		Faker fake=new Faker();
		JSONObject data=new JSONObject();
		data.put("name",fake.name().fullName());
	    data.put("gender", "male");
		data.put("email", fake.internet().emailAddress());
		data.put("status", "inactive");
		
		String bearer= "Bearer "+"cbea08823a09a3378ec6c90c4419f0834b5e74c30604f98b5e54fb247be9d81e";
		
	int id=	given()
			.headers("Authorization",bearer)
			.contentType("application/json")
			.body(data.toString())
		.when()
			.post("https://gorest.co.in/public/v2/users").jsonPath().getInt("id")
			;
		
	
		System.out.println("id:"+id);
		
		//context.setAttribute("userid", id); 
		// we are created a global variable and its scope is limited to test level not suite level
		
		context.getSuite().setAttribute("userid", id);
		// this will be available in suite level so it wont fail when we have different test
		
	}
	
	
	
	

}

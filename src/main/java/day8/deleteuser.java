package day8;

import static io.restassured.RestAssured.given;

import org.testng.ITestContext;
import org.testng.annotations.Test;

public class deleteuser 
{
	@Test
	void delete(ITestContext context)
	{
	//int id = (Integer) context.getAttribute("userid");  
	int id =(Integer) context.getSuite().getAttribute("userid") ; 
	String bearer= "Bearer "+"cbea08823a09a3378ec6c90c4419f0834b5e74c30604f98b5e54fb247be9d81e";
	
	given()
			.headers("Authorization",bearer)
			.contentType("application/json")
			.pathParam("id",id)
		.when()
			.delete("https://gorest.co.in/public/v2/users/{id}")
		.then()
			.statusCode(204)
			;
		
	
	
	
	
	}
}

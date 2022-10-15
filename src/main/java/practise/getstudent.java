package practise;

import org.testng.ITestContext;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
public class getstudent 
{
	
	
	@Test
	void get(ITestContext context)
	{
		int id=(Integer) context.getSuite().getAttribute("userid");
		given()
		.contentType("application/json")
			.pathParam("id", id)
		.when()
		 	.get("http://localhost:3000/students/{id}")
		.then()
			.statusCode(200)
			.log().all()
			
		
		;
		
		
		
		
	}
	

}

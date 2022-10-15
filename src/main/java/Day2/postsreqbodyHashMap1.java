package Day2;

import static io.restassured.RestAssured.given;
// this import were showing errors because this class is in main but scope
// of dependencies in pom.xml was limited to test so we removed <scope> tag line
//and error was resolved
import static org.hamcrest.Matchers.equalTo;

import java.util.HashMap;

import org.testng.annotations.Test;
public class postsreqbodyHashMap1 
{
	@SuppressWarnings("unchecked")
	// different ways to send post body
	
	//1. using hashmap: suitable when small set of data is there in post
	@Test
	void PostusingHashmap()
	{
		HashMap data=new HashMap();
		data.put("name", "Tariq");
		data.put("phone", "998765432");
		data.put("location", "pune");
		String coursearr[]= {"java","c++"}; 
		data.put("courses", coursearr); // we are putting array object in hashmap
		
		
		given()
			.contentType("application/json")
			.body(data)
		.when()
			.post(" http://localhost:3000/students")
		.then()
			.statusCode(201)
			.body("name",equalTo("Tariq"))
			.body("location",equalTo("pune"))
			.body("phone", equalTo("998765432"))
			.body("courses[0]",equalTo("java"))
			.body("courses[1]",equalTo("c++"))  
			// no need to verify everyfield few are enough
			.header("Content-Type", "application/json; charset=utf-8")
			.log().all();
		;
		
		
	}
	
	@Test(priority = 1)
	void deleteUser()
	{
		given()
		.when()
			.delete( "http://localhost:3000/students/6")
		.then()
			.statusCode(200);
	}
	
	

}

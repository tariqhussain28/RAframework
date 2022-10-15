package Day2;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.Test;
public class Post_POJOclass 
{
	// POJO :most important , we have to create seperate class to get data from
	//encapsulation is sued here and getter and setter is used to 
	//generate the data
	
	@Test
	void post_usingPOJO()
	{
		POJOclass_settergetter data=new POJOclass_settergetter();
		data.setName("nadim1");
		data.setLocation("nagpur");
		data.setPhone("6654321");
		String coursearr[]= {"c","c++"};
		data.setCourses(coursearr);
		
		given()
		.contentType("application/json")
		.body(data) 
	.when()
		.post(" http://localhost:3000/students")
	.then()
		.statusCode(201)
		.body("name",equalTo("nadim1"))
		.body("location",equalTo("nagpur"))
		.body("phone", equalTo("6654321"))
		.body("courses[0]",equalTo("c"))
		.body("courses[1]",equalTo("c++"))  
		// no need to verify everyfield few are enough
		.header("Content-Type", "application/json; charset=utf-8")
		.log().all();
	;
	
		
	}

}

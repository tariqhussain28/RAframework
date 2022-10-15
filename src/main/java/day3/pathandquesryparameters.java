package day3;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;
public class pathandquesryparameters 
{
	//query: it will filter the particular information
	//path: it specify where to go
	
	
	//https://reques.in/api/users?page2&id=5
	@Test
	void test_quertandpathparams()
	{
		// path and query params are given in given /prerequisit
		given()
			.pathParam("mypath","users") // path parameters
			.queryParam("page",2)  
	//1st query paramters .this are not variable they are present in url
	//		and provided automatically 
			.queryParam("id", 5)  //2nd quesry parameters
		
		.when()
			.get("https://reqres.in/api/{mypath}") // no need to provide query
		.then()
			.statusCode(200)
			.log().all()
			;
			
			
		
	}
	
	

}

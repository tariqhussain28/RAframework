package Day2;

import static io.restassured.RestAssured.given;
// this import were showing errors because this class is in main but scope
// of dependencies in pom.xml was limited to test so we removed <scope> tag line
//and error was resolved
import static org.hamcrest.Matchers.equalTo;

import org.json.JSONObject;
import org.testng.annotations.Test;
public class Postrequestbody_Jsonlibrary2 {

	
	@Test
	void post_JsonLibrary()
	{
		// we will need json library	
		JSONObject data=new JSONObject();
		data.put("name","hussain");
		data.put("location","gondia");
		data.put("phone","123456");
		String coursesarr[]= {"c","c++"};
		data.put("courses",coursesarr);
		
		
			given()
				.contentType("application/json")
				.body(data.toString()) //we have to pass body as string in json 
			.when()
				.post(" http://localhost:3000/students")
			.then()
				.statusCode(201)
				.body("name",equalTo("hussain"))
				.body("location",equalTo("gondia"))
				.body("phone", equalTo("123456"))
				.body("courses[0]",equalTo("c"))
				.body("courses[1]",equalTo("c++"))  
				// no need to verify everyfield few are enough
				.header("Content-Type", "application/json; charset=utf-8")
				.log().all();
			;
			
			
		}
		
		
		
		
	}
	
	


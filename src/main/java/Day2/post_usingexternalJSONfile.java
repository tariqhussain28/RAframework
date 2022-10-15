package Day2;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
//this import were showing errors because this class is in main but scope
//of dependencies in pom.xml was limited to test so we removed <scope> tag line
//and error was resolved
import static org.hamcrest.Matchers.equalTo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.Test;

public class post_usingexternalJSONfile 
{
	
	@Test
	void post_externaljsonfile() throws FileNotFoundException
	{
		File f=new File(".\\body.json"); // we have located the file next we have to read it
		FileReader fr=new FileReader(f); // java.io package 
		JSONTokener jt=new JSONTokener(fr); // org.json it will split body into json body
		JSONObject data=new JSONObject(jt); //now we got json object
		// now we got json object rest is same as before like json libarary
		given()
			.contentType("application/json")
			.body(data.toString()) //we have to pass body as string in json 
		.when()
			.post(" http://localhost:3000/students")
		.then()
			.statusCode(201)
			.body("name",equalTo("John"))
			.body("location",equalTo("india"))
			.body("phone", equalTo("1234567890"))
			.body("courses[0]",equalTo("Java"))
			.body("courses[1]",equalTo("Selenium"))  
			// no need to verify everyfield few are enough
			.header("Content-Type", "application/json; charset=utf-8")
			.log().all();
		;
		
		
		
		
	}
	

}

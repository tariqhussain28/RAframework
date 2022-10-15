package day5;

import org.testng.annotations.Test;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
public class filedownload 
{
	@Test
	void filedownlaod()
	{
		
		given()
		.when()
			.get("fiel downlaod url******** asdsamds/abc.txt")
		.then()
			.statusCode(200)  // if file is available then only it get downloaded i.e then
			// only we get 200 status code
		
		;
		
		
	}
	
	
	

}

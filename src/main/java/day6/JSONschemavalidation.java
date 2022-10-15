package day6;

import org.testng.annotations.Test;

import io.restassured.module.jsv.JsonSchemaValidator;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
public class JSONschemavalidation 
{
	// json xml schema validation
	// response validation is different and schema validation is different 
	// when we get response we have to check for schema
	// eg. in database we provide datattype to columns that is schema
	// schema = organisation or structure of database
	
	// response validation = we validate data in response
	// schema validation   = we validate type of data in response eg. integer, string 
	
	// respose---> we have to make schema
	 // json to json schema convert by copying all body 
	// then copy schmea and paster in src/test/resources folder as .json fie
	
	
	@Test 
	void jsonschemavalidation()
	{
		given()
		.when()
			.get("http://localhost:3000/store")
		.then()
			.assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("jsonschema.json"))
		
		;
	}
	
	
	
	
	
	
	

}

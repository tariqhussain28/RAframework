package day4;
import static io.restassured.RestAssured.given;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
// this import were showing errors because this class is in main but scope
// of dependencies in pom.xml was limited to test so we removed <scope> tag line
//and error was resolved
import static org.hamcrest.Matchers.*;

import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
public class Parsing_jsonresponse 
{// first start nodejs server for local api
// we have added some dependecy for validating rsponse
	
	
	//@Test(priority = 1)
	void testjsonresponse1()
	{
		// approach 1 :  basic validation in then section
	// book is json array represented by []
		// inside [] there is array object seperated by , which is json object
		// we will write json path to get to particular record
	// if array is small we can write directly , if complicate use jsonpathfinder
		given()
			.contentType(ContentType.JSON)
		.when()
			.get("http://localhost:3000/store")
		.then()
			.statusCode(200)
			.log().all()
			.body("book[3].title", equalTo("The Lord of the Rings"))
			// we verified only one field like this we can verify multiple fields
			
		;
	
	}
	
//@Test(priority = 2)
	void testjsonresponse2()
	{
		// approach 2 : using response body.very useful approach and used mostly
// if you want to do many validations then we have to store response in
		// one object and do validations
		
		Response res =   // res is valranble has all response
		given()
			.contentType(ContentType.JSON)
		.when()
			.get("http://localhost:3000/store");
	// above assertions in then() comes from hamcrest marchers
	// to do validations from response object we will use testng assertions
			
			Assert.assertEquals(res.getStatusCode(),200); // validation 1
            Assert.assertEquals(res.header("Content-Type"),"application/json; charset=utf-8");
			
           String bookname = res.jsonPath().get("book[3].title").toString(); // response has json body we are extracting a particular field but 
            // its type is object so for validation we have to convert it into string
            
			Assert.assertEquals(bookname,"The Lord of the Rings" );
			
			
		
	
	}

//@Test(priority = 3)
void testjsonresponseBodydata_booktitle()
{
	// if i wnat to print all titles then
	// i have multiple books i want to check if particular record is present or not
	// Jsonobject class is used to traverse or parse entire json response
	// q> how do you parse json rsponse ?? 
	
	

	
	Response res =   
	given()
		.contentType(ContentType.JSON)
	.when()
		.get("http://localhost:3000/store");

	JSONObject js=new JSONObject(res.asString()); // it take one parameter i.e. response obj as string
	// to straverse json response we need to convert it into "**as**" string, not "xto stringx "
	// we will use for loop
	
	/*for(int i=0;i<js.getJSONArray("book").length();i++)
	{ // book is an array and we are getting its length in above statemtnts
		String booktitles = js.getJSONArray("book").getJSONObject(i).get("title").toString();
	// first we specified json array >> the array has json objects >> so we are going to each array
    // then >> getting titles >> as string
		System.out.println(booktitles);*/
		boolean b=false;
		for(int i=0;i<js.getJSONArray("book").length();i++) {
			
			String booktitles = js.getJSONArray("book").getJSONObject(i).get("title").toString();

			if(booktitles.equals("The Lord of the Rings"))
			{
				 b=true;
				 break; // we have to break else it will resturn false of last elment
			}
			
	}
	// in approach 1 we have mentioned json path now suppose if our object
		// is in other index then that assertion will fail but below assertion
		// will not fail because it is not dependent on json path
		Assert.assertTrue(b);
	
	
}
	
@Test(priority = 4)
void testjsonresponseBodydata_priceofbooks()
{
	Response res =   
	given()
		.contentType(ContentType.JSON)
	.when()
		.get("http://localhost:3000/store");

	JSONObject js=new JSONObject(res.asString()); 
	
	double totalprice=0;
		for(int i=0;i<js.getJSONArray("book").length();i++) {
			
			String price = js.getJSONArray("book").getJSONObject(i).get("price").toString();
			totalprice=totalprice+Double.parseDouble(price);
			
	}
	System.out.println(totalprice);
	Assert.assertTrue(totalprice<60);
	
//disadvantage : dynamic value cant be validated with this aporach
// manually executing before automation is mandatory so you know what response is

	// parsing : tarversing json response to get required field
	// how to parse json object  ????
	
	
}
	
	
}

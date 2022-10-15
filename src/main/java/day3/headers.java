package day3;
import static io.restassured.RestAssured.given;

import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

// headers information will remain same always except some like date etc.
// we will verify things like contenttype and contentencoding there 2 are imp
// servers also
public class headers 
{
	//Content-Type: text/html; charset=ISO-8859-1
	//Content-Encoding: gzip
	@Test
	void test_header()
	{given()
		
		.when()
			.get("https://www.google.co.in/")
		.then()
			.header("Content-Type", "text/html; charset=ISO-8859-1")
			.and()  // not neceasry required
			.header("Content-Encoding", "gzip")
			;

	}
	
	@Test
	void get_headers()
	{
		Response res = given()
		
		.when()
			.get("https://www.google.co.in/");
		String rr=res.getHeader("Content-Type");
		System.out.println(rr);
		
		Headers hdrs = res.getHeaders(); // not mapbut store in key;value
		for(Header hh: hdrs)
		{
			System.out.println(hh.getName()+"::"+hh.getValue());
			
		}

	}
	
	
	

}

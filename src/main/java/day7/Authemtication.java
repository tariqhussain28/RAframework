package day7;
import org.testng.annotations.Test;

import io.restassured.module.jsv.JsonSchemaValidator;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
public class Authemtication {
	/*
	 * authentication : User is valid or not Authorisation : User has a permission
	 * or assess to do something
	 * 
	 * 
	 * Authentication :
	 * 
	 * Basic         -----
	 * Digest        -----  all these 3 are similar and use username and password
	 * Preemptive     ----- but alogrithm will be different eg,sued by emails
	 * 
	 * token bearer
	 * 
	 * oath 1 and 2
	 * oath 2 : very critical and secure ,sensitiver apps uses oath 2 
	 * api key
	 * 
	 */

	@Test
	void authentications()
	{
		given()
	//		.auth().basic("username", "password")   // basic auth: it will direclt go to server
			// all authorisation will be part of given
	//		.auth().digest("username", "password") // lot of process will happen before going to server
			.auth().preemptive().basic("userrname", "password") // combo of basic and digest
			
		.when()
		.then()
		   .statusCode(200)
		   .body("Authenticated", equalTo(true))
		
		;
		
		
	}
	
	@Test
	void authentication()
	{
		String brtoken="qasdusaduiauahusukAUagugaugsaua";
		 given()
		 	.headers("Authorisation","Bearer "+brtoken)
		 .when()
		 	.get()	
		 .then()
		    .statusCode(200)
		 ;
		
	}
	
	
	@Test
	void oauth1()
	{
		 given()
		 .auth().oauth("consumerkey","consumer secret","accesstoken", "token secret")
    	 .when()
	 	      .get()	
	     .then()
	          .statusCode(200)
	 ;
	}
	
	@Test
	void oauth2()
	{
		 given()
		 .auth().oauth2("accesstoken")
    	 .when()
	 	      .get("")	
	     .then()
	          .statusCode(200)
	 ;
	}
	
	
	@Test
	void apikey()   // it need key-value pair
	{
		 given()
		 	.queryParam("key", "value of key")
    	 .when()
	 	      .get("")	
	     .then()
	          .statusCode(200)
	 ;
	}
	
	// dev will guide about authorisation they will create and dev will tell you
	
	
	
	
	
	
}

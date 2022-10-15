package api.tests;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoints.User_endpoints;
import api.endpoints.User_endpoints2;
import api.payloads.User_Payload;
import io.restassured.response.Response;

public class Usertest_Propfile
{
	Faker fake;
	User_Payload userPayload;
	public Logger logger;
	@BeforeClass
	public void Setup()
	{
		fake=new Faker();
		userPayload=new User_Payload();
		
		userPayload.setId(fake.idNumber().hashCode());
		userPayload.setUsername(fake.name().username());
		userPayload.setFirstName(fake.name().firstName());
		userPayload.setLastName(fake.name().lastName());
		userPayload.setEmail(fake.internet().safeEmailAddress());
		userPayload.setPassword(fake.internet().password(5,10));
		userPayload.setPhone(fake.phoneNumber().cellPhone());
		
		// logging
		logger=LogManager.getLogger(this.getClass());
		
		
	}
	
	@Test(priority = 1)
	public void TestPostUser()
	{
		logger.info("****creating user********");
		Response response = User_endpoints2.createUser(userPayload);
		response.then().log().all();
		Assert.assertEquals(response.statusCode(), 200);
		logger.info("****creating created********");
	}
	
	
	@Test(priority = 2)
	public void TestGetUser()
	{
		logger.info("****getting user********");
		Response response=User_endpoints2.readUser(this.userPayload.getUsername());
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(),200);
		logger.info("****got user********");
	}
	
	@Test(priority=3)
	public void TestPutUser()
	{
		logger.info("****updating user********");
		// update data using payload
		userPayload.setFirstName(fake.name().firstName());
		userPayload.setLastName(fake.name().lastName());
		userPayload.setEmail(fake.internet().safeEmailAddress());
		Response response=User_endpoints2.updateUser(this.userPayload.getUsername(), userPayload);
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);
		//response.then().log().body().statusCode(200);// this is chai assertions come with rest assured
	   
		//checking data after update
		Response responseafterupdate=User_endpoints.readUser(this.userPayload.getUsername());
		responseafterupdate.then().log().all();
		Assert.assertEquals(responseafterupdate.getStatusCode(),200);
	
		logger.info("****updated user********");
	}
	
	@Test(priority = 4)
	public void TestDeleteUser()
	{
		logger.info("****deleting user********");
		Response response=User_endpoints2.deleteUser(this.userPayload.getUsername());
		Assert.assertEquals(response.getStatusCode(), 200);
		logger.info("****deleted user********");
	}
	

}

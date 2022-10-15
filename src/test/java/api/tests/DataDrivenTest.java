package api.tests;
import org.testng.Assert;
import org.testng.annotations.Test;
import api.endpoints.User_endpoints;
import api.payloads.User_Payload;
import api.utilities.DataProviders;
import io.restassured.response.Response;
public class DataDrivenTest 
{
	
	@Test(priority = 1,dataProvider = "Data",dataProviderClass =DataProviders.class)
	// if dataprovider is in same class so third parameter not needed
	// since dp is in other class so we have to import that class 
	// that why third section ne needed. classname.class
	public void TestPostuser(String id,String username,String fname,String lname,String email,String pass,String pnumber)
	{// above order of parameters is same as order in excel 
		
		User_Payload userPayload=new User_Payload();
		
		userPayload.setId(Integer.parseInt(id));
		userPayload.setUsername(username);
		userPayload.setFirstName(fname);
		userPayload.setLastName(lname);
		userPayload.setEmail(email);
		userPayload.setPassword(pass);
		userPayload.setPhone(pnumber);
		
		Response response=User_endpoints.createUser(userPayload);
		Assert.assertEquals(response.getStatusCode(), 200);
		
		
	}
	
	
	//here we are deleting all user with username
	@Test(priority = 2,dataProvider = "UserNames",dataProviderClass = DataProviders.class)
	public void deleteuser(String username)
	{
	Response response=	User_endpoints.deleteUser(username);
	Assert.assertEquals(response.getStatusCode(), 200);
	}
	
	// same we can do with get request
	
}

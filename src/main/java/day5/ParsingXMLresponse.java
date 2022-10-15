package day5;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;

public class ParsingXMLresponse 
{
	// 
	
//	@Test
	void testxmlresponse()
	{
		// appraoach 1 :
	/*
    TravelerinformationResponse xmlns:xsd="http://www.w3.org/2001/XMLSchema" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance">
    <page>1</page>                      -----this are not node this are siblings of parenttag
    <per_page>10</per_page>             -----this are not node this are siblings of parenttag
    <totalrecord>9386</totalrecord>		-----this are not node this are siblings of parenttag
    <total_pages>939</total_pages>		-----this are not node this are siblings of parenttag
    <travelers>                     ---this is first node
        <Travelerinformation>
            <id>11133</id>
            <name>Developer</name>
            <email>Developer12@gmail.com</email>
            <adderes>USA</adderes>
            <createdat>0001-01-01T00:00:00</createdat>
        </Travelerinformation>
    */
		given()
		.when()
			.get("http://restapi.adequateshop.com/api/Traveler?page=1")
		.then()
			.statusCode(200)
			.header("Content-Type","application/xml; charset=utf-8")
			.body("TravelerinformationResponse.page", equalTo("1"))
			// everyline of xml is caleld node xpath or xml path is same
			// in xml we use . instead of / 
			// from root of parent we will go to respective node using . 
			//in above we are vlidation page number =1 or not 
			// in xml here index strt from 0 but in xpath index start from 1 
			.body("TravelerinformationResponse.travelers.Travelerinformation[0].name",equalTo("Developer"))
			;
		
		
		
	}
	
	//@Test
	void testxmlresponse2()
	{
		// appraoach 2 :

  Response res=
		given()
		.when()
			.get("http://restapi.adequateshop.com/api/Traveler?page=1");
		
	Assert.assertEquals(res.getStatusCode(), 200);
	Assert.assertEquals(res.getHeader("Content-Type"),"application/xml; charset=utf-8");
    
	// just like we have json path we also have xml path
	
	String name =
res.xmlPath().get("TravelerinformationResponse.travelers.Travelerinformation[0].name").toString();
	Assert.assertEquals(name, "Developer");
   // like this we can verify page id also and it will be same as string 
  
	
		
	}
	
	@Test
	void testxmlresponse3()
	{
		// appraoach 3 : using xmlpath class

  Response res=
		        given()
		        .when()
		        	.get("http://restapi.adequateshop.com/api/Traveler?page=1");
		XmlPath xp=new XmlPath(res.asString());
        // **as** string not to strong 
		// data ==string then tostring : object == string then as string
	List<String> travelers = xp.getList("TravelerinformationResponse.travelers.Travelerinformation");
	    // to get all nodes and it will sotre in list type	
	Assert.assertEquals(travelers.size(),10); // verify total number of travelers
	
	// now checking if particular name is present in response or not
	
	List<String> travelername = xp.getList("TravelerinformationResponse.travelers.Travelerinformation.name");
    // to get all nodes and it will sotre in list type	
	
	boolean bb=false;
	for(int i=0;i<travelername.size();i++)
	{
		String name=travelername.get(i);
		if(name.equals("karen"))
		{
			bb=true;
			break;
		}
		
	}
	
	Assert.assertTrue(bb);
	
	
	}
	
	// parsing == traversing
	// approach is same for json and xml but classes/method is differents
	

}

package day5;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.io.File;
public class fileupload
{

	@Test
	void singlefileupload()
	{
		File myfile=new File("c://automation//abc.txt"); // post 8080 is occumpied by jenkins
	                                                     // so we cant use this
		given()  // we are uploading file so it will come in given 
				.multiPart("file","myfile")        // key value pair  * mandatory  [spevifing form data]
				.contentType("multipart/form-data")       // * mandatory
		.when()
				.post("localhost:8080/fielupload")
		.then()
				.statusCode(200)
		// we can verify file name,file size , file type after upload 
				.body("filename",equalTo("abc.txt"))
				;
		// in c drive we can see upload file
		
	}
	
	@Test
	void multiplefileupload()
	{
		File myfile1=new File("c://automation//abc1.txt");   // specify number of file to upload
		File myfile2=new File("c://automation//abc2.txt");
		given()  
				.multiPart("files","myfile1")   // *files is one parameter not x file x        
				.multiPart("files","myfile2") 
				.contentType("multipart/form-data")
		.when()
				.post("localhost:8080/filesupload")
		.then()
				.statusCode(200)
				.body("[0].filename",equalTo("abc1.txt"))
				.body("[1].filename",equalTo("abc2.txt"))
		;
		
	}
	
	@Test
	void multiplefileupload2()
	{
		
		File myfile1=new File("c://automation//abc1.txt");   // specify number of file to upload
		File myfile2=new File("c://automation//abc2.txt");// we have to specify all file
		File myfile3=new File("c://automation//abc3.txt"); // no matter 2 or 100
		File myfile4=new File("c://automation//abc4.txt");
		
		// creating one file array ******** this way will not work in every api
		File filearr[]= {myfile1,myfile2,myfile3,myfile4};
		
		
		given()  
				.multiPart("files",filearr)   // *files is one parameter not x file x        
				.contentType("multipart/form-data")
		.when()
				.post("localhost:8080/filesupload")
		.then()
				.statusCode(200)
				.body("[0].filename",equalTo("abc1.txt"))
				.body("[1].filename",equalTo("abc2.txt"))
				.body("[2].filename",equalTo("abc3.txt"))
				.body("[3].filename",equalTo("abc4.txt"))
		;
		
	}
	
	
}

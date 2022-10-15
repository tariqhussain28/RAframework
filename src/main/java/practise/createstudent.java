package practise;

import org.json.JSONObject;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import static io.restassured.RestAssured.given;

import org.json.JSONObject;
import org.testng.ITestContext;
import org.testng.annotations.Test;

public class createstudent

{

	@Test
	void create(ITestContext context) {
		Faker fake=new Faker();
		JSONObject data = new JSONObject();
		data.put("name",fake.name().fullName());
		data.put("location",fake.country());
		data.put("phone", fake.phoneNumber());
		String coursear[] = { fake.book().genre(), fake.book().genre() };
		data.put("courses", coursear);
		int id = given().contentType("application/json").body(data.toString()).when()
				.post("http://localhost:3000/students").jsonPath().getInt("id");
		System.out.println("id:" + id);
		context.getSuite().setAttribute("userid", id);

	}

}

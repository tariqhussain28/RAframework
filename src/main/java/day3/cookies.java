package day3;

import static io.restassured.RestAssured.given;

import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.response.Response;

public class cookies {

	// when we get response so sometimes it contains cookies and headers
	//so we need to verify them also
	
	// cookies value changes everytime
	// we will check if cookies ar present or not
	//Set-Cookie: 1P_JAR=2022-10-02-10; expires=Tue, 01-Nov-2022 10:19:36 GMT; path=/; domain=.google.co.in; Secure
	//Set-Cookie: AEC=AakniGNPsARXzGUsK3Y25zUiwyg9V9YkidASDmEaHzCSEdkuz66o0hVLUw; expires=Fri, 31-Mar-2023 10:19:36 GMT; path=/; domain=.google.co.in; Secure; HttpOnly; SameSite=lax
	//Set-Cookie: NID=511=d1-x22t8ZCvBClBU0KMPqHyOJjsgNeEh0UgiMkdHhh4yCrRty9kgXQ8jbbqHhMXVB-TeOl23vUXq5Zu1tJp_taQIomtPDGvEwW3xMDgsEhRW1tcv78p8DhBTXg1hnwWZ90l99FPgJcs0GB9pvZocz0l-gYZMsNlpIRzVHCMRjso; expires=Mon, 03-Apr-2023 10:19:36 GMT; path=/; domain=.google.co.in; HttpOnly

	// aec,nid,1pjar are name and it has value
	//if values are changing then its working fine
	// beacuse after generating cookies for one time
	// server creates a new cookies with new value
	// so no 2 cookies has same value,if same then test fail

	
	
	@Test
	void testcookies()
	{
		given()
		
		.when()
			.get("https://www.google.co.in/")
		.then()
			.cookie("AEC",
"AakniGNPsARXzGUsK3Y25zUiwyg9V9YkidASDmEaHzCSEdkuz66o0hVLUw")
			.log().all();

	}
	
	@Test(priority = 2)
	void getcookiesinfo()
	{
		Response response=	
			given()
			.when()
				.get("https://www.google.co.in/");
		// we got response now extracting cookies info
		
	String cookievalue=response.getCookie("AEC"); 
	// name of cookies will not change but value changes
		System.out.println(cookievalue );
	
		System.out.println("----------");
			
		Map<String, String> cvalues = response.getCookies();
		
		System.out.println(cvalues.keySet());
		
		for(String key : cvalues.keySet())
		{
			System.out.println(key+":"+cvalues.get(key));
		}
		
	}
	
	
}

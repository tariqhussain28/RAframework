package day7;

import org.testng.annotations.Test;

import com.github.javafaker.Faker;

public class randomdata {
// we cant hardcode data for post request 
// we will generate dummy data 
// there is faker library . c/as java faker
	
	@Test
	
	void faker()
	{
		// all will be string there is documnetation given to get diff kind of data
		// every time it will generate new data randomly
		Faker fake=new Faker();
		String name = fake.name().fullName();
		String fname=fake.name().firstName();
		String lname=fake.name().lastName();
		String uname=fake.name().username();
		String pass=fake.internet().password();
		String pnumber=fake.phoneNumber().cellPhone();
		String email=fake.internet().emailAddress();
		
		System.out.println(name);
		System.out.println(fname);
		System.out.println(lname);
		System.out.println(pnumber);
		System.out.println(email);
		
	}
	
	
	
	
	
	
	
	
}

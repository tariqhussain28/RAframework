package practise;

import java.sql.Connection;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

public class c1 {

	@BeforeSuite
	public void m1()
	{
		System.out.println("before suite c1");
	}
	
	@BeforeTest
	public void m2()
	{
		System.out.println("before test c1");
	}
}

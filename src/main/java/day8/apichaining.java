package day8;

import org.testng.annotations.Test;

public class apichaining 
{/*
	 api chaining : Taking data from response from one api and using it in request 
	 for another api is called as api chaining
	 eg. when i register a used i will get id then i will use this id
	 for get, update,put,delete request.
	 we will use testng.xml file and its interface
======================================================================
	context.setAttribute("userid", id);
	above statement will work here but not when below classes are in different 
	test because it is limited to test i.e its scope is limited to test not suite 
		<test  name="Test">
    <classes>
      <class name="day8.createuser"/>         
      <class name="day8.getuser"/>
      <class name="day8.updateuser"/>
      <class name="day8.deleteuser"/>
    </classes>
  </test> <!-- Test -->

=======================================================================
context.setAttribute("userid", id); >> varaible is accessible to test level only not suite level
so it will fail in below xml suite

context.getSuite().setAttribute("userid", id); >> variable is accessible in whole suite, it wont fail 
if class are in same test or different tests

<test  name="Test1">
    <classes>
      <class name="day8.createuser"/>
    </classes>
  </test> <!-- Test -->
  <test  name="Test2">
    <classes>
      <class name="day8.getuser"/>
    </classes>
  </test> <!-- Test -->
  <test  name="Test3">
    <classes>
      <class name="day8.updateuser"/>
    </classes>
  </test> <!-- Test -->
  <test  name="Test4">
    <classes>
      <class name="day8.deleteuser"/>
    </classes>
  </test>

	*/
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}

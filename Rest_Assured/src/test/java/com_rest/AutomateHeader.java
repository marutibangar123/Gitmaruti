package com_rest;

import org.testng.annotations.Test;

import io.restassured.http.Header;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;


public class AutomateHeader
{
	
	@Test
	public void multipal_headers_using_Heders ()
	
	{
	
	Header header = new Header ("header","value2");
	Header matchheader = new Header ("x-mock-match-request-headers","header");
	
	
	 given().baseUri("https://d0577dc5-16c3-4bc2-a6dd-75d52a86106f.mock.pstmn.io").
	 
		header(header).
	    header(matchheader).
	    
	// optional aahe khalil
	    
	// header("header","value2").
	// header("x-mock-match-request-headers","header").
		 
	 when().get("/get").
		 
		 then().
		 
		 assertThat().
		 statusCode(200).log().all();
		 
		 
		 

	
	
	
 
	
		
	}

}

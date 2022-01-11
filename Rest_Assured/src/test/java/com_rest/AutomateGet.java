package com_rest;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class AutomateGet 
{
	@Test
	public void validate_get_status_code()
	{
		given().baseUri("https://api.postman.com").
		header("X-Api-Key","PMAK-61d6b181ea8a300f670c649e-74eb51309e3dabde143b05345776f0bba0").
		
		when().
		
		get("/workspaces").
		
		then().
		
		log().all().
		assertThat().
		statusCode(200).
		body("workspaces.name",contains("Personal Workspace", "My Workspace", "MyWorkspace"),
				"workspaces.name",is(not(empty())),
				"workspaces.name",hasSize(3));
	
	}

}
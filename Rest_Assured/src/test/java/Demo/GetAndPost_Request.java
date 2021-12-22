package Demo;

import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.json.simple.JSONObject;





public class GetAndPost_Request
{
	
	@Test
public void Test1()
{
		Response response =get("https://reqres.in/api/users?page=2");
	baseURI = "https://reqres.in/api";
	
	given().get("/users?page=2").then().statusCode(200).body("data[1].id", equalTo(8));
	
	System.out.println("statuscode"+":"+response.statusCode() );
}
	@Test
	public void PostTest()
	{
		JSONObject request = new JSONObject();
		
		request.put("name", "maruti");
		request.put("Number", "raj");
		
		System.out.println(request.toJSONString());
		
		baseURI="https://reqres.in/api";
		
		given().body(request.toJSONString()).when().post("/users").then().statusCode(201).log().all();
		
	}

}

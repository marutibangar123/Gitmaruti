package Demo;

import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;  // mention static in pkg
import io.restassured.response.Response;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.apache.commons.codec.binary.Base64;

public class Demo2 
{
	
	@Test
	public void Test1()
{
Response response =	get("https://reqres.in/api/users?page=2");

System.out.println(response.getStatusCode());
System.out.println(response.getTime());

System.out.println(response.getBody().asString());
System.out.println(response.getStatusLine());
System.out.println(response.getHeader("content-type"));

int expectedresult = response.getStatusCode();

Assert.assertEquals(expectedresult,200 );

}
	@Test
	public void Test2()
	{
		
		baseURI ="https://reqres.in/api";
		given().get("/users?page=2").then().statusCode(200).body("data.id[1]", equalTo(8)).log().all();
		
		//log().all() this method is use for to get the body data in consol output
	}
}

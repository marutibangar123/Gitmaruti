package Demo;


import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static  io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class Put_Patch_Delete

{
   @Test
   public void PutMethod ()
   {
	   JSONObject request = new  JSONObject();
	   
	   request.put("Number", "rajesh");
	   request.put("name", "maruti");
	   request.put("name", "marutibangar");
	   
	   baseURI = "https://reqres.in/api";
	   
	   
	   given().header("Content-Type","application/json").contentType(ContentType.JSON).accept(ContentType.JSON).body(request.toJSONString()).when().put("/users/2").then().statusCode(200).log().all();
   }
   
     @Test
      public void PatchMethod ()
      {
   	   JSONObject request = new  JSONObject();
   	   
   	   request.put("Number", "rajesh");
   	   request.put("name", "maruti");
   	   request.put("name", "marutibangar");
   	   
   	   baseURI = "https://reqres.in/api";
   	   
   	   
   	   given().header("Content-Type","application/json").contentType(ContentType.JSON).accept(ContentType.JSON).body(request.toJSONString()).when().patch("/users/2").then().statusCode(200).log().all();
      }
     
     @Test
     public void Delete_Method()
     {
    	 baseURI = "https://reqres.in";
    	 
    	 when().delete("/api/users/2").then().statusCode(204);
    	 
    	Response response = get("https://reqres.in/api/users/2");
    	
    	
    	System.out.println(response);
     }
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
}

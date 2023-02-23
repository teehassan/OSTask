package tests;

import static io.restassured.RestAssured.*;
//import io.restassured.response.Response;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import org.testng.annotations.Test;

public class VerifyAPI {
	
	//verify status code 
	@Test (priority=1)
	public void TestOne(){
		given().when().get("https://api.os.uk/downloads/v1").then().statusCode(200);
	}
	
	
	//Verify all payload
	@Test (priority=2)
	public void TestTwo(){
		given().when().get("https://api.os.uk/downloads/v1").then().log().body();
	}
	
	
	//get the status code 
	@Test (priority=0)
	public void TestThree(){
		int statusCode = given().
				when().get("https://api.os.uk/downloads/v1").getStatusCode();
		System.out.println("The response status code is " +statusCode);
	}
	
	
	//Verify content type
	@Test (priority=3)
	public void TestFour(){
		String contentType = given().when().
				get("https://api.os.uk/downloads/v1").then().extract().contentType();
		System.out.println("The content type response is " +contentType);
	}
	
	//Verify payload attribute and corresponding value
	@Test (priority=4)
	public void TestFive(){
		given().when().get("https://api.os.uk/downloads/v1").then()
		.body("links[2].title",equalTo("OS Downloads API Products List"));
	}
}

package getRequest;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetTC001 {
	
	
	
	
	@Test
	public void getWeatherDetails()
	{
		//Specify base URI
		RestAssured.baseURI="http://restapi.demoqa.com/utilities/weather/city";
		
		//Request object
		RequestSpecification httpRequest=RestAssured.given();
		
		//response Object
		Response response=httpRequest.request(Method.GET,"/Hyderabad");
		System.out.println(response.getBody().asString());
		
	}
	
	@Test
	void verifyCity()
	{
		//Specify base URI
		RestAssured.baseURI="http://restapi.demoqa.com/utilities/weather/city";
		
		//Request object
		RequestSpecification httpRequest=RestAssured.given();
		
		/*
		 * Scanner scan= new Scanner(System.in); String cityInput=scan.next()
		 */
		
		//response Object
		Response response=httpRequest.request(Method.GET,"/Hyderabad");
		System.out.println(response.getBody().asString());
		
		//Verify City
		String city=response.jsonPath().get("City");
		Assert.assertEquals(city, "Hyderabad");
		
	}
	
	@Test
	void getStatus()
	{
		//Specify base URI
		RestAssured.baseURI="http://restapi.demoqa.com/utilities/weather/city";
		
		//Request object
		RequestSpecification httpRequest=RestAssured.given();
		
		//response Object
		Response response=httpRequest.request(Method.GET,"/Hyderabad");
		System.out.println(response.getBody().asString());
		
		//Status Code
		System.out.println(response.getStatusCode());
		Assert.assertEquals(response.getStatusCode(), 200);
		
	}

}

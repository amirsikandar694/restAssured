package getRequest;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetTC002 {
	

	@Test
	void googleMap()
	{
		//Specify base URI
		RestAssured.baseURI="http://maps.googleapis.com";
		
		//Request object
		RequestSpecification httpRequest=RestAssured.given();
		
		//response Object
		Response response=httpRequest.request(Method.GET,"/Hyderabad");
		System.out.println(response.getBody().asString());
		
		//Status Code
		System.out.println(response.getStatusCode());
		//Assert.assertEquals(response.getStatusCode(), 200);
		
	}

}

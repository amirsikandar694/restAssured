package postRequest;

import java.util.Date;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PostTC001 
{
	
	
	@Test
	void register()
	{
		Date d=new Date();
		String val=d.toString().substring(11, 17);
		
		//Specify base URI
		RestAssured.baseURI="http://restapi.demoqa.com/customer";
		
		//Request object
		RequestSpecification httpRequest=RestAssured.given();

		
		//Request Payload sending along with the post request
		JSONObject request=new JSONObject();
		request.put("FirstName", "ASR1"+val);
		request.put("LastName", "ASR1"+val);
		request.put("UserName", "ASR1"+val);
		request.put("Password", "ASR1"+val);
		request.put("Email", "ASR1"+val+"@gmail.com");
		
		
		//Attach data to request
		httpRequest.header("Content-Type","application/json");
		httpRequest.body(request.toJSONString());
		
		

		//response Object
		Response response=httpRequest.request(Method.POST,"/register");
		System.out.println(response.getBody().asString());
		
		
		//Status Code
		System.out.println(response.getStatusCode());
		Assert.assertEquals(response.getStatusCode(), 201);
		
		String successCodeValidation=response.jsonPath().get("SuccessCode");
		System.out.println(successCodeValidation);
		Assert.assertEquals(successCodeValidation, "OPERATION_SUCCESS");
		 
		
	}


}

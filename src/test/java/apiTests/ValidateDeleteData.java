package apiTests;

import static org.hamcrest.Matchers.equalTo;

import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import api.utils.ApiHelper;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.ResponseSpecification;

public class ValidateDeleteData {
	
	ApiHelper apiHelper = new ApiHelper();;
	
	@Test
	public void deleteData() {
		ResponseSpecification responseSpec = new ResponseSpecBuilder().build();
		responseSpec.statusCode(200);
		responseSpec.contentType("application/json");
		
		Response response;
		
		try {
			response = apiHelper.deleteData(2);
			response.then().spec(responseSpec);
			JsonPath jsonPath = new JsonPath(response.asString());
			String jsonString = response.toString();
			System.out.println(jsonString);
			response.then().body("status",Matchers.equalToIgnoringCase("success"));
			response.then().body("data",equalTo("2"));
			System.out.println(jsonPath.get("message"));
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	@Test
	public void deleteInvalidData() {
		ResponseSpecification responseSpec = new ResponseSpecBuilder().build();
		responseSpec.statusCode(400);
		responseSpec.contentType("application/json");
		
		Response response;
		
		try {
			response = apiHelper.deleteData(0);
			response.then().spec(responseSpec);
			JsonPath jsonPath = new JsonPath(response.asString());
			String jsonString = response.toString();
			System.out.println(jsonString);
			response.then().body("status",Matchers.equalToIgnoringCase("error"));
			System.out.println(jsonPath.get("message"));
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}

package apiTests;

import static org.hamcrest.Matchers.equalTo;

import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import api.model.response.CreateEmployee;
import api.model.response.EmployeeDetails;
import api.model.response.GetData;
import api.utils.ApiHelper;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.ResponseSpecification;

public class ValidatePostData {
	
	
	ApiHelper apiHelper;

    @BeforeClass
    public void beforeClass() {
        apiHelper = new ApiHelper();
    }
    
	@Test
	public void createEmployee() {
		String jsonString;
		ResponseSpecification responseSpec = new ResponseSpecBuilder().build();
		responseSpec.statusCode(200);
		responseSpec.contentType("application/json");
		
		Response response;
		try {
			response = apiHelper.postData();
			response.then().spec(responseSpec);
			
			jsonString = response.toString();
			System.out.println(jsonString);
			
			
			CreateEmployee createResponse =
			  response.getBody().as(CreateEmployee.class); //response.
			  System.out.println(createResponse.getData().getId());
			  System.out.println(createResponse.getData().getSalary());
			  System.out.println(createResponse.getData().getName());
			  System.out.println(createResponse.getData().getAge());
			 
			response.then().body("status",Matchers.equalToIgnoringCase("success"));
			Assert.assertEquals(createResponse.getData().getName(), "test");
			Assert.assertEquals(createResponse.getData().getSalary(), "123");
			Assert.assertEquals(createResponse.getData().getAge(), "23");
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		
		
	}

}
 
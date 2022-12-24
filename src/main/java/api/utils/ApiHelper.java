package api.utils;

import java.util.HashMap;

import org.testng.Assert;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import api.model.requests.Employee;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class ApiHelper {
	
	public RequestSpecification getRequestSpec() {
		RequestSpecification reqSpec = new RequestSpecBuilder()		
				.setBaseUri("https://dummy.restapiexample.com")
				.setBasePath("/api/v1")
				.addHeaders(getHeaders()).build();
		return reqSpec;
	}
	
	public Response getData() {
		//RestAssured.baseURI = "https://dummy.restapiexample.com/api/v1";
		RequestSpecification reqSpec = new RequestSpecBuilder()		
				.setBaseUri("https://dummy.restapiexample.com")
				.setBasePath("/api/v1")
				.addHeaders(getHeaders()).build();

		Response response = null;
		try {
			response = RestAssured.given()
					.spec(reqSpec).get("/employees");
			response.then().log().all();
		} catch (Exception e) {
			Assert.fail("Get data is failing due to :: " + e.getMessage());
		}
		return response;
	}
	
	public Response getData(int id) {
		
		RequestSpecification reqSpec = getRequestSpec();
		Response response = null;
		try {
			response = RestAssured.given()
					.spec(reqSpec).get("/employee/"+id);
			response.then().log().all();
		} catch (Exception e) {
			Assert.fail("Get data is failing due to :: " + e.getMessage());
		}
		return response;
		
	}
	
	public Response postData() throws JsonProcessingException {
		//{"name":"test","salary":"123","age":"23"}
		
		Response response = null;
		Employee emp = new Employee();
		emp.setName("test");
		emp.setSalary("123");
		emp.setAge("23");
		ObjectMapper objectMapper = new ObjectMapper();
		String employeeJson = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(emp);
		System.out.println(employeeJson);
		
		RequestSpecification reqSpec = new RequestSpecBuilder()		
				.setBaseUri("https://dummy.restapiexample.com/api/v1")				
				.addHeaders(getHeaders())
				.setBody(employeeJson)
				.build();
		try {
			response = RestAssured.given()
					.headers(getHeaders())					
					.spec(reqSpec).post("/create");
			response.then().log().all();
		} catch (Exception e) {
			Assert.fail("post is failing due to :: " + e.getMessage());
		}
		
		return response;
	}
	
	public Response deleteData(int id) {
		
		Response response = null;
		RequestSpecification reqSpec = new RequestSpecBuilder()		
				.setBaseUri("https://dummy.restapiexample.com/api/v1")				
				.addHeaders(getHeaders())
				.build();
		try {
			response = RestAssured.given()
					.headers(getHeaders())					
					.spec(reqSpec).delete("/delete/"+id);
			response.then().log().all();
			
		}catch(Exception e) {
			Assert.fail("post is failing due to :: " + e.getMessage());
		}
		return response;
	}

	public HashMap<String, String> getHeaders() {
		HashMap<String, String> headers = new HashMap<String, String>();
		headers.put("Content-Type", "application/json");
		return headers;
	}

}

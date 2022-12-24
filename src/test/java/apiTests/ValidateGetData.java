package apiTests;


import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import api.model.response.EmployeeWithId;
import api.model.response.GetData;
import api.model.response.GetEmployee;
import api.utils.ApiHelper;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.ResponseSpecification;

public class ValidateGetData {
	
	ApiHelper apiHelper;

    @BeforeClass
    public void beforeClass() {
        apiHelper = new ApiHelper();
    }
    
    @Test
	public void getEmployees() {
		String jsonString;
		ResponseSpecification responseSpec = new ResponseSpecBuilder().build();
		responseSpec.statusCode(200);
		
		Response response = apiHelper.getData();
		response.then().spec(responseSpec);
		jsonString = response.toString();
		GetData loginResponse = response.getBody().as(GetData.class);
			
		GetEmployee emp = loginResponse.data.get(0);
		System.out.println(emp.getEmployee_age());
		System.out.println(emp.getEmployee_name());
		System.out.println(emp.getEmployee_salary());
		System.out.println(emp.getId());
		System.out.println(loginResponse.data.size());
		System.out.println(loginResponse.message);	
		
	}
    
    @Test
    public void getEmployeeById(){
    	
    	String jsonString;
		ResponseSpecification responseSpec = new ResponseSpecBuilder().build();
		responseSpec.statusCode(200);
		
		Response response = apiHelper.getData(2);
		response.then().spec(responseSpec);
		jsonString = response.toString();
		EmployeeWithId emp = response.getBody().as(EmployeeWithId.class);
			
		System.out.println(emp.getData().getEmployee_age());
		System.out.println(emp.getData().getEmployee_name());
		System.out.println(emp.getData().getEmployee_salary());
		System.out.println(emp.getData().getId());
		
    }
    

}

package assessmentputschemavalidation;


import java.io.File;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;

public class PutIncidentSchemaValidation extends RestAssuredBase {
    @Test(dependsOnMethods = "assessmentputschemavalidation.CreateIncident.create")
	public void put() {
    	Response response = RestAssured.given().contentType("application/json")
    			.header("Authorization","Bearer vyTohkhJERJZKeqy4TNfJwVlS6uTUb5ozvmVgjFguQ3iCQVbksfelfumjm80renOu_r9HCUInR_0ZFqhZ6217g")
    			.when().body(("{\r\n"
    	    			+ "    \"short_description\": \"Updated via RA Sarath\",\r\n"
    	    			+ "    \"description\": \"Description updated via RA Sarath\"\r\n"
    	    			+ "}")).put("/incident/"+sys_id);
    	response.prettyPrint();
    	
    	File fileName= new File("./src/main/resources/ValidateSchema.json");
        response.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(fileName));
    	System.out.println(response.getStatusCode());
    	
	}

}

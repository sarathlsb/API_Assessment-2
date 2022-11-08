package assessmentoauth;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class CreateWithOauth {
    @Test
	public void create() {
    	
    	RestAssured.baseURI="https://dev120775.service-now.com/api/now/table";
    	Response response = RestAssured.given().contentType("application/json")
    			.header("Authorization","Bearer vyTohkhJERJZKeqy4TNfJwVlS6uTUb5ozvmVgjFguQ3iCQVbksfelfumjm80renOu_r9HCUInR_0ZFqhZ6217g").when().body("{\r\n"
    			+ "    \"short_description\": \"created via Postman Sarath\",\r\n"
    			+ "    \"description\": \"Description added via Postman Sarath\"\r\n"
    			+ "}").post("/incident");
    	response.prettyPrint();
    JsonPath path = response.jsonPath();
    String sys_id = path.get("result.sys_id");
    System.out.println("The Extracted sys_ID is"+sys_id);
    	System.out.println(response.getStatusCode());
    	
  

	}

}

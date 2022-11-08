package assessmentoauth;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class DeleteWithOauth {
    @Test
	public void delete() {
    	
    	RestAssured.baseURI="https://dev120775.service-now.com/api/now/table";
    	Response response = RestAssured.given().header("Authorization","Bearer vyTohkhJERJZKeqy4TNfJwVlS6uTUb5ozvmVgjFguQ3iCQVbksfelfumjm80renOu_r9HCUInR_0ZFqhZ6217g")
    			.delete("/incident/d4f9327697721110aba1318c1253af97");
   
    	System.out.println(response.getStatusCode());
    	
  

	}

}

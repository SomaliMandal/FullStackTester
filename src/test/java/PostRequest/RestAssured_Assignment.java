package PostRequest;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import io.restassured.http.Header;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
public class RestAssured_Assignment {
	
	@Test
	public void postOrder() throws FileNotFoundException, IOException, ParseException {
		
	    JSONObject RegisterClient  = new JSONObject();
	    RegisterClient.put("clientName", "TestShop14");
	    RegisterClient.put("clientEmail", "TestShop14@gmail.com");
        
        Response response = given()
        		.contentType("application/json; charset=UTF-16")
        		.body(RegisterClient)
        		.post("https://simple-tool-rental-api.glitch.me/api-clients")
        		.then()
        		.statusCode(201)
        		.and()
        		.extract().response();
        
		System.out.println(readMethod(response).get("accessToken"));
		
		Integer toolid = given()
				.get("https://simple-tool-rental-api.glitch.me/tools")
				.then().statusCode(200)
				.and()
				.extract().response().path("id[0]");
		
		System.out.println(toolid);
		
	    JSONObject CreateOrder = new JSONObject();
	    CreateOrder.put("toolId", toolid);
	    CreateOrder.put("customerName", "John Doe");
          
        given()
        .header("Authorization", "Bearer " + readMethod(response).get("accessToken"))
                .contentType("application/json; charset=UTF-16")
                .body(CreateOrder)
                .post("https://simple-tool-rental-api.glitch.me/orders")
                .then().statusCode(201).log().all();
		
	}

	
	public static JSONObject readMethod(Response response) throws FileNotFoundException, IOException, ParseException {
		
		JSONParser rowData = new JSONParser();
		
		JSONObject jsonObject = (JSONObject) rowData.parse(response.asString());
		
		jsonObject.get(jsonObject);
		
		return(jsonObject);
	} 
	

}


package org.reqres;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class ReqRes {
	
	public static void main(String[] args) {
		RestAssured.baseURI="https://reqres.in/";
		
		Response res = RestAssured.given().header("Content-Type","application/json")
		.when().get("api/users?page=2");

		System.out.println(res.getStatusCode());
		System.out.println(res.body().asPrettyString());
	
	
	
		Response resPost = RestAssured.given().header("Content-Type","application/json").body("{\r\n" + 
				"    \"name\": \"morpheus\",\r\n" + 
				"    \"job\": \"leader\"\r\n" + 
				"}")
		.when().post("api/users");
		
		System.out.println(resPost.getStatusCode());
		System.out.println(resPost.getBody().asPrettyString());
	
	
		Response resPut = RestAssured.given().header("Content-Type","application/json").body("{\r\n" + 
				"    \"name\": \"morpheus\",\r\n" + 
				"    \"job\": \"zion resident\"\r\n" + 
				"}")
		.when().put("api/users/2");
	
		System.out.println(resPut.getStatusCode());
		System.out.println(resPut.getBody());
	
		Response resDelete = RestAssured.given().header("Content-Type","application/json")
		.when().delete("api/users/2");
	
	
		System.out.println(resDelete.getStatusCode());
		System.out.println(resDelete.getBody());
	
	
	
	
	
	
	}

}

package org.peeatics;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Preatics {
	static String key;

	public static void main(String[] args) {
		
		
		RestAssured.baseURI="https://googlegmail.atlassian.net/";
		
		System.out.println("=====================get======================");
		
		Response get = RestAssured.given().header("Content-Type","application/json")
		.auth().preemptive().basic("aravinthankumara@gmail.com", "o9nogkhvTXxsdczpVSq3BB20")
		.when().get("rest/api/2/search/");
		
		System.out.println(get.getStatusCode());
		
		System.out.println(get.getBody().asPrettyString());

		
		
		System.out.println("=====================post======================");
		
		
		Response post = RestAssured.given().header("Content-Type","application/json").body("{\r\n" + 
				"    \"fields\": {\r\n" + 
				"       \"project\":\r\n" + 
				"       {\r\n" + 
				"          \"key\": \"MZN\"\r\n" + 
				"       },\r\n" + 
				"       \"summary\": \"Ubdate new content\",\r\n" + 
				"       \"description\": \"Creating of an issue using project keys and issue type names using the REST API\",\r\n" + 
				"       \"issuetype\": {\r\n" + 
				"          \"name\": \"Bug\"\r\n" + 
				"       }\r\n" + 
				"   }\r\n" + 
				"}")
		.auth().preemptive().basic("aravinthankumara@gmail.com", "o9nogkhvTXxsdczpVSq3BB20")		
		.when().post("rest/api/2/issue/");
		
		System.out.println(post.getStatusCode());
		System.out.println(post.getBody().asPrettyString());
		
		Details as = post.as(Details.class);
	    key = as.getKey();
		System.out.println(key);
		
		System.out.println("=====================put======================");

		
		Response put = RestAssured.given().header("Content-Type","application/json").body("{\r\n" + 
				"    \"fields\" : {\r\n" + 
				"        \"summary\": \"Ubdate New Summary\",\r\n" + 
				"        \"description\": \"Ubdate new Description\"\r\n" + 
				"    }\r\n" + 
				"}")
		.auth().preemptive()
        .basic("aravinthankumara@gmail.com", "o9nogkhvTXxsdczpVSq3BB20")
        .when().put("rest/api/2/issue/"+key);
		
		System.out.println(put.getStatusCode());
		
		System.out.println(put.getBody().asPrettyString());
		
		System.out.println("=====================delete======================");

	
		Response delete = RestAssured.given().header("Content-Type","application/json")
		.auth().preemptive().basic("aravinthankumara@gmail.com", "o9nogkhvTXxsdczpVSq3BB20")
		.when().delete("rest/api/2/issue/"+key);
		
		System.out.println(delete.getStatusCode());
		
	}

}

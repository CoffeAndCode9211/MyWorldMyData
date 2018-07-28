package com.main.gson;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class TestGson {

	
	public static void main(String[] ele){
		
		String tokenInput = "{\"login\":{\"user\":\"sdn\",\"password\":\"skyline\"}}";
		
		JsonObject mainJson = new JsonParser().parse(tokenInput).getAsJsonObject();
		JsonObject geodata = mainJson.getAsJsonObject("login");
		String token = geodata.get("user").getAsString();
		System.out.println(token);
	}
}

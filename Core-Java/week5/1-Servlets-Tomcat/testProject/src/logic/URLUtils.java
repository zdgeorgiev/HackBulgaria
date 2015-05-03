package logic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

public class URLUtils {
	public static String getContent(URL url) {
		StringBuilder content = new StringBuilder();
		
		BufferedReader in;
		try {
			in = new BufferedReader(new InputStreamReader(url.openStream()));
			
			String line;
			
			while((line = in.readLine()) != null) {
				content.append(line);
			}
		} catch (IOException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		
		return content.toString();
	}
	
	public static String toJSON(URL url) {
		String content = getContent(url);
		
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		JsonParser jp = new JsonParser();
		JsonElement je = jp.parse(content);
		String prettyJsonString = gson.toJson(je);
		
		return prettyJsonString;
	}
}

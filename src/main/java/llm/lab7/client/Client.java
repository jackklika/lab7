package llm.lab7.client;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;

import llm.lab7.Racer;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class Client {
	
	public static void main(String[] args) {
		try {
			
			System.out.println("in the client");

			// Client will connect to this location
			URL site = new URL("http://localhost:8000/sendresults");
			HttpURLConnection conn = (HttpURLConnection) site.openConnection();

			// now create a POST request
			conn.setRequestMethod("POST");
			conn.setDoOutput(true);
			conn.setDoInput(true);
			DataOutputStream out = new DataOutputStream(conn.getOutputStream());

			// build a string that contains JSON from console
			String content = "";
			content = getJSON();

			// write out string to output buffer for message
			out.writeBytes(content);
			out.flush();
			out.close();

			System.out.println("Done sent to server");

			InputStreamReader inputStr = new InputStreamReader(conn.getInputStream());

			// string to hold the result of reading in the response
			StringBuilder sb = new StringBuilder();

			// read the characters from the request byte by byte and build up
			// the Response
			int nextChar;
			while ((nextChar = inputStr.read()) > -1) {
				sb = sb.append((char) nextChar);
			}
			System.out.println("Return String: " + sb);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}   
//
	private static String getJSON() {

		ArrayList<Racer> em = new ArrayList<Racer>();
		em.add(new Racer("1", "Klika", "J", "0:59:59.59"));
		em.add(new Racer("2", "Kalka", "F", "2:11:22.2"));
		em.add(new Racer("3", "Smith", "S", "1:00:00.31"));
		em.add(new Racer("4", "Katz", "S", "DNF"));
		em.add(new Racer("5", "Lewis", "T", "3:44:33.1"));
		em.add(new GUI().r);
		Gson g = new Gson();
		String json = g.toJson(em);
		return json;
	}

}

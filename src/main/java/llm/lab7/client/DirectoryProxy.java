package llm.lab7.client;

import java.util.ArrayList;
import java.util.Collection;

import com.google.gson.Gson;

import llm.lab7.Directory;
import llm.lab7.Racer;
import llm.lab7.server.DirectoryServer;

public class DirectoryProxy implements Directory{
private ArrayList<Racer> list = new ArrayList<Racer>();
private DirectoryServer ds = new DirectoryServer();

	public DirectoryProxy(DirectoryServer d) {
		this.ds = d;
	}

	public void add(Collection<Racer> e) {
		if(!list.contains(e)){
			list.addAll(e);
		}
		
		Gson gson = new Gson();
		String json = gson.toJson(list);
		System.out.println(json);
		
		Transport ts = new Transport();
		ts.send(json);
		
		list.clear(); // Clears the list since the master list exists in the server
	}
	

	public void print() {
		for (Racer tmp: list) {
	        System.out.println(tmp);
	    }
	}

	public void clear() {
		list.clear();
	}
	
	
	// Sends data to server directory
	private class Transport {
		
		public void send(String json){
			ds.md.receive(json);
		}
		
	}

}

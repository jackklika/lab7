package llm.lab7.client;

import java.util.ArrayList;
import java.util.Collection;

import com.google.gson.Gson;

import llm.lab7.Directory;
import llm.lab7.Employee;
import llm.lab7.server.DirectoryServer;

public class DirectoryProxy implements Directory{
private ArrayList<Employee> list = new ArrayList<Employee>();
private DirectoryServer ds = new DirectoryServer();

	public DirectoryProxy(DirectoryServer d) {
		this.ds = d;
	}

	public void add(Collection<Employee> e) {
		// TODO Auto-generated method stub
		if(!list.contains(e)){
			list.addAll(e);
		}
		
		Gson gson = new Gson();
		String json = gson.toJson(list);
		System.out.println(json);
		Transport ts = new Transport();
		ts.send(json);
	}
	

	public void print() {
		// TODO Auto-generated method stub
		for (Employee tmp: list) {
	        System.out.println(tmp);
	    }
	}

	public void clear() {
		// TODO Auto-generated method stub
		list.clear();
		
	}
	
	
	// Sends data to server directory
	private class Transport {
		
		public void send(String json){
			ds.md.receive(json);
		}
		
	}

}

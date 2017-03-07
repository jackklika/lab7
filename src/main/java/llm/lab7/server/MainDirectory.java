package llm.lab7.server;

import java.util.*;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.internal.$Gson$Types;
import java.lang.reflect.Type;

import llm.lab7.Directory;
import llm.lab7.Employee;

public class MainDirectory implements Directory{
	private ArrayList<Employee> list = new ArrayList<Employee>();
	
	public void add(Collection<Employee> e){
		
	}
	
	public void print(){
		
	}
	
	public void clear(){
		
	}
	
	
	public void receive(String json){
		Gson gson = new Gson();
		Type collectionType = new TypeToken<Collection<String>>(){}.getType();
		Collection<String> Employees2 = gson.fromJson(json, collectionType);
		 
	}
}

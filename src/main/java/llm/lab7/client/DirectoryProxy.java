package llm.lab7.client;

import java.util.ArrayList;
import java.util.Collection;

import llm.lab7.Directory;
import llm.lab7.Employee;

public class DirectoryProxy implements Directory{
private ArrayList<Employee> list = new ArrayList<Employee>();

	public void add(Collection<Employee> e) {
		// TODO Auto-generated method stub
		if(!list.contains(e)){
			list.addAll(e);
		}
	}
	

	public void print() {
		// TODO Auto-generated method stub
		String stdout = ;
	}

	public void clear() {
		// TODO Auto-generated method stub
		list.clear();
		
	}

}

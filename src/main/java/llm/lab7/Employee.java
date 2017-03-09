package llm.lab7;

import java.util.Comparator;

public class Employee {
	String firstName;
	String lastName;
	String department;
	Integer phone;

	Employee(String firstName, String lastName, String department, Integer phone) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.department = department;
		this.phone = phone;
	}

	public String toString() {

		String s = phone.toString();
		return s;
	}
 
	//Comparator to sort list items by last name
	//based on example here http://beginnersbook.com/2013/12/java-arraylist-of-object-sort-example-comparable-and-comparator/
	public static Comparator<Employee> NameComparator = new Comparator<Employee>(){
		public int compare(Employee e1, Employee e2){
			String name1 = e1.lastName;
			String name2 = e2.lastName;
			
			return name1.compareTo(name2);
		}
	};

}

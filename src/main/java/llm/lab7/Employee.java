package llm.lab7;

import java.util.Comparator;

public class Employee {
	String FirstName;
	String LastName;
	Integer Phone;
	String Department;

	private Employee(String FirstName, String LastName, Integer Phone, String Department) {
		this.FirstName = FirstName;
		this.LastName = LastName;
		this.Phone = Phone;
		this.Department = Department;
	}

	public String toString() {

		String s = Phone.toString();

		return s;
	}

	//Comparator to sort list items by last name
	public static Comparator<Employee> NameComparator = new Comparator<Employee>(){
		public int compare(Employee e1, Employee e2){
			String name1 = e1.LastName;
			String name2 = e2.LastName;
			
			return name1.compareTo(name2);
		}
	};

}

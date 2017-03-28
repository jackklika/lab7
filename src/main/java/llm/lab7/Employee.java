package llm.lab7;


public class Employee implements Comparable<Object>{
	
	public String firstName;
	public String lastName;
	public String department;
	public String phoneNumber;
	public String gender;
	public String title;
	
	public Employee(String title, String firstName, String lastName, String department, String phoneNum, String gender) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.department = department;
		this.phoneNumber = phoneNum;
		this.gender = gender;
		this.title = title;
	}
	
	@Override
	public String toString() {
		return firstName + " " + lastName + " \nDepartment: " + department + " \nPhone Number: " + phoneNumber + " \nGender: " + gender + " \nTitle " + title;
	}

	public int compareTo(Object o) {
		if (o instanceof Employee) {
			Employee other = (Employee) o;
			return lastName.compareTo(other.lastName);
		}
		return 0;
	}

}

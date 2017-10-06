import java.util.Comparator;

public class Employee implements Comparable<Employee> {
	private String ssn;
	private String lastName;
	private String firstName;

	public int compareTo(Employee emp) {
		return Comparator.comparing(Employee::getFirstName)
	              .thenComparing(Employee::getLastName)
	              .thenComparing(Employee::getSSN)
	              .compare(this, emp);
	}

	public Employee(String ssn, String lastname, String firstname) {
		this.ssn = ssn;
		this.lastName = lastname;
		this.firstName = firstname;
	}

	public String toString() {
		return "Employee[SSN = " + ssn + ", Last Name = " + lastName + ", First Name = " + firstName + "]";
	}

	public String getLastName() {
		return lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getSSN() {
		return ssn;
	}

	public void setLastName(String setLN) {
		lastName = setLN;
	}

	public void setFirstName(String setFN) {
		firstName = setFN;
	}

	public void setSSN(String setSSN) {
		ssn = setSSN;
	}
}
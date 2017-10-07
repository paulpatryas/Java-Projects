
/* By: Paul Patryas
 * Date: 07 Oct 2017
 * Employee abstract class 
 */

public abstract class Employee {
	
	// create private variables
	private String firstName;
	private String lastName;
	private String ssn;

	// Employee constructor
	public Employee(String firstName, String lastName, String ssn) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.ssn = ssn;
	}
	// set first name
	public void setFirstName(String firstN) {
		firstName = firstN;
	}
	
	// get first name
	public String getFirstName() {
		return firstName;
	}
	
	// set last name
	public void setLastName(String lastN) {
		lastName = lastN;
	}
	
	// get last name
	public String getLastName() {
		return lastName;
	}
	
	// set social security number 
	public void setSocialSecurityNumber(String socialSecuirtyN) {
		ssn = socialSecuirtyN;
	}
	
	// get social security number
	public String getSocialSecuirtyNumber() {
		return ssn;
	}
	
	// create String representation of Employee Object
	@Override
	public String toString() {
		return String.format("%s %s \nsocial security number: %s", 
		getFirstName(), getLastName(), getSocialSecuirtyNumber());
	}
		
	// abstract method overridden by concrete subclasses        
	public abstract double earnings(); // no implementation here
}
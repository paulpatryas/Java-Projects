
/* By: Paul Patryas
 * SalariedEmployee class 
 * Date: 07 Oct 2017
 */
public class SalariedEmployee extends Employee {

	// create private variable
	private double weeklySalary;
	
	// constructor
	public SalariedEmployee(String firstName, String lastName, String ssn, double salary) {
		super(firstName, lastName, ssn); // pass to Employee constructor
		setWeeklySalary(salary);
	}
	
	// set weekly salary
	public void setWeeklySalary(double salary) {
		if(salary >= 0.0)
			this.weeklySalary = salary;
		else
			throw new IllegalArgumentException("Weekly salary must be >= 0.0");
	}
	
	// get weekly salary
	public double getWeeklySalary() {
		return weeklySalary;
	}
	
	// calculate earnings; override abstract method earnings in Employee
	@Override
	public double earnings() {
		return getWeeklySalary();
	}
	
	// return String representation of SalariedEmployee object
	 public String toString() {
		return String.format("salaried employee: %s \n%s: $%.2f",
		super.toString(), "weekly salary" , getWeeklySalary() );
	 }         
}

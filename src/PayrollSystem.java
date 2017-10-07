/* By: Paul Patryas
 * Date: 07 Oct 2017
 * PayrollSystem class
 */

import java.util.Scanner;

public class PayrollSystem {

	public static void main(String[] args) {
		Scanner input1 = new Scanner(System.in);
		
		System.out.println("Enter first name of salaried employee: ");
		String firstName = input1.nextLine();
		
		System.out.println("Enter last name of salaried employee: ");
		String lastName = input1.nextLine();
		
		System.out.println("Enter social secuirty number of salaried employee: ");
		String ssn = input1.nextLine();
		
		System.out.println("Enter weekly salary of salaried employee: ");
		double weekSalary = input1.nextDouble();
		
		SalariedEmployee salariedEmployee = new SalariedEmployee(firstName, lastName, ssn, weekSalary);
		
		 // create one-element Employee array as an example
		Employee[] employees = new Employee[1];
		
		// initialize array with Employees
		employees[0] = salariedEmployee; 
		
		// print out all employees in the array (only one so far)
		for(Employee currentEmployee: employees) {
			System.out.println(currentEmployee);
			System.out.printf("earned $%,.2f", currentEmployee.earnings());
		}
		
		input1.close();
	}

}

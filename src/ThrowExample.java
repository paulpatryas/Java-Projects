import java.util.Scanner;

/* By: Paul Patryas
 * simple program for throw example
 * in Java
 */
public class ThrowExample {
	static void checkElgibility(int stu_age, int stu_weight) {
		if (stu_age < 15 && stu_weight < 45)
			throw new ArithmeticException("Student is not elgible for registration");
		else
			System.out.println("Student entry is valid.");
	}

	public static void main(String[] args) {

		System.out.println("Welcome to registration!");
		// create new scanner
		Scanner one = new Scanner(System.in);

		System.out.println("Enter age: ");
		int age = one.nextInt();

		System.out.println("Enter weight: ");
		int weight = one.nextInt();

		checkElgibility(age, weight);
		System.out.println("Have a nice day...");
		one.close(); // close scanner

	}

}

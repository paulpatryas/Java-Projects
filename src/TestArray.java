/* Written by: Paul Patryas 
   First crack at Java - Finding min & max of array values 
   Date: 01 Oct 2017 */

public class TestArray {
	// declare and initialize function
	static void min(int arr[]) {
		// set minimum & max array value to arr[0];
		int min = arr[0];
		int max = arr[0];

		// find & set minimum & maximum value
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] < min) {
				min = arr[i];
			}
			if (arr[i] > max) {
				max = arr[i];
			}
		}
		// print out max & minimum values
		System.out.println("Minimum value is: " + min);
		System.out.println("Maxmum value is: " + max);
	}

	public static void main(String[] args) {

		int[] numbers = { 1, 6, 4, 1024, 3, 1, 17, 5, 6, 231, 1, -21 };
		min(numbers);
	}
}

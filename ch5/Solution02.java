// Assignment 5-2
import java.util.Scanner;

public class Solution02 {

	private static String binaryToString(double n) {
		String ans = "0.";	// N is from 0 to 1
		
		// Multiplies 2 and append the digit in ones each time
		while (n != 0) {
			n = n * 2;
			int d = (int) n;	// Get the digit in ones
			ans += d;

			// If digit in ones is 1, remove it from the double
			if (d != 0)
				n = n - 1;

			// Check length
			if (ans.length() > 32) return "ERROR";
		}
		return ans;
	}

	// Main
	public static void main(final String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.print("Please input a double number: ");
		double n = Double.parseDouble(input.next());

		System.out.println(binaryToString(n));
			
	}
}


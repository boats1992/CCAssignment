// Assignment 5-6
import java.util.Scanner;

public class Solution06 {

	private static int conversion(int a, int b) {
		// Time: O(len) which len is no larger than 31, very small...

		int ans = 0;
		int digit = 1;
		// Check each digit to determine if they are same
		while (digit <= a || digit <= b) {
			if ((digit & a) != (digit & b))
				ans ++;
			digit = digit << 1;
		}

		return ans;
	}

	// Main
	public static void main(final String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.print("Please input two integers: ");
		int a = Integer.parseInt(input.next());
		int b = Integer.parseInt(input.next());

		System.out.println(conversion(a, b));
			
	}
}


// Assignment 5-4
import java.util.Scanner;

public class Solution04 {

	// Declaration:
	// Next largest number seems non-sense, so I guess this
	// problem is asking for the previous larges number wit
	// same number of 1s.

	private static int nextSmallest(int n) {
		// Test case:
		// 101100 -> 100100 -> 110100 -> 110001
		
		// No 1s, return error
		if (n <= 0) return -1;

		int checkLastOne = 1;
		boolean metOne = false;

		// Count how many 1s to add at the tail at last
		int cnt = 0;
		
		// Find the last 1 from most right
		while (!metOne || ((checkLastOne & n) != 0)) {
				if ((checkLastOne & n) != 0) {
					metOne = true;
					cnt++;
				}
				checkLastOne = checkLastOne << 1;
		}
		checkLastOne = checkLastOne >> 1;
		
		// Set the last 1 to be 0
		int ans = n & (~checkLastOne);

		// Set the 0 left to 1 as 1
		int checkLastZero = checkLastOne << 1;
		ans = ans | checkLastZero;

		// Set the 1s to the tail
		ans = ans & (~ (checkLastOne - 1)) | ((1 << cnt - 1) - 1);

		return ans;

	}

	private static int prevLargest(int n) {
		// Test Case:
		// 101100111 -> 101110111 -> 101010111 -> 101011110

		// Error
		if (n <= 1) return -1;

		int checkLastZero = 1;
		boolean metZero = false;

		// Count how many 0s to add at the tail at last
		int cnt = 0;
		
		// Find the last 0 from most right
		while (!metZero || ((checkLastZero & n) == 0)) {
				if ((checkLastZero & n) == 0) {
					metZero = true;
					cnt++;
				}
				checkLastZero = checkLastZero << 1;
				
				// All 1s, no 0
				if (checkLastZero > n)
					return -1;
		}
		checkLastZero = checkLastZero >> 1;
		
		// Set the last 0 to be 1
		int ans = n | checkLastZero;

		// Set the 1 left to 0 as 0
		int checkLastOne = checkLastZero << 1;
		ans = ans & (~checkLastOne);

		// Set the 0s to the tail
		ans = (ans | (checkLastZero - 1)) & ~((1 << (cnt - 1)) - 1);

		return ans;


	}

	// Main
	public static void main(final String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.print("Please input the integer: ");
		int n = Integer.parseInt(input.next());

		System.out.println(nextSmallest(n));
		System.out.println(prevLargest(n));
			
	}
}


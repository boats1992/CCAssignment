// Assignment 6-10
import java.util.Scanner;
import java.util.Random;

public class Solution10 {

	// Answer: It can be detected in 7 days.
	// Each bottle should have a independent index, which from 1 to 1000.
	// Represent the index as binary, and it will no longer than 10 (2^10 > 1000).
	// Drop one to the corresponding strip if the digit is one.
	// Then after 7 days, if the strip turns, it means that digit is one,
	// so using 10 strips, we can find the index of the poison bottle.

	// Simulation
	private static int checkPoison(boolean[] bottle) {
		int ans = 0;
		boolean[] strip = new boolean[10];
		
		// Add each bottle to its strip
		for (int i = 0; i < bottle.length; i++) {
			for (int j = 0; j < 10; j++) {
				if ((i & (1 << j)) != 0) {
					strip[j] |= bottle[i];
				}
			}
		}

		// Get result from strips
		for (int i = 0; i < 10; i++) {
			if (strip[i])
				ans |= (1 << i);
		}

		return ans;
	}

	// Main
	public static void main(final String[] args) {
		Scanner input = new Scanner(System.in);
	
		Random rand = new Random();

		int poison = rand.nextInt(1000);

		boolean[] bottle = new boolean[1000];

		System.out.println(poison);

		bottle[poison] = true;

		System.out.println(checkPoison(bottle));
			
	}
}


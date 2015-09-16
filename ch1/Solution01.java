// Assignment 1-1
import java.util.Scanner;

public class Solution01 {
	private static boolean CheckIsUnique(String s) {
		// Time: O(n)
		// Space: O(n)
		boolean[] check = new boolean[128];
		for (int i = 0; i < s.length(); i++) {
			if (check[s.charAt(i)]) {
				return false;
			}
			check[s.charAt(i)] = true;
		}
		return true;
	}

	private static boolean CheckIsUniqueWithoutExtraSpace(String s) {
		// Time: O(n^2)
		// Space: None
		for (int i = 0; i < s.length(); i++) {
			for (int j = i + 1; j < s.length(); j++ ) {
				if (s.charAt(i) == s.charAt(j)) {
					return false;
				}
			}
		}
		return true;
	}

	// Main
	public static void main(final String[] args) {
		System.out.print("Please input a string: ");
		Scanner input = new Scanner(System.in);
		String s = input.next();
		
		if (CheckIsUnique(s) && CheckIsUniqueWithoutExtraSpace(s))
			System.out.println("Is Unique");
		else
			System.out.println("Is Not Unique");
	}
}


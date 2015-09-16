// Assignment 1-4
import java.util.Scanner;
import java.util.Arrays;

public class Solution04 {
	private static boolean Palindrome(String s) {	
		// Time: O(n)
		// Space: k(128)
		char[] used = new char[128];
		for (int i = 0; i < s.length(); i++) {
			// Ignore space
			if (s.charAt(i) == ' ') continue;

			// Convert Captain alphabets
			if (s.charAt(i) >= 65 && s.charAt(i) <= 65+26) {
				used[s.charAt(i) + 97 - 65] += 1;
			} else {
				used[s.charAt(i)] += 1;
			}
		}

		// Check if each alphabet appears even times
		int flag = 0;
		for (int i = 0; i < 128; i++) {
			if (used[i] % 2 != 0) {
				flag++;
			}
			if (flag > 1) return false;
		}

		return true;
	}

	public static void main(final String[] args) {
		System.out.println("Please input a strings:");
		Scanner input = new Scanner(System.in);
		String s = input.nextLine();
		System.out.println(Palindrome(s));
	}
}


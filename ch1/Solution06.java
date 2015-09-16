// Assignment 1-6
import java.util.Scanner;
import java.util.Arrays;

public class Solution06 {
	private static String Compression(String s) {	
		// Time: O(n)
		// Space: O(n)
		
		if (s.equals("")) return "";
		s += '!';	// Mark last character
		String ans = "";

		char ch = s.charAt(0);
		int counter = 1;
		for (int i = 1; i < s.length(); i++) {
			if (s.charAt(i) == ch) {
				counter++;
			} else {
				ans += ch + Integer.toString(counter);
				ch = s.charAt(i);
				counter = 1;
			}
		}
	
		s = s.substring(0, s.length() - 1);
		if (ans.length() >= s.length()) {
			return s;
		}

		return ans;	
	}

	public static void main(final String[] args) {
		System.out.println("Please input a strings:");
		Scanner input = new Scanner(System.in);
		String s = input.nextLine();
		System.out.println(Compression(s));
	}
}


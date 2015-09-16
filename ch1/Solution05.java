// Assignment 1-5
import java.util.Scanner;
import java.util.Arrays;

public class Solution05 {
	private static boolean OneAway(String s1, String s2) {
		// Time: O(n)
		// Space: None
		if (Math.abs(s1.length() - s2.length()) > 1) {
			return false;
		}

		// Make s1 to be the short one
		if (s1.length() > s2.length()) {
			String tmp = s1;
			s1 = s2;
			s2 = tmp;
		}

		// try to insert into s1
		if (s1.length() < s2.length()) {
			for (int i = 0; i < s1.length(); i++) {
				if (s1.charAt(i) != s2.charAt(i)) {
					if (i != 0)
						s1 = s1.substring(0, i) + s2.charAt(i) + s1.substring(i);
					else
						s1 = s2.charAt(i) + s1;
					if (!s1.equals(s2)) 
						return false;
					else
						return true;
				}
			}
			return true;
		}

		// Else if length of s1 equals s2, try to replace
		int flag = 0;
		for (int i = 0; i < s1.length(); i++) {
			if (s1.charAt(i) != s2.charAt(i))
				flag++;
		}
		if (flag != 1)
			return false;

		return true;
	}

	public static void main(final String[] args) {
		System.out.println("Please input two strings:");
		Scanner input = new Scanner(System.in);
		String s1 = input.next();
		String s2 = input.next();
		
		System.out.println(OneAway(s1, s2));
	}
}


// Assignment 1-9
import java.util.Scanner;
import java.util.Arrays;

public class Solution09 {

	private static boolean isSubstring(String s1, String s2) {
		if (s1.indexOf(s2) == -1)
			return false;
		return true;
	}

	private static boolean StringRotation(String s1, String s2) {
		if (s1.length() != s2.length() || s1.length() == 0) {
			return false;
		}

		String ss = s1 + s1;
		if (isSubstring(ss, s2))
			return true;

		return false;
	}

	public static void main(final String[] args) {
		System.out.println("Please input two strings:");
		Scanner input = new Scanner(System.in);
		String s1 = input.next();
		String s2 = input.next();
		
		if (StringRotation(s1, s2))
			System.out.println("Is Rotation");
		else
			System.out.println("Is not Rotation");
	}
}


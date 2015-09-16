// Assignment 1-2
import java.util.Scanner;
import java.util.Arrays;

public class Solution02 {
	private static boolean CheckPermutation(String s1, String s2) {
		// Time: O(nlogn)
		// Space: O(n)
		if (s1.length() != s2.length()) {
			return false;
		}

		// Sort alphabets in strings
		char[] arr1 = s1.toCharArray();
		char[] arr2 = s2.toCharArray();
		Arrays.sort(arr1);
		Arrays.sort(arr2);
		s1 = new String(arr1);
		s2 = new String(arr2);
		
		if (s1.equals(s2))
			return true;
		else
			return false;
	}

	public static void main(final String[] args) {
		System.out.println("Please input two strings:");
		Scanner input = new Scanner(System.in);
		String s1 = input.next();
		String s2 = input.next();
		
		if (CheckPermutation(s1, s2))
			System.out.println("Is Permutation");
		else
			System.out.println("Is Not Permutation");
	}
}


// Assignment 1-3
import java.util.Scanner;
import java.util.Arrays;

public class Solution03 {
	private static String ReplaceSpace(String s, int len) {	
		// Time: O(len)
		// Space: O(len)
		char[] arr = s.toCharArray();
		String ans = "";
		for (int i = 0; i < len; i++) {
			if (arr[i] == ' ') {
				ans += "%20";
			} else {
				ans += arr[i];
			}
		}
		return ans;
	}

	public static void main(final String[] args) {
		System.out.println("Please input a strings:");
		Scanner input = new Scanner(System.in);
		String s = input.nextLine();
		System.out.println("Please input real length:");
		int len = Integer.parseInt(input.next());	
		System.out.println(ReplaceSpace(s, len));
	}
}


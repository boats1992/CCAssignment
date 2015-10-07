// Assignment 5-3
import java.util.Scanner;

public class Solution03 {

	private static int flipBit(int n) {
		// Time: O(len)
		// Space: O(1)

		// First, convert to binary string
		String s = Integer.toBinaryString(n);
		int len = s.length();

		// Mark last and current 1s segment
		int lastStart = 0, lastEnd = -1;	// For the very beginning and the situation
																			// of two 0s, set lastEnd as -1
		int nowStart = 0, nowEnd = 0;

		int ans = 0;

		while (nowStart < len) {
			// Find current segment
			while (nowEnd < len && s.charAt(nowEnd) == '1') nowEnd ++;
			
			ans = Math.max(ans, nowEnd - nowStart + lastEnd - lastStart + 1);

			// If current segment is followed with one 0, make it to last,
			// if current segment is followed with two 0s, make -1 as lastEnd
			if (nowEnd + 1 < len && s.charAt(nowEnd + 1) == '1') {
				lastStart = nowStart;
				lastEnd = nowEnd;
			} else {
				lastStart = 0;
				lastEnd = -1;

				// Check the situation of no last segment
				if (nowEnd < len) ans = Math.max(ans, nowEnd - nowStart + 1);
			}

			// Update new segment
			nowStart = nowEnd + 1;
			while (nowStart < len && s.charAt(nowStart) == '0') nowStart ++;
			nowEnd = nowStart;
		}

		return ans;
	}

	// Main
	public static void main(final String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.print("Please input the integer: ");
		int n = Integer.parseInt(input.next());

		System.out.println(flipBit(n));
			
	}
}


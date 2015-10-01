// Assignment 10-1
import java.util.Scanner;

public class Solution01 {

	// Time: O(N)
	private static void sortedMerge(int[] a, int[] b, int len1, int len2) {
		int i = len1 - len2 - 1;  // Pointer for a
		int j = len2 - 1;  // Pointer for b
		int k = len1 - 1;	 // Pointer for current sorted position

		// From back to front, merge b into a
		while (j >= 0) {
			if (i < 0 || a[i] < b[j]) {
				a[k] = b[j];
				j--;
			} else {
				a[k] = a[i];
				i--;
			}
			k--;
		}
	}

	// Main
	public static void main(final String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.print("Please input the length of first array: ");
		int len1 = Integer.parseInt(input.next());
		System.out.print("Please input the length of second array: ");
		int len2 = Integer.parseInt(input.next());
		int[] a = new int[len1 + len2];
		System.out.println("Please input each element in first array: "); 
		for (int i = 0; i < len1; i++) {
			a[i] = Integer.parseInt(input.next());
		}
		
		int[] b = new int[len2];
		System.out.println("Please input each element in second array: "); 
		for (int i = 0; i < len2; i++) {
			b[i] = Integer.parseInt(input.next());
		}

		sortedMerge(a, b, len1 + len2, len2);

		for (int i = 0; i < len1 + len2; i++)
			System.out.print(a[i] + " ");
	}
}


// Assignment 10-3
import java.util.Scanner;

public class Solution03 {

	// Time: O(logN)
	private static int binarySearch(int[] a, int st, int ed, int k) {
		// Cannot find
		if (ed < st) return -1;

		int mid = (st + ed) / 2;
		if (k == a[mid])
			return mid;

		// Check if left is in order
		if (a[st] <= a[mid]) {
			if (k > a[mid] || k < a[st])
				return binarySearch(a, mid + 1, ed, k);
			else
				return binarySearch(a, st, mid, k);
		} else {
			// left side is not in order
			if (k < a[mid] || k > a[ed])
				return binarySearch(a, st, mid, k);
			else
				return binarySearch(a, mid + 1, ed, k);
		}

	}
	
	private static int search(int[] a, int k) {
		return binarySearch(a, 0, a.length - 1, k);
	}

	// Main
	public static void main(final String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.print("Please input the length of the array: ");
		int len = Integer.parseInt(input.next());
		int[] a = new int[len];
		System.out.println("Please input each element in the array: "); 
		for (int i = 0; i < len; i++) {
			a[i] = Integer.parseInt(input.next());
		}

		System.out.println("Please input the value to search: ");
		int k = Integer.parseInt(input.next());
		
		System.out.println(search(a, k));

	}
}


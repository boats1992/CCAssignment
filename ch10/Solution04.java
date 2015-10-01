// Assignment 10-4
import java.util.Scanner;

public class Solution04 {

	// Realization of elementAt()
	private static int elementAt(int[] a, int i) {
		if (i >= a.length || i < 0)
			return -1;
		return a[i];
	}

	// Time: O(logN)
	private static int binarySearch(int[] a, int st, int ed, int k) {
		if (st > ed)
			return -1;

		int mid = (st + ed) / 2;
		
		// mid is still unavailable
		if (elementAt(a, mid) == -1)
			return binarySearch(a, st, mid - 1, k);

		// Found k
		if (elementAt(a, mid) == k)
			return mid;

		if (elementAt(a, mid) > k)
			return binarySearch(a, st, mid - 1, k);
		else
			return binarySearch(a, mid + 1, ed, k);
	}
	
	private static int search(int[] a, int k) {
		int i = 1;
		// First find the range of k's position
		while (elementAt(a, i) != -1 && elementAt(a, i) < k) {
			i *= 2;
		}
		// binary search the range
		return binarySearch(a, i/2, i, k);
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


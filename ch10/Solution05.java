// Assignment 10-5
import java.util.Scanner;

public class Solution05 {

	// Time: O(logN)
	private static int binarySearch(String[] a, int st, int ed, String k) {
		if (st > ed)
			return -1;

		int mid = (st + ed) / 2;
		
		// Find the nearest string that is not null
		if (a[mid].equals("")) {
			int i = 1;
			while (a[mid - i].equals("") && a[mid + i].equals(""))
				i++;
			if (!a[mid - i].equals(""))
				mid = mid - i;
			else
				mid = mid + i;
		}
		// out of range
		if (mid < st || mid > ed)
			return -1;

		if (a[mid].equals(k))
			return mid;

		if (a[mid].compareTo(k) > 0)
			return binarySearch(a, st, mid - 1, k);
		else
			return binarySearch(a, mid + 1, ed, k);
	}
	
	private static int search(String[] a, String k) {
		if (a.length == 0 || k.length() == 0)
			return -1;
		return binarySearch(a, 0, a.length - 1, k);
	}

	// Main
	public static void main(final String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.print("Please input the length of the array: ");
		int len = Integer.parseInt(input.nextLine());
		String[] s = new String[len];
		System.out.println("Please input each element in the array: "); 
		for (int i = 0; i < len; i++) {
			s[i] = input.nextLine();
		}

		System.out.println("Please input the string to search: ");
		String k = input.nextLine();
		
		System.out.println(search(s, k));

	}
}


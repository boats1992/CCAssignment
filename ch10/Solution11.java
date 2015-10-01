// Assignment 10-11
import java.util.Scanner;
import java.util.Arrays;

public class Solution11 {

	// Time: O(nlogn)
	private static int[] peakValley(int[] a) {
		Arrays.sort(a);
		int i = 0, j = a.length - 1;
		int[] b = new int[j + 1];
		int k = 0;
		while (i < j) {
			b[k] = a[i];
			b[k+1] = a[j];
			i++;
			j--;
			k += 2;
		}
		return b;
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

		int[] b = peakValley(a);

		for (int i = 0; i < len; i++)
			System.out.print(b[i] + " ");
	}
}


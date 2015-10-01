// Assignment 10-8
import java.util.Scanner;
import java.util.Arrays;

public class Solution08 {

	private static void findDuplicates(int[] a) {

		// Use bitmap, each integer contains 4 byte * 8 bits
		int[] bitmap = new int[32000/32 + 1];
		for (int i = 0; i < a.length; i++) {
			int num = a[i] - 1;
			if ((bitmap[num/32] & (1 << (num % 32))) != 0) {
				System.out.println(a[i]);
			} else {
				bitmap[num/32] = bitmap[num/32] | (1 << (num % 32));
			}
		}
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

		findDuplicates(a);
	}
}


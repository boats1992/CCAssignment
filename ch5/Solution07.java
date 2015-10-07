// Assignment 5-7
import java.util.Scanner;

public class Solution07 {

	private static int pairwiseSwap(int n) {
		// Right shift all the even digits, and
		// left shift all the odd digits
		// >>> makes sure the sign
		return ((n & 0xaaaaaaaa) >>> 1) | ((n & 0x55555555) << 1);
	}

	// Main
	public static void main(final String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.print("Please input the integer: ");
		int n = Integer.parseInt(input.next());

		System.out.println(pairwiseSwap(n));
			
	}
}


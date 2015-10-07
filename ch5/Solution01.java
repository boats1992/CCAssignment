// Assignment 5-1
import java.util.Scanner;

public class Solution01 {

	private static int insertion(int n, int m, int i, int j) {
		int allOne = ~9;	// Create all 1s
		int mask = (allOne << (j + 1)) | ~(allOne << (i - 1));	// Create a mask from i to j
		return (n & block) | ((m << i) & ~block);	// mask both n and m to give the answer
	}

	// Main
	public static void main(final String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.print("Please input N, M, i, j: ");
		int n = Integer.parseInt(input.next(), 2);
		int m = Integer.parseInt(input.next(), 2);
		int i = Integer.parseInt(input.next());
		int j = Integer.parseInt(input.next());

		System.out.println(Integer.toBinaryString(insertion(n, m, i, j)));
			
	}
}


// Assignment 1-7
import java.util.Scanner;
import java.util.Arrays;

public class Solution07 {
	private static void RotateMatrix(int n, int[][] matrix) {	
		// Time: O(n^2)
		// Space: O(n)
		
		// Deal with matrix in layers
		for (int i = 0; i < n/2; i++) {
			for (int j = i; j < n - i - 1; j++) {
				// up side
				int up = matrix[i][j];
				// left to up
				matrix[i][j] = matrix[n - j - 1][i];
				// down to left
				matrix[n - j - 1][i] = matrix[n - i - 1][n - j - 1];
				// right to down
				matrix[n - i - 1][n - j - 1] = matrix[j][n - i - 1];
				// up to right
				matrix[j][n - i - 1] = up;
			}
		}

		return;
	}

	public static void main(final String[] args) {
		System.out.println("Please input n:");
		Scanner input = new Scanner(System.in);
		int n = Integer.parseInt(input.next());
		int[][] matrix = new int[n][n];
		System.out.println("Please input matrix:");
		for (int i = 0; i < n; i++)
			for (int j = 0; j < n; j++)
				matrix[i][j] = Integer.parseInt(input.next());
		RotateMatrix(n, matrix);
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
	}
}


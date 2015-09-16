// Assignment 1-8
import java.util.Scanner;
import java.util.Arrays;

public class Solution08 {
	private static void RotateMatrix(int n, int m, int[][] matrix) {	
		// Time: O(n^2) worst
		// Space: O(1)
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (matrix[i][j] == 0) {
					for (int k = 0; k < n; k++) matrix[k][j] = -1;
					for (int k = 0; k < m; k++) matrix[i][k] = -1;
				}
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (matrix[i][j] == -1) {
					matrix[i][j] = 0;
				}
			}
		}

		return;
	}

	public static void main(final String[] args) {
		System.out.println("Please input n & m:");
		Scanner input = new Scanner(System.in);
		int n = Integer.parseInt(input.next());
		int m = Integer.parseInt(input.next());
		int[][] matrix = new int[n][m];
		System.out.println("Please input matrix:");
		for (int i = 0; i < n; i++)
			for (int j = 0; j < m; j++)
				matrix[i][j] = Integer.parseInt(input.next());
		RotateMatrix(n, m, matrix);
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
	}
}


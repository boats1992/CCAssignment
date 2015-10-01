// Assignment 10-9
import java.util.Scanner;

public class Solution09 {

	// Time: O(M + N)
	private static int[] search(int[][] a, int k) {
		int[] ans = new int[2];
		int x = a[0].length - 1;
		int y = 0;
		// Search from top right
		while (x >= 0 && y < a.length) {
			if (a[y][x] == k) {
				ans[0] = x;
				ans[1] = y;
				return ans;
			}
			if (a[y][x] < k)
				y++;
			else
				x--;
		}
		ans[0] = -1;
		ans[1] = -1;
		return ans;
	}

	// Main
	public static void main(final String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.print("Please input n & m: ");
		int n = Integer.parseInt(input.next());
		int m = Integer.parseInt(input.next());
		int[][] a = new int[n][m];
		
		System.out.println("Please input each element in the array: "); 
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				a[i][j] = Integer.parseInt(input.next());
			}
		}

		System.out.println("Please input the value to search: ");
		int k = Integer.parseInt(input.next());
		
		int[] ans = search(a, k);
		System.out.println(ans[0]  + " " + ans[1]);

	}
}


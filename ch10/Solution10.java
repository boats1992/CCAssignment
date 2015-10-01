// Assignment 10-10 
import java.util.Scanner;

public class Solution10 {

	// Time: average O(logn)
	//			 worst O(n)
	// Optimization: Balanced Tree
	public static class TreeNode {
		public int val;
		public int leftSize = 0;
		public TreeNode left = null;
		public TreeNode right = null;
		
		public TreeNode(int x) {
			val = x;
		}
	
		public void track(int x) {
			if (val < x) {
				if (right == null)
					right = new TreeNode(x);
				else
					right.track(x);
			} else {
				if (left == null) {
					left = new TreeNode(x);
					leftSize++;
				} else
					left.track(x);
			}
		}

		public int getRankOfNumber(int x) {

			// Found
			if (val == x)
				return leftSize;
			
			if (val < x) {
				if (right == null) return -1;
				return leftSize + 1 + right.getRankOfNumber(x);
			} else {
				if (left == null) return -1;
				return left.getRankOfNumber(x);
			}
		}
	}

	// Main
	public static void main(final String[] args) {
		Scanner input = new Scanner(System.in);
		TreeNode root = null;
		while (true) {
			System.out.println("Please select method: track(t) or getRank(g): ");
			String s = input.next();
			if (s.equals("t")) {
				System.out.println("Please input the value to insert: ");
				int x = Integer.parseInt(input.next());
				
				if (root == null)
					root = new TreeNode(x);
				else
					root.track(x);
			}
			if (s.equals("g")) {
				System.out.println("Please input the value to search: ");
				int x = Integer.parseInt(input.next());
				System.out.println(root.getRankOfNumber(x));
			}
		}
	}
}


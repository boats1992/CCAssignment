// Assignment 4-4
import java.util.Scanner;
import java.util.LinkedList;
import java.util.ArrayList;

public class Solution04 {

	public static class TreeNode {
		public int val;
		public TreeNode left = null;
		public TreeNode right = null;
	}

	// Time: O(n)
	// Space: O(h)
	private static int checkHeight(TreeNode root) {
		if (root == null) return 0;
		
		int leftH = checkHeight(root.left);
		if (leftH == -1) return -1;

		int rightH = checkHeight(root.right);
		if (rightH == -1) return -1;

		if (Math.abs(leftH - rightH) > 1)
			return -1;

		return Math.max(leftH, rightH) + 1;
	}

	private static boolean checkBalanced(TreeNode root) {
		if (checkHeight(root) == -1)
			return false;
		return true;
	}


	// Main
	public static void main(final String[] args) {
		System.out.print("Please input total number of nodes: ");
		Scanner input = new Scanner(System.in);
		int n = Integer.parseInt(input.next());

		TreeNode[] arr = new TreeNode[n];
		for (int i = 0; i < n; i++) {
			arr[i] = new TreeNode();
		}

		System.out.println("Please input val and children of each node (-1 for null): ");
		for (int i = 0; i < n; i++) {
			int v = Integer.parseInt(input.next());
			arr[i].val = v;
			int x = Integer.parseInt(input.next());
			if (x != -1) arr[i].left = arr[x];
			x = Integer.parseInt(input.next());
			if (x != -1) arr[i].right = arr[x];
		}

		System.out.println(checkBalanced(arr[0]));
	}
}


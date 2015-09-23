// Assignment 4-5
import java.util.Scanner;
import java.util.LinkedList;
import java.util.ArrayList;

public class Solution05 {

	public static class TreeNode {
		public int val;
		public TreeNode left = null;
		public TreeNode right = null;
	}

	// Check the min and max value of BST recursively to make sure it
	// follows the rule
	private static boolean validateBST(TreeNode root, Integer min, Integer max) {
		if (root == null)
			return true;

		if (min != null && root.val <= min || max != null && root.val > max)
			return false;

		if (!validateBST(root.left, min, root.val) || !validateBST(root.right, root.val, max))
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

		System.out.println(validateBST(arr[0], null, null));
	}
}


// Assignment 4-8
import java.util.Scanner;
import java.util.LinkedList;
import java.util.ArrayList;

public class Solution08 {

	public static class TreeNode {
		public int val;
		public TreeNode left = null;
		public TreeNode right = null;
	}

	public static TreeNode firstCommonAncestor(TreeNode root, TreeNode x, TreeNode y) {
		if (root == null)
			return null;

		// Try to get the FCA from left/right child of root
		TreeNode left = firstCommonAncestor(root.left, x, y);
		TreeNode right = firstCommonAncestor(root.right, x, y);

		if (root == x || root == y || left != null && right != null)
			return root;

		if (left != null || right != null) {
			return (left != null) ? left : right;
		}

		return null;
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

		System.out.println("Please input two nodes: ");
		int x = Integer.parseInt(input.next());
		int y = Integer.parseInt(input.next());

		System.out.println(firstCommonAncestor(arr[0], arr[x], arr[y]).val);
	}
}


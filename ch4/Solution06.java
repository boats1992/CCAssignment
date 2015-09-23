// Assignment 4-6
import java.util.Scanner;
import java.util.LinkedList;
import java.util.ArrayList;

public class Solution06 {

	public static class TreeNode {
		public int val;
		public TreeNode left = null;
		public TreeNode right = null;
		public TreeNode parent = null;
	}

	private static TreeNode Successor(TreeNode n) {
		if (n == null)
			return null;

		// If the node has node right child,
		// find the first legal parent.
		if (n.right == null) {
			TreeNode f = n.parent;
			while (f != null && f.left != n) {
				n = f;
				f = f.parent;
			}
			return f;
		}

		// If the node has right children,
		// return the left most child
		n = n.right;
		while (n.left != null)
			n = n.left;
		return n;
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

		System.out.println("Please input val, parent and children of each node (-1 for null): ");
		for (int i = 0; i < n; i++) {
			int v = Integer.parseInt(input.next());
			arr[i].val = v;
			int f = Integer.parseInt(input.next());
			if (f != -1) arr[i].parent = arr[f];
			int x = Integer.parseInt(input.next());
			if (x != -1) arr[i].left = arr[x];
			x = Integer.parseInt(input.next());
			if (x != -1) arr[i].right = arr[x];
		}

		System.out.println("Please input the index of node for successor: ");
		int x = Integer.parseInt(input.next());

		System.out.println(Successor(arr[x]).val);
	}
}


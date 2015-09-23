// Assignment 4-10
import java.util.Scanner;
import java.util.LinkedList;
import java.util.ArrayList;

public class Solution10 {

	public static class TreeNode {
		public int val;
		public TreeNode left = null;
		public TreeNode right = null;
	}

	public static boolean match(TreeNode t1, TreeNode t2) {
		// last node matches, return true
		if (t1 == null && t2 == null)
			return true;

		// Does not match if one of them is null
		if (t1 == null || t2 == null)
			return false;
		
		// Different value
		if (t1.val != t2.val)
			return false;
		
		// match left and right children
		return match(t1.left, t2.left) && match(t1.right, t2.right);
	}

	public static boolean checkSubtree(TreeNode t1, TreeNode t2) {
		// null is subtree for any tree
		if (t2 == null)
			return true;
		// t1 is null, no subtree
		if (t1 == null)
			return false;
		// if t1 == t2, check if they matches
		if (t1.val == t2.val && match(t1, t2))
			return true;

		// check children of t1
		return (checkSubtree(t1.left, t2) || checkSubtree(t1.right, t2));
	}

	// Main
	public static void main(final String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.print("Please input total number of nodes in first tree: ");
		int n = Integer.parseInt(input.next());

		TreeNode[] arr1 = new TreeNode[n];
		for (int i = 0; i < n; i++) {
			arr1[i] = new TreeNode();
		}

		System.out.println("Please input val and children of each node (-1 for null): ");
		for (int i = 0; i < n; i++) {
			int v = Integer.parseInt(input.next());
			arr1[i].val = v;
			int x = Integer.parseInt(input.next());
			if (x != -1) arr1[i].left = arr1[x];
			x = Integer.parseInt(input.next());
			if (x != -1) arr1[i].right = arr1[x];
		}
		
		System.out.print("Please input total number of nodes in second tree: ");
		int m = Integer.parseInt(input.next());

		TreeNode[] arr2 = new TreeNode[n];
		for (int i = 0; i < m; i++) {
			arr2[i] = new TreeNode();
		}

		System.out.println("Please input val and children of each node (-1 for null): ");
		for (int i = 0; i < m; i++) {
			int v = Integer.parseInt(input.next());
			arr2[i].val = v;
			int x = Integer.parseInt(input.next());
			if (x != -1) arr2[i].left = arr2[x];
			x = Integer.parseInt(input.next());
			if (x != -1) arr2[i].right = arr2[x];
		}

		System.out.println(checkSubtree(arr1[0], arr2[0]));
	}
}


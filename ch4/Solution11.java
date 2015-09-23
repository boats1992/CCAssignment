// Assignment 4-11
import java.util.Scanner;
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.Random;

public class Solution11 {

	public static class TreeNode {
		public int val;
		public TreeNode left = null;
		public TreeNode right = null;
		public int size = 0;
	}

	public static int setSize(TreeNode n) {
		if (n == null)
			return 0;
		n.size = setSize(n.left) + setSize(n.right) + 1;
		return n.size;
	}

	public static TreeNode getRandomNode(TreeNode root) {
		Random random = new Random();
		int p = random.nextInt(root.size);
		// p: 0 to left size - 1 
		if (root.left != null && p < root.left.size)
			return getRandomNode(root.left);
		// p: left size
		if (root.left == null && p == 0 ||
				root.left != null && p == root.left.size)
			return root;
		// Other value
		return getRandomNode(root.right);
	}

	// To insert or delete, need to maintain the size of each node
	// find is the same to general tree

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

		setSize(arr[0]);
		for (TreeNode node : arr) {
			System.out.println(node.size);
		}

		while (true)
			System.out.println(getRandomNode(arr[0]).val);
	}
}


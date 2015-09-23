// Assignment 4-2
import java.util.Scanner;

public class Solution02 {

	public static class TreeNode {
		public int val;
		public TreeNode left;
		public TreeNode right;
	}
	
	private static TreeNode MinimalTree(int arr[], int st, int ed) {
		if (ed < st) return null;
		TreeNode root = new TreeNode();
		root.val = arr[(st + ed) / 2];
		root.left = MinimalTree(arr, st, (st + ed) / 2 - 1);
		root.right = MinimalTree(arr, (st + ed) / 2 + 1, ed);
		return root;
	}

	private static int Height(TreeNode root) {
		if (root == null) return 0;
		int h1 = Height(root.left);
		int h2 = Height(root.right);
		return (h1 > h2) ? h1 + 1 : h2 + 1;
	}



	// Main
	public static void main(final String[] args) {
		System.out.print("Please input total number of nodes: ");
		Scanner input = new Scanner(System.in);
		int n = Integer.parseInt(input.next());

		int[] arr = new int[n];

		System.out.println("Please input the nodes: ");
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(input.next());
		}

		TreeNode root = MinimalTree(arr, 0, arr.length - 1);

		System.out.println(Height(root));
			
	}
}


// Assignment 4-12
import java.util.Scanner;
import java.util.HashMap;
import java.util.Random;

public class Solution12 {

	public static class TreeNode {
		public int val;
		public TreeNode left = null;
		public TreeNode right = null;
	}

	// Learnt this optimization method from textbook solution
	// Time: O(n)
	// Space: O(n)
	public static int countPaths(TreeNode root, int sum, int curSum,
															 HashMap<Integer, Integer> pathSum) {
		if (root == null)
			return 0;

		// update current sum in hashmap
		curSum += root.val;
		if (!pathSum.containsKey(curSum)) {
			pathSum.put(curSum, 1);
		} else {
			pathSum.put(curSum, pathSum.get(curSum) + 1);
		}

		int ans = 0;

		// path from root node
		if (pathSum.containsKey(curSum - sum)) {
			ans += pathSum.get(curSum - sum);
		}

		// path count from left/right children
		ans += countPaths(root.left, sum, curSum, pathSum);
		ans += countPaths(root.right, sum, curSum, pathSum);

		// remove this sum after finished
		pathSum.put(curSum, pathSum.get(curSum) - 1);

		return ans;
	}

	public static int pathsOfSum(TreeNode root, int sum) {
		HashMap<Integer, Integer> pathSum = new HashMap<Integer, Integer>();
		// For path from root
		pathSum.put(0, 1);
		return countPaths(root, sum, 0, pathSum);
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

		System.out.println("Please input the sum: ");
		int sum = Integer.parseInt(input.next());

		System.out.println(pathsOfSum(arr[0], sum));
	}
}


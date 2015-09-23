// Assignment 4-3
import java.util.Scanner;
import java.util.LinkedList;
import java.util.ArrayList;

public class Solution03 {

	public static class TreeNode {
		public int val;
		public TreeNode left = null;
		public TreeNode right = null;
	}

	// Return the height of the tree
	private static int Height(TreeNode root) {
		if (root == null) return 0;
		int h1 = Height(root.left);
		int h2 = Height(root.right);
		return (h1 > h2) ? h1 + 1 : h2 + 1;
	}

	private static ArrayList<LinkedList<TreeNode>> ListOfDepths(TreeNode root) {
		int h = Height(root);
		
		// List of LinkedList in each level
		ArrayList<LinkedList<TreeNode>> list = new ArrayList<LinkedList<TreeNode>>();
		for (int i = 0; i < h; i++) {
			list.add(new LinkedList<TreeNode>());
		}
		
		LinkedList<TreeNode> q = new LinkedList<TreeNode>();	// Queue of nodes
		LinkedList<Integer> level = new LinkedList<Integer>();	// Level of each node in queue
		q.add(root);
		level.add(0);
		
		// BFS
		// Time: O(n)
		// Space: O(n)
		while (!q.isEmpty()) {
			TreeNode cur = q.poll();
			int l = level.poll();
			LinkedList<TreeNode> newL = list.get(l);
			newL.add(cur);
			list.set(l, newL);
			if (cur.left != null) {
				q.add(cur.left);
				level.add(l + 1);
			}
			if (cur.right != null) {
				q.add(cur.right);
				level.add(l + 1);
			}
		}
		return list;
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

		ArrayList<LinkedList<TreeNode>> list = ListOfDepths(arr[0]);
		for (LinkedList<TreeNode> l : list) {
			while (!l.isEmpty()) {
				TreeNode node = l.poll();
				System.out.print(node.val + " ");
			}
			System.out.println();
		}
	}
}


// Assignment 4-9
import java.util.Scanner;
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.HashSet;

public class Solution09 {

	public static class Node {
		public int index;
		public int val = 0;
		public HashSet<Node> succ = new HashSet<Node>();
		public HashSet<Node> pred = new HashSet<Node>();
	}

	public static class Graph {
		public Node[] nodes;
		public Graph(int n) {
			nodes = new Node[n];
		}
	}

	public static class TreeNode {
		public int index;
		public int val;
		public TreeNode left = null;
		public TreeNode right = null;
	}

	// BUild a graph from the tree just like 4-8 with dependency
	public static void buildGraph(TreeNode root, Graph g) {
		g.nodes[root.index].val = root.val;
		if (root.left != null) {
			g.nodes[root.index].succ.add(g.nodes[root.left.index]);
			g.nodes[root.left.index].pred.add(g.nodes[root.index]);
			buildGraph(root.left, g);
		}
		if (root.right != null) {
			g.nodes[root.index].succ.add(g.nodes[root.right.index]);
			g.nodes[root.right.index].pred.add(g.nodes[root.index]);
			buildGraph(root.right, g);
		}
	}

	// Deep first search according to dependency
	public static void search(Graph g, HashSet<Integer> hashset, LinkedList<Integer> ans) {
		if (ans.size() == g.nodes.length) {
			for (Integer i : ans) {
				System.out.print(g.nodes[i].val + " ");
			}
			System.out.println();
			return ;
		}
		for (Node n : g.nodes) {
			if (!hashset.contains(n.index) && n.pred.size() == 0) {
				ans.add(n.index);
				hashset.add(n.index);
				for (Node node : n.succ) {
					node.pred.remove(n);
				}
				
				search(g, hashset, ans);
				
				ans.removeLast();
				hashset.remove(n.index);
				for (Node node : n.succ) {
					node.pred.add(n);
				}
			}
		}
		return;
	}

	public static void BSTSequence(TreeNode root, int length) {
		Graph g = new Graph(length);
		for (int i = 0; i < length; i++) {
			g.nodes[i] = new Node();
			g.nodes[i].index = i;
		}
		buildGraph(root, g);
		LinkedList<Integer> ans = new LinkedList<Integer>();
		HashSet<Integer> hashset = new HashSet<Integer>();
		search(g, hashset, ans);
		return ;
	}

	// Main
	public static void main(final String[] args) {
		System.out.print("Please input total number of nodes: ");
		Scanner input = new Scanner(System.in);
		int n = Integer.parseInt(input.next());

		TreeNode[] arr = new TreeNode[n];
		for (int i = 0; i < n; i++) {
			arr[i] = new TreeNode();
			arr[i].index = i;
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

		BSTSequence(arr[0], n);
	}
}


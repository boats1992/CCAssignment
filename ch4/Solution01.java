// Assignment 4-1
import java.util.Scanner;
import java.util.LinkedList;
import java.util.HashSet;

public class Solution01 {

	public static class Node {
		public int index;
		public Node[] children;
	}

	public static class Graph {
		public Node[] nodes;
		public Graph(int n) {
			nodes = new Node[n];
		}
	}

	// BFS
	// Time: O(n)
	// Space: O(n)
	private static boolean Route(Node start, Node end) {
		LinkedList<Node> q = new LinkedList<Node>();
		HashSet<Node> used = new HashSet<Node>();
		
		used.add(start);
		q.add(start);
		while (!q.isEmpty()) {
			Node cur = q.poll();
			for (Node ch : cur.children) {
				if (ch == end)
					return true;
				if (!used.contains(ch)) {
					used.add(ch);
					q.add(ch);
				}
			}
		}
		return false;
	}

	// Main
	public static void main(final String[] args) {
		System.out.print("Please input total number of nodes: ");
		Scanner input = new Scanner(System.in);
		int n = Integer.parseInt(input.next());

		Graph g = new Graph(n);
		for (int i = 0; i < n; i++) {
			g.nodes[i] = new Node();
			g.nodes[i].index = i;
		}

		// First input the number of edges of the node,
		// then input each node it connected to (directly).
		System.out.println("Please input each edge of nodes: "); 
		for (int i = 0; i < n; i++) {
			int m = Integer.parseInt(input.next());
			g.nodes[i].children = new Node[m];
			for (int j = 0; j < m; j++) {
				int x = Integer.parseInt(input.next());
				g.nodes[i].children[j] = g.nodes[x];
			}
		}

		// Input node index
		System.out.println("Please input the nodes to search: ");
		int start = Integer.parseInt(input.next());
		int end = Integer.parseInt(input.next());
		System.out.println(Route(g.nodes[start], g.nodes[end]));
			
	}
}


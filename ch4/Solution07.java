// Assignment 4-7
import java.util.Scanner;
import java.util.LinkedList;
import java.util.HashSet;
import java.util.ArrayList;

public class Solution07 {

	public static class Node {
		public int index;
		public HashSet<Node> succ = new HashSet<Node>();
		public HashSet<Node> pred = new HashSet<Node>();
	}

	public static class Graph {
		public Node[] nodes;
		public Graph(int n) {
			nodes = new Node[n];
		}
	}

	private static ArrayList<Node> buildOrder(Graph g) {
		boolean changes = true;
		ArrayList<Node> ans = new ArrayList<Node>();
		HashSet<Node> used = new HashSet<Node>();
		
		// Every time try to find a 
		while (changes) {
			changes = false;
			for (Node n : g.nodes) {
				if (!used.contains(n) && n.pred.isEmpty()) {
					ans.add(n);
					used.add(n);
					changes = true;
					for (Node next : n.succ) {
						next.pred.remove(n);
					}
				}
			}
		}
		
		// If the length of ans not equals to graph size,
		// there is invalid order, return null
		if (ans.size() != g.nodes.length)
			return null;

		return ans;
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

		System.out.println("Please input the number of edges: ");
		int m = Integer.parseInt(input.next());

		System.out.println("Please input each edge: "); 
		for (int i = 0; i < m; i++) {
			int x = Integer.parseInt(input.next());
			int y = Integer.parseInt(input.next());
			// Add successors and predeccessor to hashset of each node
			g.nodes[y].succ.add(g.nodes[x]);
			g.nodes[x].pred.add(g.nodes[y]);
		}

		ArrayList<Node> order = buildOrder(g);
		if (order == null) {
			System.out.println("Invalid Order");
			return;
		}
		for (Node node : order) {
			System.out.print(node.index + " ");
		}
			
	}
}


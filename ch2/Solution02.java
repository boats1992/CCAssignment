// Assignment 2-2
import java.util.Scanner;

public class Solution02 {

	public static class Node {
		Node next = null;
		int val;

		public Node(int v) {
			val = v;
		}
	}

	private static Node KthToLast(Node node, int k) {
		// Time: O(n)
		Node first = node;
		int count = 0;

		if (k <= 0) return null;

		// First iteration find the number of nodes
		while (node != null) {
			count++;
			node = node.next;
		}

		if (count < k) return null;

		// Second iteration find the kth to last
		node = first;
		int last = 0;
		while (last != count - k) {
			last++;
			node = node.next;
		}

		return node;
	}

	// Main
	public static void main(final String[] args) {
		System.out.print("Please input the length of list: ");
		Scanner input = new Scanner(System.in);
		int n = Integer.parseInt(input.next());
		
		// Used an array to simulate the Nodes, should not
		// access values by array.
		Node[] list = new Node[n];
		System.out.print("Please input the list: ");
		for (int i = 0; i < n; i++) {
			int x = Integer.parseInt(input.next());
			list[i] = new Node(x);
			if (i > 0)
				list[i-1].next = list[i];
		}

		System.out.print("Please input k: ");
		int k = Integer.parseInt(input.next());

		Node node = KthToLast(list[0], k);

		System.out.println(node.val);
	}
}


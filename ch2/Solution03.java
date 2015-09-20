// Assignment 2-3
import java.util.Scanner;

public class Solution03 {

	public static class Node {
		Node next = null;
		int val;
		public Node(int v) {
			val = v;
		}
	}

	private static void DeleteMidNode(Node node) {
		// Time: O(n)
		if (node == null) return;

		// Copy the value of next node to be this node's value
		if (node.next != null) {
			node.val = node.next.val;
			if (node.next.next == null)
				node.next = null;
		}

		DeleteMidNode(node.next);
		return;
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

		System.out.print("Please input the index of the node to delete: ");
		int k = Integer.parseInt(input.next());

		// Make sure k is in the middle of the list
		DeleteMidNode(list[k]);

		Node curNode = list[0];
		while (curNode != null) {
			System.out.print(curNode.val + " ");
			curNode = curNode.next;
		}

		System.out.println();
	}
}


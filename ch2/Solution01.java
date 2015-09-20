// Assignment 2-1
import java.util.Scanner;
import java.util.HashSet;

public class Solution01 {

	public static class Node {
		Node next = null;
		int val;

		public Node(int v) {
			val = v;
		}
	}

	private static void RemoveDups(Node node) {
		// Time: O(n)
		// Space: O(m)

		// If not allowed to use temporary buffer, we can use
		// two pointers to scan the list in O(n^2) time, each
		// time the pointers pointed to same value, delete one
		// of them.
		
		// HashSet to check if the value has occured.
		HashSet<Integer> used = new HashSet<Integer> ();

		Node prev = null;
		while (node != null) {
			if (!used.contains(node.val)) {
				used.add(node.val);
				prev = node;
			} else {
				prev.next = node.next;
				node = node.next;
			}
		}

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

		RemoveDups(list[0]);

		Node curNode = list[0];
		while (curNode != null) {
			System.out.print(curNode.val + " ");
			curNode = curNode.next;
		}

		System.out.println();
	}
}


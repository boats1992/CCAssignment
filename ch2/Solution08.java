// Assignment 2-8
import java.util.Scanner;

public class Solution08 {

	public static class Node {
		Node next = null;
		int val;
		public Node(int v) {
			val = v;
		}
	}

	private static Node LoopDetect(Node node) {
		// Time: O(n)

		Node fast = node;
		Node slow = node;

		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast) break;
		}

		// No loop found
		if (fast == null || fast.next == null)
			return null;

		slow = node;
		while (slow != fast) {
			slow = slow.next;
			fast = fast.next;
		}

		return slow;
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

		System.out.print("Please input the index of circular point "
										 + "(-1 for not loop): ");
		int k = Integer.parseInt(input.next());

		if (k != -1)
			list[n-1].next = list[k];

		Node node = LoopDetect(list[0]);

		if (node == null)
			System.out.println("Not loop!");
		else
			System.out.println(node.val);
	}
}


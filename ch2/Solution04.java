// Assignment 2-4
import java.util.Scanner;

public class Solution04 {

	public static class Node {
		Node next = null;
		int val;
		public Node(int v) {
			val = v;
		}
	}

	private static Node Partition(Node node, int k) {
		// Time: O(n)
		// Space O(n)
		Node less = null;
		Node larger = null;
		
		while (node != null) {
			Node next = node.next;
			if (node.val < k) {
				// Add to less list
				node.next = less;
				less = node;
			} else {
				// Add to larger list
				node.next = larger;
				larger = node;
			}
			node = next;
		}

		// Find the last of less list, point its next
		// to the head of larger list
		Node lessNode = less;
		while (lessNode.next != null) {
			lessNode = lessNode.next;
		}
		lessNode.next = larger;

		return less;
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

		System.out.print("Please input partition value: ");
		int k = Integer.parseInt(input.next());

		// Use curNode to record new list head
		Node curNode = Partition(list[0], k);

		while (curNode != null) {
			System.out.print(curNode.val + " ");
			curNode = curNode.next;
		}

		System.out.println();
	}
}


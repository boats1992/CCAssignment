// Assignment 2-6
import java.util.Scanner;

public class Solution06 {

	public static class Node {
		Node next = null;
		int val;

		public Node(int v) {
			val = v;
		}
	}

	private static boolean Palindrome(Node node) {
		// Time: O(n)
		// Space: O(n)

		// First reverse the list and save it
		Node reverse = null;
		Node cur = node;
		while (cur != null) {
			Node tmp = new Node(cur.val);
			tmp.next = reverse;
			reverse = tmp;
			cur = cur.next;
		}

		// Compare the list vs reversed list
		Node cur2 = reverse;
		cur = node;
		while (cur != null) {
			if (cur.val !=  cur2.val) return false;
			cur = cur.next;
			cur2 = cur2.next;
		}

		return true;
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

		System.out.println(Palindrome(list[0]));
	}
}


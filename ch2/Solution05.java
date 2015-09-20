// Assignment 2-5
import java.util.Scanner;

public class Solution05 {

	public static class Node {
		Node next = null;
		int val;
		public Node(int v) {
			val = v;
		}
	}

	private static Node SumList(Node node1, Node node2) {
		// Time: O(n + m)
		// Space O(max(n,m))
		
		// Follow up: If stored in forward order, first reverse
		// these two lists, then do the same thing.
		
		Node zero = new Node(0);
		Node ans = new Node(0);
		
		Node curAns = ans;
		Node lastAns = null;

		int add = 0;
		while (node1 != null || node2 != null) {
			// If one of the list ends, set digit to zero
			if (node1 == null)
				node1 = zero;
			if (node2 == null)
				node2 = zero;

			curAns.val = (node1.val + node2.val + add) % 10;
			add = (node1.val + node2.val + add) / 10;
			
			curAns.next = new Node(0);
			lastAns = curAns;
			curAns = curAns.next;
			node1 = node1.next;
			node2 = node2.next;
		}

		if (add != 0) {
			curAns.val = 1;
		} else {
			lastAns.next = null;
		}

		return ans;
	}

	// Main
	public static void main(final String[] args) {
		System.out.print("Please input the length of first list: ");
		Scanner input = new Scanner(System.in);
		int n = Integer.parseInt(input.next());
		
		// Used an array to simulate the Nodes, should not
		// access values by array.
		Node[] list1 = new Node[n];
		System.out.print("Please input the list: ");
		for (int i = 0; i < n; i++) {
			int x = Integer.parseInt(input.next());
			list1[i] = new Node(x);
			if (i > 0)
				list1[i-1].next = list1[i];
		}

		System.out.print("Please input the length of second list: ");
		int m = Integer.parseInt(input.next());
		
		Node[] list2 = new Node[m];
		System.out.print("Please input the list: ");
		for (int i = 0; i < m; i++) {
			int x = Integer.parseInt(input.next());
			list2[i] = new Node(x);
			if (i > 0)
				list2[i-1].next = list2[i];
		}

		// Use curNode to record new list head
		Node curNode = SumList(list1[0], list2[0]);

		while (curNode != null) {
			System.out.print(curNode.val + " ");
			curNode = curNode.next;
		}

		System.out.println();
	}
}


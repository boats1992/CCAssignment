// Assignment 2-7
import java.util.Scanner;

public class Solution07 {

	public static class Node {
		Node next = null;
		int val;
		public Node(int v) {
			val = v;
		}
	}

	private static Node Intersect(Node node1, Node node2) {
		// Time: O(n + m)
		// Space: O(1)

		int len1 = 0;
		Node cur1 = node1;
		while (cur1.next != null) {
			len1++;
			cur1 = cur1.next;
		}

		int len2 = 0;
		Node cur2 = node2;
		while (cur2.next != null) {
			len2++;
			cur2 = cur2.next;
		}

		// Last node not same, not intersect
		if (cur1 != cur2) return null;

		if (len1 != len2) {
			int k = len1 - len2;
			if (k > 0) {
				while (k != 0) {
					k--;
					node1 = node1.next;
				}
			} else {
				while (k != 0) {
					k++;
					node2 = node2.next;
				}
			}
		}

		while (node1 != node2) {
			node1 = node1.next;
			node2 = node2.next;
		}
		
		return node1;
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

		System.out.print("Please input the length of second list that do not intersect: ");
		int m = Integer.parseInt(input.next());
		
		Node[] list2 = new Node[m];
		System.out.print("Please input the list: ");
		for (int i = 0; i < m; i++) {
			int x = Integer.parseInt(input.next());
			list2[i] = new Node(x);
			if (i > 0)
				list2[i-1].next = list2[i];
		}

		System.out.print("Please input the index of first list that " +
										 "second one intersect to (-1 for not intersect):  ");

		int k = Integer.parseInt(input.next());
		if (k != -1) {
			list2[m-1].next = list1[k];
		}

		// Use curNode to record new list head
		Node intersectNode = Intersect(list1[0], list2[0]);
		if (intersectNode != null)
			System.out.println("Node value: " + intersectNode.val);
		else
			System.out.println("Not intersect!\n");
	}
}


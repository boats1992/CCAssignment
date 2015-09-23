// Assignment 3-5
import java.util.Scanner;
import java.util.Stack;
import java.lang.Exception;
import java.util.EmptyStackException;

public class Solution05 {

		public static class MyStack {
			Stack<Integer> st, tmp;

			public MyStack() {
				st = new Stack<Integer>();
				tmp = new Stack<Integer>();
			}

			public void push(int val) {
				st.push(val);
			}
			
			public Integer pop() {
				return st.pop();
			}

			public void sort() {
				// Time: O(n^2)
				// Space: O(n)
				// Idea: maintain tmp as a sorted stack, each time
				// a new element comes, pop all the nodes bigger than it
				// back to st, then push the element and get all the nodes
				// back.
				while (!st.empty()) {
					int t = st.pop();
					int cnt = 0;  // Counter of how many nodes has been moved
					while (!tmp.empty() && tmp.peek() > t) {
						st.push(tmp.pop());
						cnt++;
					}
					tmp.push(t);
					for (int i = 0; i < cnt; i++) {
						tmp.push(st.pop());	// Move back
					}
				}
				while (!tmp.empty()) {
					st.push(tmp.pop());
				}
			}

	}


	// Main
	public static void main(final String[] args) {
		Scanner input = new Scanner(System.in);

		MyStack st = new MyStack();

		while (true) {
			System.out.print("Please input an operation\n" +
											 "(push, pop, sort): ");
			String s = input.next();

			try {
				if (s.equals("push")) {
					int val = Integer.parseInt(input.next());
					st.push(val);
				} else if (s.equals("pop")) {
					System.out.println(st.pop());
				} else if (s.equals("sort")) {
					st.sort();
				} else {
					System.out.println("Error op, please re-enter.");
				}
			} catch (Exception e) {
				System.out.println("Stack overflows!");
			}
		}
	}
}


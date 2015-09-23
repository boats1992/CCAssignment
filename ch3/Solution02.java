// Assignment 3-2
import java.util.Scanner;
import java.util.Stack;
import java.lang.Exception;
import java.util.EmptyStackException;

public class Solution02 {

	// Extend from the java Stack class
	public static class MyStack extends Stack<Integer> {

		// Create a stack to record min values
		Stack<Integer> sMin;
		
		public MyStack() {
			sMin = new Stack<Integer>();
		}

		public void push(int val) {
			// If new value not bigger than current peek,
			// add it to stack
			if (sMin.empty() || sMin.peek() >= val) {
				sMin.push(val);
			}
			super.push(val);
		}

		public Integer pop() {
			// If current peek is the peek min value
			// pop them both
			if (sMin.peek() == super.peek()) {
				sMin.pop();
			}
			return super.pop();
		}

		// Time: O(1)
		public int min() {
			if (sMin.empty())
				throw new EmptyStackException();
			return sMin.peek();
		}
	}


	// Main
	public static void main(final String[] args) {
		Scanner input = new Scanner(System.in);

		MyStack st = new MyStack();

		while (true) {
			System.out.print("Please input an operation\n" +
											 "(push, pop, min): ");
			String s = input.next();

			try {
				if (s.equals("push")) {
					int val = Integer.parseInt(input.next());
					st.push(val);
				} else if (s.equals("pop")) {
					System.out.println(st.pop());
				} else if (s.equals("min")) {
					System.out.println(st.min());
				} else {
					System.out.println("Error op, please re-enter.");
				}
			} catch (Exception e) {
				System.out.println("Stack overflows!");
			}
		}
	}
}


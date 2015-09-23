// Assignment 3-4
import java.util.Scanner;
import java.util.Stack;
import java.lang.Exception;
import java.util.EmptyStackException;

public class Solution04 {

	// Optimized for continious add or popFirst
	public static class MyQueue {
		
		Stack<Integer> stAdd, stPopFirst;

		public MyQueue() {
			// The top of stAdd will be the tail of the queue
			stAdd = new Stack<Integer>();
			// The top of stPopFirst will be the head of the queue
			stPopFirst = new Stack<Integer>();
		}

		public void add(int val) {
			while (!stPopFirst.empty())
				stAdd.push(stPopFirst.pop());
			stAdd.push(val);
		}

		public Integer popFirst() {
			while (!stAdd.empty())
				stPopFirst.push(stAdd.pop());
			return stPopFirst.pop();
		}

	}


	// Main
	public static void main(final String[] args) {
		Scanner input = new Scanner(System.in);

		MyQueue q = new MyQueue();

		while (true) {
			System.out.print("Please input an operation\n" +
											 "(add, popFirst): ");
			String s = input.next();

			try {
				if (s.equals("add")) {
					int val = Integer.parseInt(input.next());
					q.add(val);
				} else if (s.equals("popFirst")) {
					System.out.println(q.popFirst());
				} else {
					System.out.println("Error op, please re-enter.");
				}
			} catch (Exception e) {
				System.out.println("Stack Overflows!");
			}
		}
	}
}


// Assignment 3-3
import java.util.Scanner;
import java.util.Stack;
import java.lang.Exception;
import java.util.EmptyStackException;
import java.util.ArrayList;
import java.lang.Integer;

public class Solution03 {

	public static class SetOfStacks {
		// Threshold
		private int capacity;
		// An ArrayList to record the set of stacks
		private ArrayList<Stack<Integer>> stacks;
		// Size of each stack
		private ArrayList<Integer> size;
				
		public SetOfStacks(int c) {
			stacks = new ArrayList<Stack<Integer>>();
			stacks.add(new Stack<Integer>());
			size = new ArrayList<Integer>();
			size.add(0);
			capacity = c;
		}

		public void push(int val) {
			// Check if last stack is full or not
			if (stacks.size() == 0 || size.get(stacks.size() - 1) == capacity) {
				Stack<Integer> newStack = new Stack<Integer>();
				newStack.push(val);
				stacks.add(newStack);
				size.add(1);
			} else {
				stacks.get(stacks.size() - 1).push(val);
				size.set(stacks.size() - 1, size.get(stacks.size() - 1) + 1);
			}
		}

		public Integer pop() {
			Stack<Integer> st = stacks.get(stacks.size() - 1);
			if (st == null) throw new EmptyStackException();
			Integer val = st.pop();
			
			// If after pop, the last stack become empty, we
			// delete it.
			if (st.empty()) {
				stacks.remove(stacks.size() - 1);
				size.remove(size.size() - 1);
			}
			return val;
		}

		// Be careful, popAt will destroy the structure of SetOfStacks
		public Integer popAt(int i) {
			Stack<Integer> st = stacks.get(i);
			Integer val = st.pop();
			if (st.empty()) {
				stacks.remove(i);
				size.remove(i);
			}
			return val;
		}

	}


	// Main
	public static void main(final String[] args) {
		System.out.println("Please input the capacity: ");
		Scanner input = new Scanner(System.in);
		int c = Integer.parseInt(input.next());

		SetOfStacks st = new SetOfStacks(c);

		while (true) {
			System.out.print("Please input an operation\n" +
											 "(push, pop, popAt): ");
			String s = input.next();

			try {
				if (s.equals("push")) {
					int val = Integer.parseInt(input.next());
					st.push(val);
				} else if (s.equals("pop")) {
					System.out.println(st.pop());
				} else if (s.equals("popAt")) {
					int index = Integer.parseInt(input.next());
					System.out.println(st.popAt(index));
				} else {
					System.out.println("Error op, please re-enter.");
				}
			} catch (Exception e) {
				System.out.println("Stack overflows!");
			}
		}
	}
}


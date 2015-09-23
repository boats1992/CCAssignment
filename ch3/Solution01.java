// Assignment 3-1
import java.util.Scanner;
import java.util.EmptyStackException;

public class Solution01 {

	// Used three fixed length stacks to divide the array.
	public static class MyStack {
		private int [] st;	// Stores elements
		private int [] size;	// Current size of each stack 
		private int [] capacity;	// Capacity of each stack
		private int totalSize;	// Total size of the array

		public MyStack(int totSize) {
			totalSize = totSize;
			st = new int[totSize];
			size = new int[3];
			capacity = new int[3];
			for (int i = 0; i < 3; i++)
				capacity[i] = totalSize/3;
			capacity[2] += totalSize%3;	// Last stack maybe has more space
		}

		// True if successfully pushed, false if the stack has
		// already been full.
		public boolean push(int i, int val) {
			if (size[i] == capacity[i])
				return false;
			size[i]++;
			st[size[i] + i * totalSize/3 - 1] = val;
			return true;
		}

		// Pop throws exception for empty stack
		public int pop(int i) {
			if (size[i] == 0)
				throw new EmptyStackException();
			size[i]--;
			return st[size[i] + i * totalSize/3];
		}

		// Peek throws exception for empty stack
		public int peek(int i) {
			if (size[i] == 0)
				throw new EmptyStackException();
			return st[size[i] + i * totalSize/3];
		}

		public boolean isEmpty(int i) {
			if (size[i] == 0)
				return true;
			return false;
		}
	}
			
	
	// Main
	public static void main(final String[] args) {
		System.out.print("Please input the total size of the three stacks: ");
		Scanner input = new Scanner(System.in);
		int size = Integer.parseInt(input.next());

		MyStack st = new MyStack(size);

		while (true) {
			System.out.print("Please input an operation\n" +
											 "(push, pop, peek, empty): ");
			String s = input.next();

			int i = Integer.parseInt(input.next());
			if (i < 0 || i > 3) continue;

			try {
				if (s.equals("push")) {
					int val = Integer.parseInt(input.next());
					if (!st.push(i, val)) {
						System.out.println("Stack " + i + " is full!");
					}
				} else if (s.equals("pop")) {
					System.out.println(st.pop(i));
				} else if (s.equals("peek")) {
					System.out.println(st.peek(i));
				} else if (s.equals("empty")) {
					System.out.println(st.isEmpty(i));
				} else {
					System.out.println("Error op, please re-enter.");
				}
			} catch (EmptyStackException e) {
				System.out.println("Stack overflows!");
			}
		}
	}
}


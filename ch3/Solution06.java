// Assignment 3-6
import java.util.Scanner;
import java.util.LinkedList;
import java.lang.Exception;
import java.util.EmptyStackException;

public class Solution06 {

	public static class Animal {
		String type;	// Dog or Cat
		int index;	// Unique ndex of the animal
		int time;	// Sequence of time added
		// Maybe other attributes

		public Animal(String t, int i) {
			type = t;
			index = i;
		}

		public String getType() {
			return type;
		}

		public int getIndex() {
			return index;
		}

		public void setTime(int t) {
			time = t;
		}

		public int getTime() {
			return time;
		}

	}

	public static class AnimalQueue {
		LinkedList<Animal> dogQueue, catQueue;
		int num;

		public AnimalQueue() {
			dogQueue = new LinkedList<Animal>();
			catQueue = new LinkedList<Animal>();
			num = 0;
		}

		public void enqueue(Animal a) {
			// Optimization to make sure num does not grow
			// too large
			if (dogQueue.peek() == null
					&& catQueue.peek() == null) {
				num = 0;
			}

			if (a.getType().equals("dog")) {
				dogQueue.add(a);
			} else {
				catQueue.add(a);
			}

			// Update the time of enqueuing
			a.setTime(num);
			num++;
		}

		public Animal dequeueDog() {
			return dogQueue.remove();
		}

		public Animal dequeueCat() {
			return catQueue.remove();
		}

		public Animal dequeueAny() {
			if (catQueue.peek().getTime() < dogQueue.peek().getTime()) {
				return catQueue.remove();
			}
			return dogQueue.remove();
		}

	}


	// Main
	public static void main(final String[] args) {
		Scanner input = new Scanner(System.in);

		AnimalQueue a = new AnimalQueue();

		while (true) {
			System.out.print("Please input an operation\n" +
											 "(enqueue, dog, cat, any): ");
			String s = input.next();

			try {
				if (s.equals("enqueue")) {
					System.out.print("Please input index and type: ");
					int i = Integer.parseInt(input.next());
					String t = input.next();
					Animal ani = new Animal(t, i);
					a.enqueue(ani);
				} else if (s.equals("dog")) {
					System.out.println(a.dequeueDog().getIndex());
				} else if (s.equals("cat")) {
					System.out.println(a.dequeueCat().getIndex());
				} else if (s.equals("any")) {
					System.out.println(a.dequeueAny().getIndex());
				} else {
					System.out.println("Error op, please re-enter.");
				}
			} catch (Exception e) {
				System.out.println("Stack overflows!");
			}
		}
	}
}


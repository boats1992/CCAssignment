// Assignment 5-8
import java.util.Scanner;

public class Solution08 {

	private static boolean drawLine(byte[] screen, int width, int x1, int x2, int y) {
		// Make sure x1 < x2
		if (x2 < x1) {
			int t = x2;
			x2 = x1;
			x1 = t;
		}

		int height = screen.length / width;
		// Out of boundary
		if (y > height) return false;

		// Set the bytes from x1 to x2 as all 1s
		for (int i = x1/8; i <= x2/8; i++)
			screen[y * width + i] = (byte) 0xff;
	
		byte x1Offset = (byte) ((1 << (8 - x1 % 8)) - 1);
		byte x2Offset = (byte) ((1 << (8 - x2 % 8 - 1)) - 1);

		// Set left of x1 to be 0 and right of x2 to be 0
		screen[y * width + x1/8] = (byte) (screen[y * width + x1/8] & x1Offset);
		screen[y * width + x2/8] = (byte) (screen[y * width + x2/8] & ~x2Offset);

		return true;

	}

	// Main
	public static void main(final String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.println("Please input total pixel numbers, the width, x1, x2, y: ");
		int n = Integer.parseInt(input.next());
		int width = Integer.parseInt(input.next());
		int x1 = Integer.parseInt(input.next());
		int x2 = Integer.parseInt(input.next());
		int y = Integer.parseInt(input.next());

		byte[] screen = new byte[n/8];

		if (!drawLine(screen, width, x1, x2, y))
			System.out.println("Error");
		else {
			for (int i = 0; i < screen.length; i++) {
				if (i % width == 0) System.out.println();
				System.out.print(String.format("%8s", Integer.toBinaryString(screen[i] & 0xff)).replace(' ', '0'));
			}
		}
	}
}


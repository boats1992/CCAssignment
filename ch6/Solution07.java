// Assignment 6-7
import java.util.Scanner;
import java.util.Random;

public class Solution07 {

	// Logically:
	// Since we can give a law that family should stop give birth
	// till there is a boy, and these two policies can add up to 
	// all situations. As they are totally opposite policies,
	// the ratio should be same, 0.5.

	// Simulation
	private static double girlOrBoy(int n) {
		int girlCnt = 0, boyCnt = 0;
		for (int i = 0; i < n; i++) {
			Random rand = new Random();
			while (true) {
				if (rand.nextBoolean()) {
					boyCnt++;
				} else {
					girlCnt++;
					break;
				}
			}
		}
		return (double) girlCnt/ (double) boyCnt;
	}

	// Main
	public static void main(final String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.print("Please input number of families: ");
		int n = Integer.parseInt(input.next());

		System.out.println(girlOrBoy(n));
			
	}
}


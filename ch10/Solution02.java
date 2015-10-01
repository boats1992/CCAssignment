// Assignment 10-2
import java.util.Scanner;
import java.util.HashMap;
import java.util.Arrays;
import java.util.ArrayList;

public class Solution02 {

	// Time: O(N)
	// Space: O(N)
	private static void groupAnagrams(String[] s) {
		HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
		
		for (int i = 0; i < s.length; i++) {
			// Sort charactors in each string
			char[] ch = s[i].toCharArray();
			Arrays.sort(ch);
			String st = new String(ch);
		
			// Use the sorted string as key, add string to arraylist as value
			ArrayList<String> arr = new ArrayList<String>();
			if (map.containsKey(st)) {
				arr = map.get(st);
			}
			arr.add(s[i]);
			map.put(st, arr);
		}

		// Refresh the array list
		int i = 0;
		for (String key : map.keySet()) {
			ArrayList<String> arr = map.get(key);
			for (String st : arr) {
				s[i] = st;
				i++;
			}
		}
	}

	// Main
	public static void main(final String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.print("Please input the length of the array: ");
		int len = Integer.parseInt(input.next());
		String[] s = new String[len];
		System.out.println("Please input each element in the array: "); 
		for (int i = 0; i < len; i++) {
			s[i] = input.next();
		}
		
		groupAnagrams(s);

		for (int i = 0; i < len; i++)
			System.out.print(s[i] + " ");
	}
}


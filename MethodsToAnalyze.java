/**
 * A collection of methods that work with arrays of ints.
 * 
 * @author mvail
 */
public class MethodsToAnalyze {

	/**
	 * Return index where value is found in array or -1 if not found.
	 * @param array ints where value may be found
	 * @param value int that may be in array
	 * @return index where value is found or -1 if not found
	 */

	public static int find(int[] array, int value) { // WORST: 2 + 3n == O(n) // BEST: 3 == O(1) // AVE: 2 + 1.5n == O(n)
		for (int i = 0; i < array.length; i++) { // 1 @ i=0, 1 @ i< array.length, 1n @ i++
			if (array[i] == value) { // 1 @ check each time == 1n
				return i; // Says returns are not to be counted
			}
		} // 1n @ check loop condition
		return -1; // Says returns are not to be counted
	}

	/**
	 * Replace all occurrences of oldValue with newValue in array.
	 * @param array ints where oldValue may be found
	 * @param oldValue value to replace
	 * @param newValue new value
	 */
	public static void replaceAll(int[] array, int oldValue, int newValue) { // WORST: (3 + 3(n-1)) + 2 + 1n + (2n + 1.5n^2) + 1n == 2 + 7n + 1.5n^2 // BEST: 4 + 3n // AVERAGE: 
		int index = find(array, oldValue); // 1 @ call for this then 3 + 3(n-1) @ find with highest index
		while (index > -1) { // Best for this is 0, but the find uses 2 + 3n // 1 @ initial check
			array[index] = newValue; // 1n
			index = find(array, oldValue); // n(2 + 1.5n)
		} // 1n @ check loop condition
	}
	
	/**
	 * Take an int[] and reorganize it so they are in ascending order.
	 * @param array ints that need to be ordered 
	 */
	public static void sortIt(int[] array) { // WORST: I just did all the math on the sheet// BEST: // AVERAGE: 
		for (int next = 1; next < array.length; next++) {// 1 @ next=1, 1 @ next < array.length, 1n @ next++
			int value = array[next]; // 1n
			int index = next; // 1n
			while (index > 0 && value < array[index - 1]) { // 1n @ index > 0, 1n @ value < array[index - 1], n(2n) @ check loop condition
				array[index] = array[index - 1]; // n(1n)
				index--; // n(1n)
			}
			array[index] = value; // 1n
		}
	}
}

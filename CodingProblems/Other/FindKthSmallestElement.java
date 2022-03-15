/*
Find the smallest Kth element in an unsorted array if smallest Kth element is not present return null.

Example 1: 0101111001 K=3 Output: NULL
Example 2: 93272538 K=4 Output: 7
*/
public class FindElement {

	public static void main(String[] args) {
		Integer[] array = {  3, 2, 8, 2,  3 };
		System.out.println(findKthElement(4, array));

	}

	public static String findKthElement(int k, Integer[] array) {
		String val = "";
		//Sort and get unique elements
		Set<Integer> arr = new HashSet<Integer>(Arrays.asList(array));
		if (k > arr.size()) {
			val = null;
		} else {
			Integer[] arrSort = new Integer[arr.size()];
			arr.toArray(arrSort);
			val = arrSort[k - 1].toString();
		}
		return val;
	}
}
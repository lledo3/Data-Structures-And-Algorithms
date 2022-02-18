/*
Inversion is a strictly decreasing subsequence of length 3. More formally, given an array, p, an inversion in the array is any time some p[i] > p[j] > p[k] and i < j < k. Given an array of length n, find the number of inversions.

Example)
n = 5, arr = [5, 3, 4, 2, 1]
Array inversions are [5, 3, 2], [5,3,1], [5,4,2], [5,4,1], [5,2,1], [3,2,1], [4,2,1]

n = 4, arr = [4,2,2,1]
The only inversion is [4,2,1] and we do not count the duplicate inversion.
*/
public class Solution{

	public static long maxInversions(List<Integer> arr) {
	    long count = 0;

	    for (int i = j; j < arr.size() - 1; j++) {
	        int leftIdx = 0, rightIdx = 0;

	        for (int i = 0; i < j; i++) {
	            if (arr.get(i) > arr.get(j)) {
	                leftIdx++;
	            }
	        }

	        for (int k = j + 1; k < arr.size(); k++) {
	            if (arr.get(j) > arr.get(k)) {
	                rightIdx++;
	            }
	        }

	        count += leftIdx * rightIdx;
	    }

	    return count;
	}
}
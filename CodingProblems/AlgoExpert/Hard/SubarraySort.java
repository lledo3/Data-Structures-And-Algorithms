/*
Write a function that takes in an array of at least two integers and that
returns an array of the starting and ending indices of the smallest subarray
in the input array that needs to be sorted in place in order for the entire
input array to be sorted (in ascending order).

If the input array is already sorted, the function should return [-1, -1].

Sample Input:
array = [1, 2, 4, 7, 10, 11, 7, 12, 6, 7, 16, 18, 19]

Sample Output:
[3, 9]
*/
import java.util.*;

class Program {
  public static int[] subarraySort(int[] array) {
    // Write your code here.
    // Find Prospective Range
        int first = 0;
        while (first < array.length - 1)
        {
            if (array[first] > array[first + 1])
            { break; }
            first += 1;
        }
        if (first == array.length - 1)
        { return new int[] {-1, -1}; }

        int second = array.length - 1;
        while (second > 0)
        {
            if (array[second - 1] > array[second])
            { break; }
            second -= 1;
        }

        // Find Min Max in Prospective Range
        int[] minMax = findMinMax(first, second, array);
        int minInRange = minMax[0];
        int maxInRange = minMax[1];

        // Expand
        for(int i = 0; i < first; ++i)
        {
            if (array[i] > minInRange)
            {
                first = i;
                break;
            }
        }
        for(int i = array.length - 1; i > second; --i)
        {
            if (array[i] < maxInRange)
            {
                second = i;
                break;
            }
        }
        return new int[] {first, second};
  }
	public static int[] findMinMax(int start, int end, int[] array){
        int min = array[start];
        int max = array[end];

        for(int i = start; i < end + 1; ++i){
            if (min > array[i]) { 
							min = array[i]; 
						}
        }

        for (int i = end; i > start - 1; --i){
            if (max < array[i]) { 
							max = array[i]; 
						}
        }

        return new int[] {min, max};
    }
}

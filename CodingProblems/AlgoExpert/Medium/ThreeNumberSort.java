/*
You're given an array of integers and another array of three distinct
integers. The first array is guaranteed to only contain integers that are in
the second array, and the second array represents a desired order for the
integers in the first array. For example, a second array of [x, y, z]
represents a desired order of [x, x, ..., x, y, y, ..., y, z, z, ..., z]
in the first array.

Write a function that sorts the first array according to the desired order in
the second array.

The function should perform this in place (i.e., it should mutate the input
array), and it shouldn't use any auxiliary space (i.e., it should run with
constant space: O(1) space).

Note that the desired order won't necessarily be ascending or descending and
that the first array won't necessarily contain all three integers found in the
second array—it might only contain one or two.

Sample Input:
array = [1, 0, 0, -1, -1, 0, 1, 1]
order = [0, 1, -1]

Sample Output:
[0, 0, 0, 1, 1, 1, -1, -1]
*/
import java.util.*;

class Program {
  public int[] threeNumberSort(int[] array, int[] order) {
    // Write your code here.
		int valOne = order[0];
		int valThree = order[2];
		
		int firstIdx = 0;
		for(int i = 0; i < array.length; i++){
			if(array[i] == valOne){
				swap(firstIdx, i, array);
				firstIdx += 1;
			}
		}
    int thirdIdx = array.length - 1;
		for(int i = array.length - 1; i >= 0; i--){
			if(array[i] == valThree){
				swap(thirdIdx, i, array);
				thirdIdx -= 1;
			}
		}
		return array;
  }
	
	public void swap(int i, int j, int[] array){
		int temp = array[j];
		array[j] = array[i];
		array[i] = temp;
	}
}

/*

  Given two non-empty arrays of integers, write a function that determines
  whether the second array is a subsequence of the first one.


  A subsequence of an array is a set of numbers that aren't necessarily adjacent
  in the array but that are in the same order as they appear in the array. For
  instance, the numbers [1, 3, 4]  form a subsequence of the array [1, 2, 3, 4]
  , and so do the numbers [2, 4]. 
  
  Note that a single number in an array and the array itself are both valid
  subsequences of the array.

  Example:
  array  = [5, 1, 22, 25, 6, -1, 8, 10]
  sequence =  = [1, 6, -1, 10]
  output: true
*/
import java.util.*;

class Program {
  public static boolean isValidSubsequence(List<Integer> array, List<Integer> sequence) {
    // Write your code here.
		int arrayPos = 0;
		int sequencePos = 0;
		while(arrayPos < array.size() && sequencePos < sequence.size()){
			if(array.get(arrayPos) == sequence.get(sequencePos)){
				sequencePos++;
			}
			arrayPos++;
		}
		if(sequencePos == sequence.size()){
			return true;
		}
    return false;
  }
}
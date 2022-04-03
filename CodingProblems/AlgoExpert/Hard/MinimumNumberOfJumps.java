/*
PROBLEM:
Given an array of integers maximum steps you can take at that point.
Find minimum jumps required to reach the last index.

EXAMPLE:
[3,4,2,1,2,3,7,1,1,1,3] -> 4
[3,4,2,1,2,3,7] -> 3

SOLUTIONS:
1. Track Steps Left before Jump -> time : O(n) | space : O(1)
*/
import java.util.*;

class Program {
  public static int minNumberOfJumps(int[] array) {
    // Write your code here.
    if (array.length < 2) { 
			return 0; 
		}

		int minJumps = 0;
		int stepsLeft = array[0];
		int maxReachable = array[0];

		for (int i = 1; i < array.length - 1; ++i){
			stepsLeft -= 1;
			maxReachable = Math.max(maxReachable, i + array[i]);
			if (stepsLeft == 0){
					stepsLeft = maxReachable - i;
					minJumps += 1;
			}
		}
		return minJumps + 1;
  }
}

/*
Write a function that takes in an array of integers and returns a new array
containing, at each index, the next element in the input array that's greater
than the element at that index in the input array.

Given a circular integer array nums (i.e., the next element of nums[nums.length - 1] is nums[0]), return the next greater 
number for every element in nums.
The next greater number of a number x is the first greater number to its traversing-order next in the array, which means you could 
search circularly to find its next greater number. If it doesn't exist, return -1 for this number.

Example 1:
Input: nums = [1,2,1]
Output: [2,-1,2]
Explanation: The first 1's next greater number is 2; 
The number 2 can't find next greater number. 
The second 1's next greater number needs to search circularly, which is also 2.

Example 2:
Input: nums = [1,2,3,4,3]
Output: [2,3,4,-1,4]
*/
import java.util.*;

class Program {

  public int[] nextGreaterElement(int[] nums) {
    // Write your code here.
    int n = nums.length;
	int[] result = new int[nums.length];
	Arrays.fill(result, -1);
	Stack<Integer> stack = new Stack();

	for(int i = 0; i < n * 2; i++){
		while(!stack.isEmpty() && nums[stack.peek()] < nums[i % n]){
			result[stack.pop()] = nums[i % n];
		}
		if(i < n) stack.push(i);
	}
	return result;
  }
}

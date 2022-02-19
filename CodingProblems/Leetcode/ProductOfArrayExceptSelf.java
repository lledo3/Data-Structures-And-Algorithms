/*
Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].

The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.

You must write an algorithm that runs in O(n) time and without using the division operation.

Example 1:

Input: nums = [1,2,3,4]
Output: [24,12,8,6]

Example 2:

Input: nums = [-1,1,0,-3,3]
Output: [0,0,9,0,0]
 
Constraints:

2 <= nums.length <= 10^5
-30 <= nums[i] <= 30
The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
*/
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int N = nums.length;
		int[] res = new int[N];
		int product = 1;
		res[0] = 1;
		
		for(int i = 1; i < N; i++){
			res[i] = nums[i - 1] * res[i - 1];
		}
		for(int i = N - 1; i >= 0; i--){
			res[i] = res[i] * product;
			product = product * nums[i];
		}
    return res;
    }
}
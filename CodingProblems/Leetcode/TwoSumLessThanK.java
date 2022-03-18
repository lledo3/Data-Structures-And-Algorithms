/*
Given an array nums of integers and integer k, return the maximum sum such that there exists i < j with nums[i] + nums[j] = sum and sum < k. 
If no i, j exist satisfying this equation, return -1.

Example 1:

Input: nums = [34,23,1,24,75,33,54,8], k = 60
Output: 58
Explanation: We can use 34 and 24 to sum 58 which is less than 60.

Example 2:

Input: nums = [10,20,30], k = 15
Output: -1
Explanation: In this case it is not possible to get a pair sum less that 15.
 

Constraints:

1 <= nums.length <= 100
1 <= nums[i] <= 1000
1 <= k <= 2000
*/
class Solution {
	//brute force TC:O(n^2)
    public int twoSumLessThanK(int[] nums, int k) {
        int maxSum = Integer.MIN_VALUE;
        for(int i = 0; i < nums.length; i++){
            for(int j = i + 1; j < nums.length; j++){
                int sum = nums[i] + nums[j];
                if(sum < k && sum > maxSum){
                    maxSum = sum;
                }
            }
        }
        return maxSum == Integer.MIN_VALUE ? -1 : maxSum;
    }
}

class Solution {
	//TC: O(nlogn)
    public int twoSumLessThanK(int[] nums, int k) {
        Arrays.sort(nums);
        int maxSum = Integer.MIN_VALUE;
        int left = 0;
        int right = nums.length - 1;
        
        while(left < right){
            int sum = nums[left] + nums[right];
            if(sum < k && sum > maxSum){
                maxSum = sum;
            }else if(sum >= k){
                right--;
            }else{
                left++;
            }
        }
        return maxSum == Integer.MIN_VALUE ? -1 : maxSum;
    }
}
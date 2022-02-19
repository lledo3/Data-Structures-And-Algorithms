/*
Given a non-empty array nums containing only positive integers, find if the array can be partitioned into 
two subsets such that the sum of elements in both subsets is equal.

Example 1:

Input: nums = [1,5,11,5]
Output: true
Explanation: The array can be partitioned as [1, 5, 5] and [11].

Example 2:

Input: nums = [1,2,3,5]
Output: false
Explanation: The array cannot be partitioned into equal sum subsets.
 

Constraints:

1 <= nums.length <= 200
1 <= nums[i] <= 100
*/
class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int i : nums){
            sum += i;
        }
        
        if(sum % 2 != 0) return false;
        
        sum = sum / 2;
        
        //DP approach
        boolean[] dp = new boolean[sum + 1];
        dp[0] = true;
        
        for(int i : nums){
            for(int j = sum; j >= i; j--){
                dp[j] = dp[j] | dp[j - i];
            }
        }
        return dp[sum];
    }
}
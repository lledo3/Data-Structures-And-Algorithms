/*
Given an integer array nums, return the length of the longest strictly increasing subsequence.

A subsequence is a sequence that can be derived from an array by deleting some or no elements 
without changing the order of the remaining elements. For example, [3,6,2,7] is a subsequence of the array [0,3,1,6,2,2,7].

Example 1:

Input: nums = [10,9,2,5,3,7,101,18]
Output: 4
Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.

Example 2:

Input: nums = [0,1,0,3,2,3]
Output: 4

Example 3:

Input: nums = [7,7,7,7,7,7,7]
Output: 1
 

Constraints:

1 <= nums.length <= 2500
-10^4 <= nums[i] <= 10^4
 

Follow up: Can you come up with an algorithm that runs in O(n log(n)) time complexity?
*/
class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        //cache[i] will store the length of Longest Increasing Subsequence, ending at nums[i].
        int[] cache = new int[n];

        //maxLIS : max length of Longest Increasing Subsequence. 
        int maxLIS = 0;
        for (int i = 0; i < n; i++) {
            int curMax = 0;

            //Checking it's previous values.
            for (int j = 0; j < i; j++) {
                
                //If any previous value of nums[i] is less than it, then only it can be appended(as we know
                //that the subsequence would have ended at nums[j]), so find the max length out of it.
                if (nums[j] < nums[i]) {
                    if (cache[j] > curMax) {
                        curMax = cache[j];
                    }
                }
            }

            //previous max length + new element nums[i], so store max + 1 in dp[i].
            cache[i] = curMax + 1;
            //Side by side keep on checking for the length of Longest Increasing Subsequence.
            if (maxLIS < cache[i]) {
                maxLIS = cache[i];
            }
        }

        return maxLIS;
    }
}
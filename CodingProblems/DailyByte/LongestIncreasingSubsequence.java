/*
Given an array of unsorted integers, return the length of its longest increasing subsequence.
Note: You may assume the array will only contain positive numbers.

Ex: Given the following array nums…

nums = [1, 9, 7, 4, 7, 13], return 4.
The longest increasing subsequence is 1, 4, 7, 13.
*/
public int longestIncreasingSubsequence(int[] nums) {
    int[] dp = new int[nums.length];
    Arrays.fill(dp, 1);

    for(int i = 1; i < dp.length; i++) {
        for(int j = 0; j < i; j++) {
            if(nums[i] > nums[j] && dp[i] < dp[j] + 1) {
                dp[i] = dp[j] + 1;
            }
        }
    }

    int longest = Integer.MIN_VALUE;
    for(int i: dp) {
        longest = Math.max(longest, i);
    }

    return longest;
}
/*
Big-O Analysis
Runtime: O(N2) where N is the number of elements in nums. This results from having our two nested for loops.
Space complexity: O(N) where N is the number of elements in nums. This results from storing N elements in our dp array.
*/
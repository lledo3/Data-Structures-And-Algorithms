/*
Given an integer array, return the sum of its contiguous subarray that produces the largest value.
Note: Your subarray must contain at least one value.

Ex: Given the following integer arrays…

nums = [-3,8,-8,2], return 8 (8)
nums = [2, 3,-4, 2], return 5 (2 + 3)
nums = [1, 5,-2, -3, 7], return 8 (1 + 5 + (-2) + (-3) + 7)
*/
//DP Approach
public int maxSubarray(int[] nums) {
    int[] dp = new int[nums.length];
    dp[0] = nums[0];
    int max = nums[0];
    for(int i = 1; i < nums.length; i++) {
        dp[i] += Math.max(dp[i - 1] + nums[i], nums[i]);
        max = Math.max(max, dp[i]);
    }

    return max;
}

//Kadane’s algorithm approach
public int maxSubArray(int[] nums) {
    int max = nums[0];
    for(int i = 1; i < nums.length; i++) {
        if (nums[i - 1] > 0) {
            nums[i] += nums[i - 1];
        }
        max = Math.max(nums[i], max);
    }

    return max;
}

/*
Big-O Analysis
Runtime: O(N) where N is the number of elements in nums.
Space complexity: O(1) or constant as the amount of space we need does not scale with our input nums.
*/
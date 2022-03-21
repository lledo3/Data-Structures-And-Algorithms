/*
You are given n balloons, indexed from 0 to n - 1. Each balloon is painted with a number on it represented by an array nums. 
You are asked to burst all the balloons.

If you burst the ith balloon, you will get nums[i - 1] * nums[i] * nums[i + 1] coins. If i - 1 or i + 1 goes out of bounds of the array, 
then treat it as if there is a balloon with a 1 painted on it.

Return the maximum coins you can collect by bursting the balloons wisely.

Example 1:

Input: nums = [3,1,5,8]
Output: 167
Explanation:
nums = [3,1,5,8] --> [3,5,8] --> [3,8] --> [8] --> []
coins =  3*1*5    +   3*5*8   +  1*3*8  + 1*8*1 = 167

Example 2:

Input: nums = [1,5]
Output: 10
 

Constraints:

n == nums.length
1 <= n <= 300
0 <= nums[i] <= 100
*/
class Solution {
    public int maxCoins(int[] nums) {
        // add 1 before and after nums
        int n = nums.length + 2;
        int[] newNums = new int[n];
        System.arraycopy(nums, 0, newNums, 1, n - 2);
        newNums[0] = 1;
        newNums[n - 1] = 1;
        // dp[i][j] represents
        // maximum if we burst all nums[left]...nums[right], inclusive
        int[][] dp = new int[n][n];
        // do not include the first one and the last one
        // since they are both fake balloons added by ourselves and we can not burst
        // them
        for (int left = n - 2; left >= 1; left--) {
            for (int right = left; right <= n - 2; right++) {
                // find the last burst one in newNums[left]...newNums[right]
                for (int i = left; i <= right; i++) {
                    // newNums[i] is the last burst one
                    int gain = newNums[left - 1] * newNums[i] * newNums[right + 1];
                    // recursively call left side and right side
                    int remaining = dp[left][i - 1] + dp[i + 1][right];
                    // update
                    dp[left][right] = Math.max(remaining + gain, dp[left][right]);
                }
            }
        }
        // burst newNums[1]...newNums[n-2], excluding the first one and the last one
        return dp[1][n - 2];
    }
}
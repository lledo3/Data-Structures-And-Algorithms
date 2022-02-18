/*
Two Sum III - O(n log n) + O(n)

Given an array of integers, return indices of the two numbers such that they add up to a specific target.

You may assume that each input will have at most one solution, and you may not use the same index twice.

In case no solution exists, return [-1, -1]

Example:

Input: nums = [2, 7, 11, 15], target = 9
Output: [0, 1]
Explanation: nums[0] + nums[1] = 2 + 7 = 9

Note:
Your algorithm should run in O(n log n) time and use O(n) extra space.
*/
class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[][] sortedNums = new int[nums.length][];
        for (int i = 0; i < nums.length; ++i) {
            sortedNums[i] = new int[]{nums[i], i};
        }
        Arrays.sort(sortedNums, (first, second) -> first[0] - second[0]);

        int first = 0, last = sortedNums.length - 1;
        while (first < last) {
            int sum = sortedNums[first][0] + sortedNums[last][0];
            if (sum == target) {
                return new int[]{sortedNums[first][1], sortedNums[last][1]};
            } else if (sum < target) {
                ++first;
            } else {
                --last;
            }
        }
        return new int[]{-1, -1};
    }
}
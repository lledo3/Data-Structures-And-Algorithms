/*
Remove Duplicates from Array II - O(n log n)

Given an array of integers, return a new array containing only the unique values.

The resulting array can be in any order.

Example:

Input: [2, 3, 1, 1, 4, 3, -2, 1]
Output: [2, 3, 1, 4, -2]
			

Note:
Your algorithm should run in O(n log n) time and use O(1) extra space.
*/
class Solution {

    public int[] removeDuplicates(int[] nums) {
        Arrays.sort(nums);
        int p = 0;
        for (int i = 1; i < nums.length; ++i) {
            if (nums[i] != nums[i - 1]) {
                nums[++p] = nums[i];
            }
        }
        return Arrays.copyOfRange(nums, 0, p + 1);
    }
}
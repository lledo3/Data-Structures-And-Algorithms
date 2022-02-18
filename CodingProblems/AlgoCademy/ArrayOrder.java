/*
Array Order - O(n)

Given an array nums with n integers, rearange and return the array in the following order:
nums[0], nums[n - 1], nums[1], nums[n - 2], ...

Example:

Input: nums = [2, 9, 1, 5, 8]
Output: [2, 8, 9, 5, 1]

Note:
Your algorithm should run in O(n) time and use O(n) extra space.
*/
class Solution {
    public int[] reorder(int[] nums) {
        int[] result = new int[nums.length];
        int i = 0, j = nums.length - 1, k = 0;
        
        while (i < j) {
            result[k++] = nums[i];
            result[k++] = nums[j];
            i++;
            j--;
        }
        
        if (i == j) {
            result[k++] = nums[i];
        }
        return result;
    }
}
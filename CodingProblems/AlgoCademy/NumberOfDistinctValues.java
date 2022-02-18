/*
Number of Distinct Values - O(n log n)

Given an array of integers, count how many distinct values exist in the array.

Example:

Input: [1, 5, -3, 1, -4, 2, -4, 7, 7]
Output: 6
Explanation: the distinct values in the array are [1, 5, -3, -4, 2, 7]

Note:
For this lesson, your algorithm should run in O(n log n) time and use O(1) extra space.
(There are faster solutions which we will discuss in future lessons)
*/
class Solution {
    public int distinctValues(int[] nums) {
        int result = 1;
        Arrays.sort(nums);
        for(int i = 1; i < nums.length; i++){
            if(nums[i] != nums[i - 1]){
                result += 1;
            }
        }
        return result;
    }
}
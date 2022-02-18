/*
Smallest K Integers - O(n log n)

Given an array of positive integers nums, return the smallest k values, in any order you want.

Example:

Input: nums = [5, 9, 3, 6, 2, 1, 3, 2, 7, 5], k = 4
Output: [1, 2, 2, 3]
Explanation: Smallest number is 1, 2nd smallest is 2, 
            3rd smallest is 2, 4th smallest is 3

The result can be in any order, [2, 1, 3, 2] is also a correct answer.

Note:
For this lesson, your algorithm should run in O(n log n) time and use O(1) extra space.
(There are faster solutions which we will discuss in future lessons)
*/
class Solution {
    public int[] kSmallest(int[] nums, int k) {
        Arrays.sort(nums);
        return Arrays.copyOfRange(nums, 0, k);
    }
}
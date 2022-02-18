/*
Sorting: Selection Sort - O(n2)

Selection Sort:

Problem - Selection Sort:

Given an array of integers nums, sort it in ascending order using Selection Sort

Example 1:

Input: nums = [3, 1, 3, 2, 5, 4]
Output: [1, 2, 3, 3, 4, 5]

Note:
Your algorithm should run in O(n^2) time and use O(1) extra space.
*/
class Solution {
    void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    public void selectionSort(int[] nums) {
        for(int i = 0; i < nums.length; i++){
            for(int j = i + 1; j < nums.length; j++){
                if(nums[i] > nums[j]){
                    swap(nums, i, j);
                }
            }
        }
    }
}

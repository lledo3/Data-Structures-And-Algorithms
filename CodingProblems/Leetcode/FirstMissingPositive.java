/*
Given an unsorted integer array nums, return the smallest missing positive integer.

You must implement an algorithm that runs in O(n) time and uses constant extra space.

Example 1:

Input: nums = [1,2,0]
Output: 3

Example 2:

Input: nums = [3,4,-1,1]
Output: 2

Example 3:

Input: nums = [7,8,9,11,12]
Output: 1
 

Constraints:

1 <= nums.length <= 5 * 10^5
-23^1 <= nums[i] <= 23^1 - 1
*/
class Solution {
    public int firstMissingPositive(int[] nums) {
        if(nums == null || nums.length == 0) return 1;
        int len = nums.length;
        
        for(int i = 0; i < len;){
            if(nums[i] > len || nums[i] <= 0){//checking for only positive numbers
                i++;
            }else if(nums[nums[i] - 1] == nums[i]){//checking element position is correct
                i++;
            }else{//swap element to correct position
                int temp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = temp;
            }
        }
        int idx = 0;//find smallest positive element from position
        for(idx = 0; idx < len; idx++){
            if(nums[idx] != idx + 1) return idx + 1;
        }
        return nums[idx - 1] + 1;
    }
}
/*
Given an array nums, return whether or not its values are monotonically increasing or monotonically decreasing.
Note: An array is monotonically increasing if for all values i <= j, nums[i] <= nums[j]. Similarly an array is 
monotonically decreasing if for all values i <= j, nums[i] >= nums[j].

Ex: Given the following array nums…

nums = [1, 2, 3, 4, 4, 5], return true.
Ex: Given the following array nums…

nums = [7, 6, 3], return true.
Ex: Given the following array nums…

nums = [8, 4, 6], return false.
*/
public boolean isMonotonic(int[] nums) {
    boolean increasing = true;
    boolean decreasing = true;
    for(int i = 0; i < nums.length - 1; i++) {
        if(nums[i] > nums[i + 1]) {
            increasing = false;
        }
        if(nums[i] < nums[i + 1]) {
            decreasing = false;
        }
    }

    return increasing || decreasing;
}
/*
Big-O Analysis
Runtime: O(N) where N is the total number of elements in nums.
Space complexity: O(1) or constant.
*/
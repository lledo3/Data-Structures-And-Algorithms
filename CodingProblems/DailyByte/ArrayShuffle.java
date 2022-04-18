/*
Given an array of integers, nums, sort the array in any manner such that when i is even, nums[i] is even and when i is odd, nums[i] is odd.
Note: It is guaranteed that a valid sorting of nums exists.

Ex: Given the following array nums…

nums = [1, 2, 3, 4], one possible way to sort the array is [2,1,4,3]
*/
public int[] rearrangeElements(int[] nums) {
    int[] sorted = new int[nums.length];
    int evenIndex = 0;
    int oddIndex = 1;
    for(int i = 0; i < nums.length; i++) {
        if(nums[i] % 2 == 0) {
            sorted[evenIndex] = nums[i];
            evenIndex += 2;
        } else if (nums[i] % 2 == 1) {
            sorted[oddIndex] = nums[i];
            oddIndex += 2;
        }
    }

    return sorted;
}
/*
Big-O Analysis
Runtime: O(N) where N is the total number of elements in nums.
Space complexity: O(N) where N is the total number of elements in nums. 
This results from creating our new array which will contain all N elements sorted.
*/
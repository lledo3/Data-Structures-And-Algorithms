/*
Given an array of numbers, move all zeroes in the array to the end while maintaining the relative order of the other numbers.
Note: You must modify the array you’re given (i.e. you cannot create a new array).

Ex: Given the following array nums…

nums = [3, 7, 0, 5, 0, 2], rearrange nums to look like the following [3,7,5,2,0,0]
*/
public void rearrangeElements(int[] nums) {
    int index = 0;
    for(int i = 0; i < nums.length; i++) {
        if(nums[i] != 0) {
            nums[index++] = nums[i];
        }
    }

    for(int i = index; i < nums.length; i++) {
        nums[i] = 0;
    }
}
/*
Big-O Analysis
Runtime: O(N) where N is the total number of elements in nums.
Space complexity: O(1) or constant.
*/
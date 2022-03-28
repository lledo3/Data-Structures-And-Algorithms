/*
Given an array that contains all distinct values from zero through N except one number, return the number that is missing from the array.

Ex: Given the following array nums…

nums = [1, 4, 2, 0], return 3.
3 is the only number missing in the array between 0 and 4.
Ex: Given the following array nums…

nums = [6, 3, 1, 2, 0, 5], return 4.
4 is the only number missing in the array between 0 and 6.
*/
public int missingNumber(int[] nums) {
    int sum = 0;
    for(int i: nums) {
        sum += i;
    }

    int n = nums.length;
    return (n * (n + 1) / 2) - sum;
}
/*
Big-O Analysis
Runtime: O(N) where N is the total number of elements in nums. This results from having to iterate through all numbers in nums in 
order to determine our actual sum.
Space complexity: O(1) or constant.
*/
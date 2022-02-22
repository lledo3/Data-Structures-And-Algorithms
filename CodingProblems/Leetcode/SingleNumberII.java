/*
Given an integer array nums where every element appears three times except for one, which appears exactly once. 
Find the single element and return it.

You must implement a solution with a linear runtime complexity and use only constant extra space.

Example 1:

Input: nums = [2,2,3,2]
Output: 3

Example 2:

Input: nums = [0,1,0,1,0,1,99]
Output: 99
 

Constraints:

1 <= nums.length <= 3 * 104
-231 <= nums[i] <= 231 - 1
Each element in nums appears exactly three times except for one element which appears once.
*/
class Solution {
    public int singleNumber(int[] nums) {
    	//TC:O(n) SP: O(n)
        if(nums.length == 0) return -1;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i : nums){
            //short hand getOrDefault - either add 1 or put one
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        for(int key : map.keySet()){
            if(map.get(key) == 1){
                return key;
            }
        }
        return -1;
    }

    public int singleNumber(int[] nums){
    	//TC: O(n) SP: O(1)
    	int ones = 0, twos = 0;
    	int bitMastPattern;
    	for(int i = 0; i < nums.length; i++){
    		twos = twos | (ones & nums[i]);
    		ones = ones ^ nums[i];
    		bitMastPattern = ~(ones & twos);
    		ones &= bitMastPattern;
    		twos &= bitMastPattern;
    	}
    	return ones;
    }
}
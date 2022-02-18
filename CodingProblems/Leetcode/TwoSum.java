/*
Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target. You may assume that each input would have exactly one solution, and you may not use the same element twice.
You can return the answer in any order.

Constraints:

2 <= nums.length <= 104
-109 <= nums[i] <= 109
-109 <= target <= 109
Only one valid answer exists.
 
Follow-up: Can you come up with an algorithm that is less than O(n2) time complexity?

Example 1:

Input: nums = [2,7,11,15], target = 9
Output: [0,1]
Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
*/

class Solution {
    //returns actual number
    public int[] twoSumNumber(int[] nums, int targetSum) {
        int[] result = new int[2];
        HashMap<Integer,Boolean> numbers = new HashMap<>();
        for(Integer i : nums){
            if(numbers.containsKey(targetSum - i)){
                result[0] = targetSum - i;
                result[1] = i;
                return result;
            }else{
                numbers.put(i, true);
            }
        }
        return new int[0];
    }
    //returns the indices
    public int[] twoSumIndice(int[] nums, int target) {
        int[] result = new int[2];
        HashMap<Integer,Integer> numbers = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            int diff = target - nums[i];
            if(numbers.containsKey(diff)){
                result[0] = numbers.get(diff);
                result[1] = i;
                return result;
            }else{
                numbers.put(nums[i], i);
            }
        }
        return new int[0];
    }
}
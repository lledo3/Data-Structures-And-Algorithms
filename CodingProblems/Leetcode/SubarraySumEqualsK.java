/*
Given an array of integers nums and an integer k, return the total number of subarrays whose sum equals to k.

Example 1:

Input: nums = [1,1,1], k = 2
Output: 2

Example 2:

Input: nums = [1,2,3], k = 3
Output: 2
 

Constraints:

1 <= nums.length <= 2 * 10^4
-1000 <= nums[i] <= 1000
-10^7 <= k <= 10^7
*/
class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> numbers = new HashMap<>();
        numbers.put(0, 1);
        int sum = 0;
        int res = 0;
        
        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
            
            if(numbers.containsKey(sum - k)){
                res += numbers.get(sum - k);
            }
            numbers.put(sum, numbers.getOrDefault(sum, 0) + 1);
        }
        
        return res;
    }
}
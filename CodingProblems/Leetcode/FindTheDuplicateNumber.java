/*
Given an array of integers nums containing n + 1 integers where each integer is in the range [1, n] inclusive.

There is only one repeated number in nums, return this repeated number.

You must solve the problem without modifying the array nums and uses only constant extra space.

Example 1:

Input: nums = [1,3,4,2,2]
Output: 2

Example 2:

Input: nums = [3,1,3,4,2]
Output: 3
 
Constraints:

1 <= n <= 10^5
nums.length == n + 1
1 <= nums[i] <= n
All the integers in nums appear only once except for precisely one integer which appears two or more times.
 

Follow up:

How can we prove that at least one duplicate number must exist in nums?
Can you solve the problem in linear runtime complexity?
*/
class Solution {
	//TC: O(n) SC:O(n)
    public int findDuplicate(int[] nums) {
        HashSet<Integer> hash=new HashSet();
        for(int i=0;i<nums.length;i++){
            if(hash.contains(nums[i])) return nums[i];
            else hash.add(nums[i]);
        }
        return -1;
    }

    //TC: O(n) SC: O(n)
    public int findDuplicate(int[] nums) {
        int res = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for(int num : nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for(int num : map.keySet()){
            if(map.get(num) > 1){
                res = num;
            }
        }
        return res;
    }
}
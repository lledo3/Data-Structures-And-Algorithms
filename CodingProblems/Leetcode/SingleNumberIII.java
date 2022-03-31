/*
Given an integer array nums, in which exactly two elements appear only once and all the other elements appear exactly twice. 
Find the two elements that appear only once. You can return the answer in any order.

You must write an algorithm that runs in linear runtime complexity and uses only constant extra space.

Example 1:

Input: nums = [1,2,1,3,2,5]
Output: [3,5]
Explanation:  [5, 3] is also a valid answer.

Example 2:

Input: nums = [-1,0]
Output: [-1,0]

Example 3:

Input: nums = [0,1]
Output: [1,0]
 

Constraints:

2 <= nums.length <= 3 * 10^4
-2^31 <= nums[i] <= 2^31 - 1
Each integer in nums will appear twice, only two integers will appear once.
*/
class Solution {
    public int[] singleNumber(int[] nums) {
        Set<Integer> st = new HashSet<>();
        for(int i : nums){
            if(!st.add(i)){
                st.remove(i);
            }
        }
        int[] res = new int[2];
        int k = 0;
        for(int i : st){
            res[k++] = i;
        }
        return res;
    }
}

class Solution {
    public int[] singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i : nums){
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        int[] res = new int[2];
        int k = 0;
        for(Map.Entry<Integer, Integer> i : map.entrySet()){
            if(i.getValue() == 1){
                res[k++] = i.getKey();
            }
        }
        return res;
    }
}
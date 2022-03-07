/*
Given a list of non-negative integers nums, arrange them such that they form the largest number and return it.

Since the result may be very large, so you need to return a string instead of an integer.

Example 1:

Input: nums = [10,2]
Output: "210"

Example 2:

Input: nums = [3,30,34,5,9]
Output: "9534330"
 

Constraints:

1 <= nums.length <= 100
0 <= nums[i] <= 10^9
*/
class Solution {
    public String largestNumber(int[] nums) {
       if(nums == null || nums.length == 0) return "";
        String[] strs = new String[nums.length];
        for(int i = 0; i < nums.length; i++){
            strs[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(strs, (str1, str2) -> (str2 + str1).compareTo(str1 + str2));
        if(strs[0].charAt(0) == '0') return "0";
        StringBuilder sb = new StringBuilder();
        for(String s : strs){
            sb.append(s);
        }
        return sb.toString();
    }
}
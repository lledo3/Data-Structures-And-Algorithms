/*
Given a binary array nums, return the maximum length of a contiguous subarray with an equal number of 0 and 1.

Example 1:

Input: nums = [0,1]
Output: 2
Explanation: [0, 1] is the longest contiguous subarray with an equal number of 0 and 1.

Example 2:

Input: nums = [0,1,0]
Output: 2
Explanation: [0, 1] (or [1, 0]) is a longest contiguous subarray with equal number of 0 and 1.
 

Constraints:

1 <= nums.length <= 10^5
nums[i] is either 0 or 1.
*/
class Solution {
	//optimal solution
    public int findMaxLength(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0, -1); //because we haven't seen anything yet
        int maxLen = 0;
        int count = 0;
        
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == 0){
                count += -1;
            }else{
                count += 1;
            }
            if(map.containsKey(count)){
                maxLen = Math.max(maxLen, i - map.get(count));
            }else{
                map.put(count, i);
            }
        }
        return maxLen;
    }
}

public class Solution {
	//brute force
    public int findMaxLength(int[] nums) {
        int maxlen = 0;
        for (int start = 0; start < nums.length; start++) {
            int zeroes = 0, ones = 0;
            for (int end = start; end < nums.length; end++) {
                if (nums[end] == 0) {
                    zeroes++;
                } else {
                    ones++;
                }
                if (zeroes == ones) {
                    maxlen = Math.max(maxlen, end - start + 1);
                }
            }
        }
        return maxlen;
    }
}
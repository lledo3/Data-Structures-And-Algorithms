/*
Given a binary array nums and an integer k, return the maximum number of consecutive 1's in the array if you can flip at most k 0's.

Example 1:

Input: nums = [1,1,1,0,0,0,1,1,1,1,0], k = 2
Output: 6
Explanation: [1,1,1,0,0,1,1,1,1,1,1]
Bolded numbers were flipped from 0 to 1. The longest subarray is underlined.

Example 2:

Input: nums = [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1], k = 3
Output: 10
Explanation: [0,0,1,1,1,1,1,1,1,1,1,1,0,0,0,1,1,1,1]
Bolded numbers were flipped from 0 to 1. The longest subarray is underlined.
 

Constraints:

1 <= nums.length <= 10^5
nums[i] is either 0 or 1.
0 <= k <= nums.length
*/
class Solution {
    public int longestOnes(int[] nums, int k) {
        //base case
        if(nums.length < 2 && 0 < k) return nums.length;
        //pointer and max
        int L = 0, R = 0;
        int max = 0;
        int count = 0;
        
        //find consecutive ones: sliding window
        
        while(R < nums.length){
            //expand the window
            //increase count if currElement == 0
            if(nums[R] == 0){
                count += 1;
            }
            //contract window if condition doesn't meet
            while(k < count){
                if(nums[L] == 0){
                    count -= 1;
                }
                L++;
            }
            //update max
            max = Math.max(max, R - L + 1);
            //move R one the right
            R++;
        }
        //return max
        return max;
    }
}
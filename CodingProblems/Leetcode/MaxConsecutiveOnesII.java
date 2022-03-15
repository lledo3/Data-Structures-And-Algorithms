/*
Given a binary array nums, return the maximum number of consecutive 1's in the array 
if you can flip at most one 0.

Example 1:

Input: nums = [1,0,1,1,0]
Output: 4
Explanation: Flip the first zero will get the maximum number of consecutive 1s. After flipping, the maximum number of consecutive 1s is 4.

Example 2:

Input: nums = [1,0,1,1,0,1]
Output: 4
 

Constraints:

1 <= nums.length <= 10^5
nums[i] is either 0 or 1.
 

Follow up: What if the input numbers come in one by one as an infinite stream? In other words, you can't store all numbers coming from 
the stream as it's too large to hold in memory. Could you solve it efficiently?
*/
class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        //base case
        if(nums.length < 2) return 1;
        
        //pointers and max and count
        int L = 0, R = 0;
        int max = Integer.MIN_VALUE;
        int count = 0;
        
        //find max consecutive ones
        while(R < nums.length){
            if(nums[R] == 0){
                count += 1;
            }
            //contract window if we don't meet the condition
            while(count > 1){
                if(nums[L] == 0){
                    count -= 1;
                }
                L++;
            }
            //update max length
            max = Math.max(max, R - L + 1);
            
            //move the R one to the right
            R++;
        }
        return max;
    }
}
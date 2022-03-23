/*
Given an integer array nums of size n, return the minimum number of moves required to make all array elements equal.

In one move, you can increment n - 1 elements of the array by 1.

Example 1:

Input: nums = [1,2,3]
Output: 3
Explanation: Only three moves are needed (remember each move increments two elements):
[1,2,3]  =>  [2,3,3]  =>  [3,4,3]  =>  [4,4,4]

Example 2:

Input: nums = [1,1,1]
Output: 0

Constraints:

n == nums.length
1 <= nums.length <= 10^5
-10^9 <= nums[i] <= 10^9
The answer is guaranteed to fit in a 32-bit integer.
*/
class Solution {
    public int minMoves(int[] nums) {
        int i = 0;
        int min = nums[0];
        int result = 0;
        
        for(i = 0; i < nums.length; i++){
            if(nums[i] < min){
                min = nums[i];
            }
        }
        
        for(i = 0; i < nums.length; i++){
            result = result + nums[i] - min;
        }
    
        return result;
    }
}
/*
Given an array of integers nums and an integer k. A continuous subarray is called nice if there are k odd numbers on it.

Return the number of nice sub-arrays.

Example 1:

Input: nums = [1,1,2,1,1], k = 3
Output: 2
Explanation: The only sub-arrays with 3 odd numbers are [1,1,2,1] and [1,2,1,1].

Example 2:

Input: nums = [2,4,6], k = 1
Output: 0
Explanation: There is no odd numbers in the array.

Example 3:

Input: nums = [2,2,2,1,2,2,1,2,2,2], k = 2
Output: 16
 

Constraints:

1 <= nums.length <= 50000
1 <= nums[i] <= 10^5
1 <= k <= nums.length
*/
class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        int start = 0, end = 0, len = nums.length;
        int count = 0, oddCount = 0, evenCount = 0;
        
        while(end < len){
            
            while(end < len && oddCount < k){
                if(nums[end++] % 2 != 0)  ++oddCount;
            }
            
           evenCount = 1;
           while(end < len && nums[end] % 2 == 0){
                ++evenCount;
                ++end;
           }
           
           while(start < len && oddCount == k){
                count += evenCount;
                if(nums[start++] % 2 != 0) --oddCount;
           }
        }
        
        return count;
    }
}
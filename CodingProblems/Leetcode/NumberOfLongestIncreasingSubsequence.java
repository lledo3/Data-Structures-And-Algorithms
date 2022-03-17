/*
Given an integer array nums, return the number of longest increasing subsequences.

Notice that the sequence has to be strictly increasing.

Example 1:

Input: nums = [1,3,5,4,7]
Output: 2
Explanation: The two longest increasing subsequences are [1, 3, 4, 7] and [1, 3, 5, 7].

Example 2:

Input: nums = [2,2,2,2,2]
Output: 5
Explanation: The length of longest continuous increasing subsequence is 1, and there are 5 subsequences' length is 1, so output 5.

 

Constraints:

1 <= nums.length <= 2000
-10^6 <= nums[i] <= 10^6
*/
class Solution {
    public int findNumberOfLIS(int[] nums) {
        if(nums.length == 0) return 0;
        
        int n = nums.length;
        int[] length = new int[n];
        int[] count = new int[n];
        
        Arrays.fill(length, 1);
        Arrays.fill(count, 1);
        
        int maxLen = 1;
        
        for(int i = 1; i < n; i++){
            for(int j = 0; j < i; j++){
                if(nums[i] > nums[j]){
                    if(length[j] + 1 > length[i]){
                        length[i] = length[j] + 1;
                        count[i] = count[j];
                    }else if(length[j] + 1 == length[i]){
                        count[i] += count[j];
                    }
                }
            }
            maxLen = Math.max(maxLen, length[i]);
        }
        int result = 0;
        
        for(int i = 0; i < n; i++){
            if(length[i] == maxLen){
                result += count[i];
            }
        }
        return result;
    }
}
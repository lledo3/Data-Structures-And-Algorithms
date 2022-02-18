/*
Given an integer array nums of length n and an integer target, find three integers in nums such that the sum is closest to target.
Return the sum of the three integers.
You may assume that each input would have exactly one solution.

Example 1:

Input: nums = [-1,2,1,-4], target = 1
Output: 2
Explanation: The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).

Example 2:

Input: nums = [0,0,0], target = 1
Output: 0
 
Constraints:

3 <= nums.length <= 1000
-1000 <= nums[i] <= 1000
-104 <= target <= 104
*/
class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int size = nums.length;
        //base case
        if(size < 3){
            return 0;
        }
        //sort
        Arrays.sort(nums);
        
        //section, ans
        int gap = Integer.MAX_VALUE;
        int ans = 0;
        
        
        //iterate
        for(int i = 0; i < size; i++){
            int left = i + 1;
            int right = size - 1;
            
            while(left < right){
                int sum = nums[i] + nums[left] + nums[right];
                if(sum == target){
                    return target;
                }else if(sum < target){
                    left++;
                }else{
                    right--;
                }
                int curGap = Math.abs(sum - target);
                if(curGap < gap){
                    gap = curGap;
                    ans = sum;
                }
            }
        }  
        //return the sum that has the smallest gap between target and sum
        return ans;
    }
}
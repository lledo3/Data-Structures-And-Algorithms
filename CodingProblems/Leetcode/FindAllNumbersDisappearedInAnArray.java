/*
Given an array nums of n integers where nums[i] is in the range [1, n], return an array of all the integers in the range [1, n] 
that do not appear in nums.

Example 1:

Input: nums = [4,3,2,7,8,2,3,1]
Output: [5,6]

Example 2:

Input: nums = [1,1]
Output: [2]
 

Constraints:

n == nums.length
1 <= n <= 10^5
1 <= nums[i] <= n
 

Follow up: Could you do it without extra space and in O(n) runtime? You may assume the returned list does not count as extra space.
*/
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> res = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        
        for(int i : nums){
            set.add(i);
        }
        
        for(int i = 1; i <= nums.length; i++){
            if(!set.contains(i)){
                res.add(i);
            }
        }
        
        return res;
    }
}

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        for(int i = 0; i < nums.length; i++){
            int idx = nums[i]-1;
            // swap until the nums[i] is at index nums[i]-1
            while(idx != nums[i]){
                swap(nums, idx, i);
                idx = nums[i] - 1;
                // if we are going to swap same number: break
                if(nums[idx] == nums[i]){
                    break;
                }
            }
        }
        // In this point, the array looks like this: [1,2,3,4,3,2,7,8]
        List<Integer> res = new ArrayList<>();
        for(int i = 0; i < nums.length; i++){
            if(i != nums[i]-1){
                res.add(i+1);
            }
        }
        
        return res;
    }
    
    private void swap(int[] nums, int idx1, int idx2){
        int temp = nums[idx1];
        nums[idx1] = nums[idx2];
        nums[idx2] = temp;
    }
}
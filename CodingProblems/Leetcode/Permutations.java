/*
Given an array nums of distinct integers, return all the possible permutations. You can return the answer in any order.

Example 1:

Input: nums = [1,2,3]
Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]

Example 2:

Input: nums = [0,1]
Output: [[0,1],[1,0]]

Example 3:

Input: nums = [1]
Output: [[1]]

Constraints:

1 <= nums.length <= 6
-10 <= nums[i] <= 10
All the integers of nums are unique.
*/
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backTrackPermu1(res, nums, 0);
        return res;
    }
    public void backTrackPermu1(List<List<Integer>> res, int[] nums, int start){
        List<Integer> list = new ArrayList<>();
        if(start == nums.length){
            for(int num : nums){
                list.add(num);
            }
            res.add(list);
        }else{
            for(int i = start; i < nums.length; i++){
                permSwap(i, start, nums);
                backTrackPermu1(res, nums, start + 1);
                permSwap(i, start, nums);
            }
        }
    }
    public void permSwap(int i, int j, int[] nums){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
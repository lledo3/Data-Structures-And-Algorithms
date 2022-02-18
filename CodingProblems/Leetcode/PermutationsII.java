/*
Given a collection of numbers, nums, that might contain duplicates, return all possible unique permutations in any order.

Example 1:

Input: nums = [1,1,2]
Output:
[[1,1,2],
 [1,2,1],
 [2,1,1]]

Example 2:

Input: nums = [1,2,3]
Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]

Constraints:

1 <= nums.length <= 8
-10 <= nums[i] <= 10
*/
class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backTrackPermu2(res, nums, 0);
        return res;
    }
    public void backTrackPermu2(List<List<Integer>> res, int[] nums, int start){
        List<Integer> list = new ArrayList<>();
        if(start == nums.length){
            for(int num : nums){
                list.add(num);
            }
            res.add(list);
        }else{
            for(int i = start; i < nums.length; i++){
                if(i != start && !permutate(start, i, nums)) continue;
                permSwap2(i, start, nums);
                backTrackPermu2(res, nums, start + 1);
                permSwap2(i, start, nums);
            }
        }
    }
    public void permSwap2(int i, int j, int[] nums){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    public boolean permutate(int start, int cur,int[] nums){
        for(int i = start; i < cur; i++){
            if(nums[i] == nums[cur]){
                return false;
            }
        }
        return true;
    }
}
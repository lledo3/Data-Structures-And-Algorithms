/*
Given an integer array nums that may contain duplicates, return all possible subsets (the power set).

The solution set must not contain duplicate subsets. Return the solution in any order.

 

Example 1:

Input: nums = [1,2,2]
Output: [[],[1],[1,2],[1,2,2],[2],[2,2]]
Example 2:

Input: nums = [0]
Output: [[],[0]]
 

Constraints:

1 <= nums.length <= 10
-10 <= nums[i] <= 10
*/
class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
       List<List<Integer>> res = new ArrayList<>();
        
        Arrays.sort(nums);
        
        backTrackSubsetWithDups(0, nums, new ArrayList<Integer>(), res);
        
        return res; 
    }
    
    public void backTrackSubsetWithDups(int start, int[] nums, List<Integer> curSubSet, List<List<Integer>> res){
        //add a copy curSubSet to res
        res.add(new ArrayList<>(curSubSet));
        
        for(int i = start; i < nums.length; i++){
            //check for outbound and check for duplicate
            if(i != start && nums[i] == nums[i - 1]) continue;
            //add to number to curSubSet
            curSubSet.add(nums[i]);
            //call backtrack
            backTrackSubsetWithDups(i + 1, nums, curSubSet, res);
            //remove last addition from curSubSet
            curSubSet.remove(curSubSet.size() - 1);
        }
    }
}
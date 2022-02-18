/*
Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sum to target.
Each number in candidates may only be used once in the combination.
Note: The solution set must not contain duplicate combinations.

Example 1:

Input: candidates = [10,1,2,7,6,1,5], target = 8
Output: 
[
[1,1,6],
[1,2,5],
[1,7],
[2,6]
]

Example 2:

Input: candidates = [2,5,2,1,2], target = 5
Output: 
[
[1,2,2],
[5]
]

Constraints:

1 <= candidates.length <= 100
1 <= candidates[i] <= 50
1 <= target <= 30
*/
class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        findCombo2(0, candidates, target, new ArrayList<>(), res);
        return res;
    }
    public void findCombo2(int idx, int[] candidates, int target, List<Integer> combo, List<List<Integer>> res){
        if(target == 0){
            res.add(new ArrayList(combo));
            return;
        }
        for(int j = idx; j < candidates.length; j++){
            if(candidates[j] > target ||(idx != j && candidates[j] == candidates[j - 1])) continue;
            
                combo.add(candidates[j]);
                findCombo2(j + 1, candidates, target - candidates[j], combo, res);
                combo.remove(combo.size() - 1);
        }
    }
}
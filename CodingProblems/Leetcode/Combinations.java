/*
Given two integers n and k, return all possible combinations of k numbers out of the range [1, n].

You may return the answer in any order.

Example 1:

Input: n = 4, k = 2
Output:
[
  [2,4],
  [3,4],
  [2,3],
  [1,2],
  [1,3],
  [1,4],
]

Example 2:

Input: n = 1, k = 1
Output: [[1]]
 

Constraints:

1 <= n <= 20
1 <= k <= n
*/
class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new LinkedList();
        if(k == 0){
            res.add(new LinkedList());
            return res;
        }
        backTrackCombine(1, new LinkedList(), n, k, res);
        return res;
    }
    
    public void backTrackCombine(int start,LinkedList<Integer> combo, int n, int k, List<List<Integer>> res){
        //base case - combo is the size of k
        if(combo.size() == k){
            res.add(new LinkedList(combo));
        }
        
        for(int i = start; i <= n && combo.size() < k; i++){
            combo.add(i);
            backTrackCombine(i + 1, combo, n, k, res);
            combo.removeLast();
        }
    }
}
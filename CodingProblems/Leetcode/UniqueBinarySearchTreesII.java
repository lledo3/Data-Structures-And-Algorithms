/*
Given an integer n, return all the structurally unique BST's (binary search trees), which has exactly n nodes of unique values from 1 to n. 
Return the answer in any order.

Example 1:

Input: n = 3
Output: [[1,null,2,null,3],[1,null,3,2],[2,1,3],[3,1,null,null,2],[3,2,null,1]]

Example 2:

Input: n = 1
Output: [[1]]
 

Constraints:

1 <= n <= 8
*/
//Definition for a binary tree node.
  public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }

  class Solution {
    public List<TreeNode> generateTrees(int n) {
        if(n == 0){
            return new ArrayList<TreeNode>();
        }
        return solveUniqueBst2(1, n);
    }
    
    public List<TreeNode> solveUniqueBst2(int start, int end){
        List<TreeNode> res = new ArrayList<>();
        if(start > end){
            res.add(null);
            return res;
        }
        
        for(int i = start; i <= end; i++){
            List<TreeNode> leftSide = solveUniqueBst2(start, i - 1);
            List<TreeNode> rightSide = solveUniqueBst2(i + 1, end);
            
            for(TreeNode l : leftSide){
                for(TreeNode r : rightSide){
                    TreeNode curr = new TreeNode(i);
                    curr.left = l;
                    curr.right = r;
                    res.add(curr);
                }
            }
        }
        return res;
    }
}
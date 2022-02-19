/*
Given a binary tree, determine if it is height-balanced.

For this problem, a height-balanced binary tree is defined as:

a binary tree in which the left and right subtrees of every node differ in height by no more than 1.

Example 1:

Input: root = [3,9,20,null,null,15,7]
Output: true

Example 2:

Input: root = [1,2,2,3,3,null,null,4,4]
Output: false

Example 3:

Input: root = []
Output: true
 

Constraints:

The number of nodes in the tree is in the range [0, 5000].
-10^4 <= Node.val <= 10^4
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
    public boolean isBalanced(TreeNode root) {
        //bottom up approach
        //TC: O(n)
        if(root == null) return true;
        return heightBottomUpApproach(root) != -1;
    }
    
    public int heightBottomUpApproach(TreeNode node){
        if(node == null) return 0;
        int left = heightBottomUpApproach(node.left);
        int right = heightBottomUpApproach(node.right);
        
        int balanceFactor = Math.abs(left - right);
        if(balanceFactor > 1 || left == -1 || right == -1) return -1;
        return 1 + Math.max(left, right);
    }
}
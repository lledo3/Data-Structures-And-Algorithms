/*
Given the root of a binary tree, return the leftmost value in the last row of the tree.

Example 1:

		2
	  /   \
	 1     3

Input: root = [2,1,3]
Output: 1

Example 2:

		1
	  /   \
	 2     3	
    /     / \
   4     5   6
        /
       7

Input: root = [1,2,3,4,null,5,6,null,null,7]
Output: 7
 

Constraints:

The number of nodes in the tree is in the range [1, 10^4].
-2^31 <= Node.val <= 2^31 - 1 
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
    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        
        while(!q.isEmpty()){
            root = q.poll();
            if(root.right != null){
                q.add(root.right);
            }
            if(root.left != null){
                q.add(root.left);
            }
        }
        return root.val;
    }
}
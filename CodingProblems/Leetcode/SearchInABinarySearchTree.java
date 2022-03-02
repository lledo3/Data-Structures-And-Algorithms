/*
You are given the root of a binary search tree (BST) and an integer val.

Find the node in the BST that the node's value equals val and return the subtree rooted with that node. If such a node does not exist, return null.

Example 1:

	   4
      / \
    2    7
   / \ 
  1   3 

Input: root = [4,2,7,1,3], val = 2
Output: [2,1,3]

Example 2:

   	   4
      / \
    2    7
   / \ 
  1   3 

Input: root = [4,2,7,1,3], val = 5
Output: []
 

Constraints:

The number of nodes in the tree is in the range [1, 5000].
1 <= Node.val <= 10^7
root is a binary search tree.
1 <= val <= 10^7
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
    //recursive
    public TreeNode searchBST(TreeNode root, int val) {
        if(root == null) return root;
        if(root.val == val) return root;
        
        if(root.val > val){
            return searchBST(root.left, val);
        }else{
            return searchBST(root.right, val);
        }
    }

    //iterative
    public TreeNode searchBST(TreeNode root, int val) {
        TreeNode curr = root;
        
        while(curr != null){
            if(curr.val == val){
                return curr;
            }
            if(curr.val > val){
                curr = curr.left;
            }else{
                curr =curr.right;
            }
        }
        return null;
    }
}
/*
Given two integer arrays inorder and postorder where inorder is the inorder traversal of a 
binary tree and postorder is the postorder traversal of the same tree, construct and return the binary tree.

Example 1:

Input: inorder = [9,3,15,20,7], postorder = [9,15,7,20,3]
Output: [3,9,20,null,null,15,7]

Example 2:

Input: inorder = [-1], postorder = [-1]
Output: [-1]
 

Constraints:

1 <= inorder.length <= 3000
postorder.length == inorder.length
-3000 <= inorder[i], postorder[i] <= 3000
inorder and postorder consist of unique values.
Each value of postorder also appears in inorder.
inorder is guaranteed to be the inorder traversal of the tree.
postorder is guaranteed to be the postorder traversal of the tree.
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
    private HashMap<Integer, Integer> map;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        map = new HashMap<>();
        for (int i=0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return buildTreeDfs(inorder, 0, inorder.length-1, postorder, 0, postorder.length-1);
    }
    private TreeNode buildTreeDfs(int[] inorder, int inStart, int inEnd, int[] postorder, int postStart, int postEnd) {
        //base case: no elements
        if (postStart > postEnd)return null;
        //build current node
        int val = postorder[postEnd];
        int idx = 0;
        idx = map.get(val);

        TreeNode curr = new TreeNode(val);
        //build right tree
        curr.right = buildTreeDfs(inorder, idx+1, inEnd, postorder, postEnd-inEnd+idx, postEnd - 1);
        //build left tree
        curr.left = buildTreeDfs(inorder, inStart, idx-1, postorder, postStart, postEnd-inEnd+idx-1);
        return curr;
    }
}
/*
Given a binary tree, return the sum of all left leaves of the tree. Ex: Given the following tree…

    5
   / \
  2   12
     /  \
    3    8
return 5 (i.e. 2 + 3)
Ex: Given the following tree…

       2
      / \
    4    2
   / \ 
  3   9 
return 3
*/
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public int sumLeftLeaves(TreeNode root) {
    if(root == null) {
        return 0;
    } else if(root.left != null && root.left.left == null && root.left.right == null) {
        return root.left.val + sumLeftLeaves(root.right);
    } else {
        return sumLeftLeaves(root.left) + sumLeftLeaves(root.right);
    }
}
/*
ig-O Analysis
Runtime: O(N) where N is the number of nodes in our tree. 
Space complexity: O(N) where N is the number of nodes in our tree.
*/
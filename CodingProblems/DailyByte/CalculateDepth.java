/*
Given a binary tree, return its maximum depth.
Note: the maximum depth is defined as the number of nodes along the longest path from root node to leaf node.

Ex: Given the following tree…

    9
   / \
  1   2
return 2
Ex: Given the following tree…

    5
   / \
  1  29
    /  \
   4   13

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
public int calculateDepth(TreeNode root) {
    if(root == null) {
        return 0;
    }

    int left = maxDepth(root.left);
    int right = maxDepth(root.right);
    return Math.max(left, right) + 1;
}
/*
Big-O Analysis
Runtime: O(N) where N is the number of nodes in our tree.
Space complexity: O(N) where N is the number of nodes in our tree.
*/
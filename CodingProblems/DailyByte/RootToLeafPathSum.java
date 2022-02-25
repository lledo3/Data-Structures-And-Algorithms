/*
Given a binary tree and a target, return whether or not there exists a root to leaf path such that all values along the path sum to the target.

Ex: Given the following tree…

      1
     / \
    5   2
   /   / \
  1  12   29
and a target of 15, return true as the path 1->2->12 sums to 15.
Ex: Given the following tree…

     104
    /   \
  39     31
 / \    /  \
32  1  9    10
and a target of 175, return true as the path 104->39->32 sums to 175.
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
public boolean hasPathSum(TreeNode root, int target) {
    if(root == null) {
        return false;
    }

    return hasPathSum(root, target, 0);
}

public boolean hasPathSum(TreeNode root, int target, int sum) {
    if(root == null) {
        return false;
    } else if(root.left == null && root.right == null && sum + root.val == target) {
        return true;
    } else {
        return hasPathSum(root.left, target, sum + root.val) || hasPathSum(root.right, target, sum + root.val);
    }
}
/*
Big-O Analysis
Runtime: O(N) where N is the number of nodes in our tree.
Space complexity: O(N) where N is the number of nodes in our tree.
*/
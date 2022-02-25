/*
iven a binary search tree that contains unique values and two nodes within the tree, a, and b, return their lowest common ancestor.
Note: the lowest common ancestor of two nodes is the deepest node within the tree such that both nodes are descendants of it.

Ex: Given the following tree...
       7
      / \
    2    9
   / \ 
  1   5 
and a = 1, b = 9, return a reference to the node containing 7.

Ex: Given the following tree...
        8
       / \
      3   9
       / \ 
      2   6
and a = 2, b = 6, return a reference to the node containing 3.

Ex: Given the following tree...
        8
       / \
      6   9
and a = 6, b = 8, return a reference to the node containing 8.
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
public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    if(p.val < root.val && q.val < root.val) {
        return lowestCommonAncestor(root.left, p, q);
    } else if(p.val > root.val && q.val > root.val) {
        return lowestCommonAncestor(root.right, p, q);
    } else {
        return root;
    }
}
/*
Big-O Analysis
Runtime: O(log(N)) where N is the number of nodes in our tree (assuming our tree is balanced). 
Space complexity: O(log(N)) where N is the number of nodes in our tree (assuming our tree is balanced).
*/
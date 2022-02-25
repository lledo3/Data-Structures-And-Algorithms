/*
Given two binary trees, return whether or not the two trees are identical. 
Note: identical meaning they exhibit the same structure and the same values at each node.

Ex: Given the following trees...

        2
       / \
      1   3

        2
       / \
      1   3
return true.
Ex: Given the following trees...

        1
         \
          9
           \
           18

        1
       /
      9
       \
        18
return false.
Ex: Given the following trees...

        2
       / \
      3   1

        2
       / \
      1   3
return false. 
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
public boolean areIdentical(TreeNode p, TreeNode q) {
    if(p == null && q == null) {
        return true;
    } else if(p == null || q == null) {
        return false;
    } else if(p.val != q.val) {
        return false;
    } else {
        return areIdentical(p.left, q.left) && areIdentical(p.right, q.right);
    }
}
/*
Big-O Analysis
Runtime: O(N) where N is the total number of nodes between p and q
Space complexity: O(N) where N is the total number of nodes between p and q (due to our recursive calls).
*/
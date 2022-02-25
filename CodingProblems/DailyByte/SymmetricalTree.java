/*
Given a binary tree, return whether or not it forms a reflection across its center (i.e. a line drawn straight down starting from the root).
Note: a reflection is when an image, flipped across a specified line, forms the same image.

Ex: Given the following tree…

   2
 /   \
1     1
return true as when the tree is reflected across its center all the nodes match.
Ex: Given the following tree…

    1
   / \
  5   5
   \    \
    7    7
return false as when the tree is reflected across its center the nodes containing sevens do not match.
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
public boolean isSymmetric(TreeNode root) {
    if(root == null) {
        return true;
    }

    return isSymmetric(root.left, root.right);
}

public boolean isSymmetric(TreeNode left, TreeNode right) {
    if(left == null || right == null) {
        return left == right;
    }

    if(left.val != right.val) {
        return false;
    }

    return isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);
}
/*
Big-O Analysis
Runtime: O(N) where N is the number of nodes in our tree.
Space complexity: O(N) where N is the number of nodes in our tree.
*/
/*
Given the reference to the root of a binary search tree and a search value, return the reference to the node that contains 
the value if it exists and null otherwise.
Note: all values in the binary search tree will be unique.

Ex: Given the following tree...

        3
       / \
      1   4
and the search value 1 return a reference to the node containing 1.
Ex: Given the following tree...

        7
       / \
      5   9
         / \ 
        8   10
and the search value 9 return a reference to the node containing 9.
Ex: Given the tree

        8
       / \
      6   9
and the search value 7 return null.
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
public TreeNode findValue(TreeNode root, int val) {
    if(root == null) {
        return null;
    } else if(root.val == val) {
        return root;
    } else if(val < root.val) {
        return findValue(root.left, val);
    } else {
        return findValue(root.right, val);
    }
}
/*
Big-O Analysis
Runtime: O(log(N)) where N is the number of nodes in our binary search tree (assuming our tree is balanced).
Space complexity: O(log(N)) where N is the number of nodes in our binary search tree (assuming our tree is balanced). 
This extra space is as a result of the recursive calls on the stack.
*/